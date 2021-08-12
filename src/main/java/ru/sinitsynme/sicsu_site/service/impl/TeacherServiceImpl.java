package ru.sinitsynme.sicsu_site.service.impl;

import org.springframework.data.domain.Page;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import ru.sinitsynme.sicsu_site.rest.dto.TeacherResponseDto;
import ru.sinitsynme.sicsu_site.service.TeacherService;

import java.util.UUID;

@Service
@Transactional
public class TeacherServiceImpl implements TeacherService {
    @Override
    public TeacherResponseDto deleteTeacher(UUID teacherId) {
        return null;
    }

    @Override
    public TeacherResponseDto getTeacher(UUID teacherId) {
        return null;
    }

    @Override
    public Page<TeacherResponseDto> filterAllTeachers(String firstNameSymbols, String lastNameSymbols, String departmentNameSymbols) {
        return null;
    }

    @Override
    public TeacherResponseDto addTeacherToDepartment(UUID teacherId, UUID departmentId) {
        return null;
    }

    @Override
    public TeacherResponseDto removeTeacherFromDepartment(UUID teacherId) {
        return null;
    }

    @Override
    public Page<TeacherResponseDto> getAllTeachersFromDepartment(UUID departmentId) {
        return null;
    }
}
