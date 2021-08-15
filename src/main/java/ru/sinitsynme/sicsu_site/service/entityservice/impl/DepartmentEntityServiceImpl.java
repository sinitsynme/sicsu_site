package ru.sinitsynme.sicsu_site.service.entityservice.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import ru.sinitsynme.sicsu_site.entity.DepartmentEntity;
import ru.sinitsynme.sicsu_site.exception.ResourceNotFoundException;
import ru.sinitsynme.sicsu_site.repository.DepartmentRepository;
import ru.sinitsynme.sicsu_site.service.entityservice.DepartmentEntityService;

import java.util.UUID;

@Service
public class DepartmentEntityServiceImpl implements DepartmentEntityService {

    private final DepartmentRepository departmentRepository;

    @Autowired
    public DepartmentEntityServiceImpl(DepartmentRepository departmentRepository) {
        this.departmentRepository = departmentRepository;
    }

    @Override
    public DepartmentEntity getEntity(UUID uuid) {
        return departmentRepository.findById(uuid).orElseThrow(
                () -> new ResourceNotFoundException(String.format("Department with ID = %s was not found", uuid))
        );
    }

    @Override
    public DepartmentEntity saveEntity(DepartmentEntity entity) {
        return departmentRepository.save(entity);
    }

    @Override
    public void deleteEntityById(UUID entityId) {
        departmentRepository.deleteById(entityId);
    }

    @Override
    public Page<DepartmentEntity> getAllEntities(Pageable pageable) {
        return departmentRepository.findAll(pageable);
    }

    @Override
    public boolean existsById(UUID uuid) {
        return departmentRepository.existsById(uuid);
    }
}
