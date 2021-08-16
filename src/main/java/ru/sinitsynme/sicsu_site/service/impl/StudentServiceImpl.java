package ru.sinitsynme.sicsu_site.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import ru.sinitsynme.sicsu_site.entity.GroupEntity;
import ru.sinitsynme.sicsu_site.entity.StudentEntity;
import ru.sinitsynme.sicsu_site.mapper.StudentMapper;
import ru.sinitsynme.sicsu_site.rest.dto.StudentResponseDto;
import ru.sinitsynme.sicsu_site.service.StudentService;
import ru.sinitsynme.sicsu_site.service.entityservice.GroupEntityService;
import ru.sinitsynme.sicsu_site.service.entityservice.StudentEntityService;

import java.util.UUID;

@Service
@Transactional
public class StudentServiceImpl implements StudentService {

    private final StudentMapper studentMapper;
    private final StudentEntityService studentEntityService;
    private final GroupEntityService groupEntityService;

    @Autowired
    public StudentServiceImpl(StudentMapper studentMapper, StudentEntityService studentEntityService, GroupEntityService groupEntityService) {
        this.studentMapper = studentMapper;
        this.studentEntityService = studentEntityService;
        this.groupEntityService = groupEntityService;
    }

    @Override
    public void deleteStudent(UUID studentId) {
        studentEntityService.deleteEntityById(studentId);
    }

    @Override
    public StudentResponseDto getStudent(UUID studentId) {
        return studentMapper.toResponseDto(studentEntityService.getEntity(studentId));
    }

    @Override
    public Page<StudentResponseDto> filterAllStudents(String firstNameSymbols, String lastNameSymbols, String groupFullIdSymbols) {
        return studentEntityService.filterAllStudents(firstNameSymbols, lastNameSymbols, groupFullIdSymbols, PageRequest.of(0, 50, Sort.by("personalData")))
                .map(studentMapper::toResponseDto);
    }

    @Override
    public StudentResponseDto addStudentToGroup(UUID studentId, UUID groupId) {
        GroupEntity group = groupEntityService.getEntity(groupId);
        StudentEntity student = studentEntityService.getEntity(studentId);

        student.setGroup(group);
        return studentMapper.toResponseDto(studentEntityService.saveEntity(student));

    }

    @Override
    public StudentResponseDto removeStudentFromGroup(UUID studentId) {
        StudentEntity student = studentEntityService.getEntity(studentId);
        student.setGroup(null);
        return studentMapper.toResponseDto(studentEntityService.saveEntity(student));
    }

    @Override
    public Page<StudentResponseDto> getAllStudentsFromGroup(UUID groupId) {
        return studentEntityService.findAllByGroup(groupEntityService.getEntity(groupId),
                PageRequest.of(0, 30, Sort.by("lastName"))).map(studentMapper::toResponseDto);
    }
}
