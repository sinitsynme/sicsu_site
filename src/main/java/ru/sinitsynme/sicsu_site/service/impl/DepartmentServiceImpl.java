package ru.sinitsynme.sicsu_site.service.impl;

import org.springframework.data.domain.Page;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import ru.sinitsynme.sicsu_site.rest.dto.DepartmentRequestDto;
import ru.sinitsynme.sicsu_site.rest.dto.DepartmentResponseDto;
import ru.sinitsynme.sicsu_site.service.DepartmentService;

import java.util.UUID;

@Service
@Transactional
public class DepartmentServiceImpl implements DepartmentService {
    @Override
    public DepartmentResponseDto saveDepartment(DepartmentRequestDto requestDto) {
        return null;
    }

    @Override
    public DepartmentResponseDto editDepartment(DepartmentRequestDto requestDto, UUID departmentId) {
        return null;
    }

    @Override
    public DepartmentResponseDto deleteDepartment(UUID departmentId) {
        return null;
    }

    @Override
    public DepartmentResponseDto getDepartment(UUID departmentId) {
        return null;
    }

    @Override
    public DepartmentResponseDto addDepartmentToFaculty(UUID departmentId, UUID facultyId) {
        return null;
    }

    @Override
    public DepartmentResponseDto removeDepartmentFromFaculty(UUID departmentId) {
        return null;
    }

    @Override
    public Page<DepartmentResponseDto> getAllDepartmentsFromFaculty(UUID facultyId) {
        return null;
    }
}
