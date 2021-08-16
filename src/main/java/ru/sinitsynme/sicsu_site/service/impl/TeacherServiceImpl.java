package ru.sinitsynme.sicsu_site.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import ru.sinitsynme.sicsu_site.entity.DepartmentEntity;
import ru.sinitsynme.sicsu_site.entity.TeacherEntity;
import ru.sinitsynme.sicsu_site.exception.ResourceNotFoundException;
import ru.sinitsynme.sicsu_site.mapper.TeacherMapper;
import ru.sinitsynme.sicsu_site.rest.dto.TeacherResponseDto;
import ru.sinitsynme.sicsu_site.service.TeacherService;
import ru.sinitsynme.sicsu_site.service.entityservice.DepartmentEntityService;
import ru.sinitsynme.sicsu_site.service.entityservice.TeacherEntityService;
import ru.sinitsynme.sicsu_site.util.UtilHelper;

import java.util.UUID;

@Service
@Transactional
public class TeacherServiceImpl implements TeacherService {

    private final TeacherEntityService teacherEntityService;
    private final TeacherMapper teacherMapper;
    private final DepartmentEntityService departmentEntityService;

    @Autowired
    public TeacherServiceImpl(TeacherEntityService teacherEntityService, TeacherMapper teacherMapper, DepartmentEntityService departmentEntityService) {
        this.teacherEntityService = teacherEntityService;
        this.teacherMapper = teacherMapper;
        this.departmentEntityService = departmentEntityService;
    }

    @Override
    public void deleteTeacher(UUID teacherId) {
        if(!teacherEntityService.existsById(teacherId)){
            throw new ResourceNotFoundException(String.format("Teacher with ID = %s wasn't found", teacherId));
        }
        teacherEntityService.deleteEntityById(teacherId);
    }

    @Override
    public TeacherResponseDto getTeacher(UUID teacherId) {
        return teacherMapper.toResponseDto(teacherEntityService.getEntity(teacherId));
    }

    @Override
    public Page<TeacherResponseDto> filterAllTeachers(String firstNameSymbols, String lastNameSymbols, String departmentNameSymbols) {
        return teacherEntityService.filterTeachers(firstNameSymbols, lastNameSymbols, departmentNameSymbols,
                PageRequest.of(0, 50, Sort.by("personalData"))).map(teacherMapper::toResponseDto);
    }

    @Override
    public TeacherResponseDto addTeacherToDepartment(UUID teacherId, UUID departmentId) {
        TeacherEntity teacherEntity = teacherEntityService.getEntity(teacherId);
        DepartmentEntity departmentEntity = departmentEntityService.getEntity(departmentId);
        teacherEntity.setDepartment(departmentEntity);
        return teacherMapper.toResponseDto(teacherEntityService.saveEntity(teacherEntity));
    }

    @Override
    public TeacherResponseDto removeTeacherFromDepartment(UUID teacherId) {
        TeacherEntity teacherEntity = teacherEntityService.getEntity(teacherId);
        teacherEntity.setDepartment(null);
        return teacherMapper.toResponseDto(teacherEntityService.saveEntity(teacherEntity));
    }

    @Override
    public Page<TeacherResponseDto> getAllTeachersFromDepartment(UUID departmentId) {
        DepartmentEntity departmentEntity = departmentEntityService.getEntity(departmentId);
        return UtilHelper.convertListToPage(departmentEntity.getTeacherList(), 25, "personalData")
                .map(teacherMapper::toResponseDto);
    }
}
