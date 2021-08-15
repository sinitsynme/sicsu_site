package ru.sinitsynme.sicsu_site.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import ru.sinitsynme.sicsu_site.entity.PersonalDataEntity;
import ru.sinitsynme.sicsu_site.entity.StudentEntity;
import ru.sinitsynme.sicsu_site.entity.TeacherEntity;
import ru.sinitsynme.sicsu_site.entity.UserEntity;
import ru.sinitsynme.sicsu_site.enums.UserRole;
import ru.sinitsynme.sicsu_site.exception.ResourceNotFoundException;
import ru.sinitsynme.sicsu_site.mapper.PersonalDataMapper;
import ru.sinitsynme.sicsu_site.mapper.UserMapper;
import ru.sinitsynme.sicsu_site.rest.dto.PersonalDataRequestDto;
import ru.sinitsynme.sicsu_site.rest.dto.UserResponseDto;
import ru.sinitsynme.sicsu_site.service.UserService;
import ru.sinitsynme.sicsu_site.service.entityservice.UserEntityService;
import ru.sinitsynme.sicsu_site.util.MailService;
import ru.sinitsynme.sicsu_site.util.UtilHelper;

import javax.mail.MessagingException;
import java.util.UUID;

@Service
@Transactional
public class UserServiceImpl implements UserService {

    private final UserEntityService userEntityService;
    private final PersonalDataMapper personalDataMapper;
    private final UserMapper userMapper;
    private final MailService mailService;
    private final PasswordEncoder passwordEncoder;

    @Autowired
    public UserServiceImpl(UserEntityService userEntityService, PersonalDataMapper personalDataMapper, UserMapper userMapper, MailService mailService, PasswordEncoder passwordEncoder) {
        this.userEntityService = userEntityService;
        this.personalDataMapper = personalDataMapper;
        this.userMapper = userMapper;
        this.mailService = mailService;
        this.passwordEncoder = passwordEncoder;
    }

    @Override
    public UserResponseDto registerUser(PersonalDataRequestDto dto, UserRole role) throws MessagingException {
        UserEntity user = new UserEntity();
        PersonalDataEntity personalData = personalDataMapper.toEntity(dto);
        formUsername(user, personalData);
        String tempPassword = UtilHelper.generatePassword(10);
        user.setPassword(passwordEncoder.encode(tempPassword));
        user.setPersonalData(personalData);
        user.getRoles().add(role);
        if(role == UserRole.ROLE_STUDENT){
            StudentEntity studentEntity = new StudentEntity();
            studentEntity.setPersonalData(personalData);
            user.setStudent(studentEntity);
        }
        if(role == UserRole.ROLE_TEACHER){
            TeacherEntity teacherEntity = new TeacherEntity();
            teacherEntity.setPersonalData(personalData);
            user.setTeacher(teacherEntity);
        }
        userEntityService.saveEntity(user);
        mailService.sendGreetingMessage(personalData.getEmail(), user.getUsername(), tempPassword);
        return userMapper.toResponseDto(user);
    }

    @Override
    public UserResponseDto getUser(UUID userId) {
        return userMapper.toResponseDto(userEntityService
                .getEntity(userId));
    }

    @Override
    public UserResponseDto editUser(PersonalDataRequestDto dto, UUID userId) {
        UserEntity userFromDb = userEntityService.getEntity(userId);
        PersonalDataEntity personalData = personalDataMapper.toEntity(dto);
        userFromDb.setPersonalData(personalData);
        formUsername(userFromDb, personalData);

        return userMapper.toResponseDto(userEntityService.saveEntity(userFromDb));
    }

    @Override
    public void deleteUser(UUID userId) {
        if(!userEntityService.existsById(userId)){
            throw new ResourceNotFoundException(String.format("User with ID = %s was not found", userId));
        }
        userEntityService.deleteEntityById(userId);
    }

    @Override
    public boolean tryToChangePassword(UUID userId, String oldPassword, String newPassword) {
        UserEntity userFromDb = userEntityService.getEntity(userId);
        if(!passwordEncoder.matches(oldPassword, userFromDb.getPassword())){
            return false;
        }
        userFromDb.setPassword(passwordEncoder.encode(newPassword));
        userEntityService.saveEntity(userFromDb);
        return true;
    }

    @Override
    public void changePassword(UUID userId, String newPassword) {
        UserEntity userFromDb = userEntityService.getEntity(userId);
        userFromDb.setPassword(passwordEncoder.encode(newPassword));
        userEntityService.saveEntity(userFromDb);
    }

    private void formUsername(UserEntity user, PersonalDataEntity personalData) {
        user.setUsername(UtilHelper.formLogin(personalData.getFirstName(), personalData.getLastName()));
    }
}
