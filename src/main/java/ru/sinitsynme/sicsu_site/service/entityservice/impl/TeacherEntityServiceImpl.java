package ru.sinitsynme.sicsu_site.service.entityservice.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import ru.sinitsynme.sicsu_site.entity.TeacherEntity;
import ru.sinitsynme.sicsu_site.exception.ResourceNotFoundException;
import ru.sinitsynme.sicsu_site.repository.TeacherRepository;
import ru.sinitsynme.sicsu_site.service.entityservice.TeacherEntityService;

import java.util.UUID;

@Service
public class TeacherEntityServiceImpl implements TeacherEntityService {

    private final TeacherRepository teacherRepository;

    @Autowired
    public TeacherEntityServiceImpl(TeacherRepository teacherRepository) {
        this.teacherRepository = teacherRepository;
    }

    @Override
    public TeacherEntity getEntity(UUID uuid) {
        return teacherRepository.findById(uuid).orElseThrow(
                () -> new ResourceNotFoundException(String.format("Teacher with ID = %s wasn't found", uuid)));
    }

    @Override
    public TeacherEntity saveEntity(TeacherEntity entity) {
        return teacherRepository.save(entity);
    }

    @Override
    public void deleteEntityById(UUID entityId) {
        teacherRepository.deleteById(entityId);
    }

    @Override
    public Page<TeacherEntity> getAllEntities(Pageable pageable) {
        return teacherRepository.findAll(pageable);
    }

    @Override
    public boolean existsById(UUID uuid) {
        return teacherRepository.existsById(uuid);
    }

    @Override
    public Page<TeacherEntity> filterTeachers(String firstNameSymbols, String lastNameSymbols, String departmentNameSymbols, Pageable pageable) {
        return teacherRepository.filterTeachers(firstNameSymbols, lastNameSymbols, departmentNameSymbols, pageable);
    }
}
