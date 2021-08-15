package ru.sinitsynme.sicsu_site.service;

import org.springframework.data.domain.Page;
import ru.sinitsynme.sicsu_site.rest.dto.TeacherResponseDto;

import java.util.UUID;

public interface TeacherService {

    void deleteTeacher(UUID teacherId);

    TeacherResponseDto getTeacher(UUID teacherId);

    Page<TeacherResponseDto> filterAllTeachers(String firstNameSymbols, String lastNameSymbols,
                                               String departmentNameSymbols);

    TeacherResponseDto addTeacherToDepartment(UUID teacherId, UUID departmentId);

    TeacherResponseDto removeTeacherFromDepartment(UUID teacherId);

    Page<TeacherResponseDto> getAllTeachersFromDepartment(UUID departmentId);


}
