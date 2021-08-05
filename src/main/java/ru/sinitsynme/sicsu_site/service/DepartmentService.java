package ru.sinitsynme.sicsu_site.service;

import org.springframework.data.domain.Page;
import ru.sinitsynme.sicsu_site.rest.dto.DepartmentRequestDto;
import ru.sinitsynme.sicsu_site.rest.dto.DepartmentResponseDto;

import java.util.UUID;

public interface DepartmentService {

    DepartmentResponseDto saveDepartment(DepartmentRequestDto requestDto);

    DepartmentResponseDto editDepartment(DepartmentRequestDto requestDto, UUID departmentId);

    DepartmentResponseDto deleteDepartment(UUID departmentId);

    DepartmentResponseDto getDepartment(UUID departmentId);

    DepartmentResponseDto addDepartmentToFaculty(UUID departmentId, UUID facultyId);

    DepartmentResponseDto removeDepartmentFromFaculty(UUID departmentId);

    Page<DepartmentResponseDto> getAllDepartmentsFromFaculty(UUID facultyId);

}
