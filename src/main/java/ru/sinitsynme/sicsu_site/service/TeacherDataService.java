package ru.sinitsynme.sicsu_site.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import ru.sinitsynme.sicsu_site.entity.TeacherData;
import ru.sinitsynme.sicsu_site.repository.TeacherDataRepository;
import ru.sinitsynme.sicsu_site.entity.User;

import java.util.Optional;


@Service
public class TeacherDataService {

    private final TeacherDataRepository teacherDataRepository;
    private final UserService userService;

    @Autowired
    public TeacherDataService(
            TeacherDataRepository teacherDataRepository,
            UserService userService) {
        this.teacherDataRepository = teacherDataRepository;
        this.userService = userService;
    }

    public Optional<TeacherData> getTeacherById(Long id) {
        return teacherDataRepository.findById(id);
    }

    public boolean registerTeacher(TeacherData teacherData, Long userId) {
        Optional<User> userOptional = userService.getUserById(userId);
        if (userOptional.isPresent()) {
            User user = userOptional.get();
            user.setActive(true);
            user.setTeacherData(teacherData);
            teacherData.setUser(user);

            teacherDataRepository.save(teacherData);
            userService.saveUser(user);
            return true;
        }
        return false;
    }


}
