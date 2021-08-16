package ru.sinitsynme.sicsu_site.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import ru.sinitsynme.sicsu_site.entity.DepartmentEntity;
import ru.sinitsynme.sicsu_site.entity.FacultyEntity;
import ru.sinitsynme.sicsu_site.exception.ResourceNotFoundException;
import ru.sinitsynme.sicsu_site.mapper.DepartmentMapper;
import ru.sinitsynme.sicsu_site.rest.dto.DepartmentRequestDto;
import ru.sinitsynme.sicsu_site.rest.dto.DepartmentResponseDto;
import ru.sinitsynme.sicsu_site.service.DepartmentService;
import ru.sinitsynme.sicsu_site.service.entityservice.DepartmentEntityService;
import ru.sinitsynme.sicsu_site.service.entityservice.FacultyEntityService;
import ru.sinitsynme.sicsu_site.util.UtilHelper;

import java.util.UUID;

@Service
@Transactional
public class DepartmentServiceImpl implements DepartmentService {

    private final DepartmentEntityService departmentEntityService;
    private final FacultyEntityService facultyEntityService;
    private final DepartmentMapper departmentMapper;

    @Autowired
    public DepartmentServiceImpl(DepartmentEntityService departmentEntityService, FacultyEntityService facultyEntityService, DepartmentMapper departmentMapper) {
        this.departmentEntityService = departmentEntityService;
        this.facultyEntityService = facultyEntityService;
        this.departmentMapper = departmentMapper;
    }

    @Override
    public DepartmentResponseDto saveDepartment(DepartmentRequestDto requestDto) {
        return departmentMapper.toResponseDto(departmentEntityService.saveEntity(new DepartmentEntity(requestDto.getName())));
    }

    @Override
    public DepartmentResponseDto editDepartment(DepartmentRequestDto requestDto, UUID departmentId) {
        DepartmentEntity departmentFromDb = departmentEntityService.getEntity(departmentId);
        departmentFromDb.setName(requestDto.getName());
        return departmentMapper.toResponseDto(departmentEntityService.saveEntity(departmentFromDb));
    }

    @Override
    public void deleteDepartment(UUID departmentId) {
        if(!departmentEntityService.existsById(departmentId)){
            throw new ResourceNotFoundException(String.format("Department with ID = %s was not found", departmentId));
        }
        departmentEntityService.deleteEntityById(departmentId);
    }

    @Override
    public DepartmentResponseDto getDepartment(UUID departmentId) {
        return departmentMapper.toResponseDto(departmentEntityService.getEntity(departmentId));
    }

    @Override
    public DepartmentResponseDto addDepartmentToFaculty(UUID departmentId, UUID facultyId) {
        DepartmentEntity departmentEntity = departmentEntityService.getEntity(departmentId);
        FacultyEntity facultyEntity = facultyEntityService.getEntity(facultyId);

        facultyEntity.getDepartments().add(departmentEntity);
        facultyEntityService.saveEntity(facultyEntity);
        return departmentMapper.toResponseDto(departmentEntity);
    }

    @Override
    public DepartmentResponseDto removeDepartmentFromFaculty(UUID departmentId) {
        DepartmentEntity departmentEntity = departmentEntityService.getEntity(departmentId);
        departmentEntity.setFaculty(null);
        return departmentMapper.toResponseDto(departmentEntity);
    }

    @Override
    public Page<DepartmentResponseDto> getAllDepartmentsFromFaculty(UUID facultyId) {
        FacultyEntity facultyEntity = facultyEntityService.getEntity(facultyId);

        return UtilHelper.convertListToPage(facultyEntity.getDepartments(), 15, "name")
                .map(departmentMapper::toResponseDto);
    }

}
