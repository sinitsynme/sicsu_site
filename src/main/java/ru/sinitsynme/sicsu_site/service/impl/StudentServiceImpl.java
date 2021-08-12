package ru.sinitsynme.sicsu_site.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import ru.sinitsynme.sicsu_site.entity.GroupEntity;
import ru.sinitsynme.sicsu_site.entity.StudentEntity;
import ru.sinitsynme.sicsu_site.mapper.StudentMapper;
import ru.sinitsynme.sicsu_site.repository.GroupRepository;
import ru.sinitsynme.sicsu_site.repository.StudentRepository;
import ru.sinitsynme.sicsu_site.rest.dto.StudentResponseDto;
import ru.sinitsynme.sicsu_site.service.StudentService;

import java.util.UUID;

@Service
@Transactional
public class StudentServiceImpl implements StudentService {

    private final StudentMapper studentMapper;
    private final StudentRepository studentRepository;
    private final GroupRepository groupRepository;

    @Autowired
    public StudentServiceImpl(StudentMapper studentMapper, StudentRepository studentRepository, GroupRepository groupRepository) {
        this.studentMapper = studentMapper;
        this.studentRepository = studentRepository;
        this.groupRepository = groupRepository;
    }

    @Override
    public void deleteStudent(UUID studentId) {
        studentRepository.deleteById(studentId);
    }

    @Override
    public StudentResponseDto getStudent(UUID studentId) {
        return studentMapper.toResponseDto(studentRepository.getOne(studentId));
    }

    @Override
    public Page<StudentResponseDto> filterAllStudents(String firstNameSymbols, String lastNameSymbols, String groupFullIdSymbols) {
        return studentRepository.filterStudents(firstNameSymbols, lastNameSymbols, groupFullIdSymbols, PageRequest.of(0, 50, Sort.by("lastName"))).map(studentMapper::toResponseDto);
    }

    @Override
    public StudentResponseDto addStudentToGroup(UUID studentId, UUID groupId) {
        GroupEntity group = groupRepository.getOne(groupId);
        StudentEntity student = studentRepository.getOne(studentId);

        student.setGroup(group);
        return studentMapper.toResponseDto(studentRepository.save(student));

    }

    @Override
    public StudentResponseDto removeStudentFromGroup(UUID studentId) {
        StudentEntity student = studentRepository.getOne(studentId);
        student.setGroup(null);
        return studentMapper.toResponseDto(studentRepository.save(student));
    }

    @Override
    public Page<StudentResponseDto> getAllStudentsFromGroup(UUID groupId) {
        return studentRepository.findAllByGroup(groupRepository.getOne(groupId), PageRequest.of(0, 30, Sort.by("lastName"))).map(studentMapper::toResponseDto);
    }
}
