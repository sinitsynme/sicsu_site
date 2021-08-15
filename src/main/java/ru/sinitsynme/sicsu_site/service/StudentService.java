package ru.sinitsynme.sicsu_site.service;

import org.springframework.data.domain.Page;
import ru.sinitsynme.sicsu_site.rest.dto.StudentResponseDto;

import java.util.UUID;

public interface StudentService {

    void deleteStudent(UUID studentId);

    StudentResponseDto getStudent(UUID studentId);

    Page<StudentResponseDto> filterAllStudents(String firstNameSymbols, String lastNameSymbols,
                                               String groupFullIdSymbols);

    StudentResponseDto addStudentToGroup(UUID studentId, UUID groupId);

    StudentResponseDto removeStudentFromGroup(UUID studentId);

    Page<StudentResponseDto> getAllStudentsFromGroup(UUID groupId);

}
