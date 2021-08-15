package ru.sinitsynme.sicsu_site.service.entityservice.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import ru.sinitsynme.sicsu_site.entity.ProgramEntity;
import ru.sinitsynme.sicsu_site.exception.ResourceNotFoundException;
import ru.sinitsynme.sicsu_site.repository.ProgramRepository;
import ru.sinitsynme.sicsu_site.service.entityservice.ProgramEntityService;

import java.util.UUID;

@Service
public class ProgramEntityServiceImpl implements ProgramEntityService {

    private final ProgramRepository programRepository;

    @Autowired
    public ProgramEntityServiceImpl(ProgramRepository programRepository) {
        this.programRepository = programRepository;
    }

    @Override
    public ProgramEntity getEntity(UUID uuid) {
        return programRepository.findById(uuid).orElseThrow(
                () -> new ResourceNotFoundException(String.format("Program with ID = %s wasn't found", uuid))
        );
    }

    @Override
    public ProgramEntity saveEntity(ProgramEntity entity) {
        return programRepository.save(entity);
    }

    @Override
    public void deleteEntityById(UUID entityId) {
        programRepository.deleteById(entityId);
    }

    @Override
    public Page<ProgramEntity> getAllEntities(Pageable pageable) {
        return programRepository.findAll(pageable);
    }

    @Override
    public boolean existsById(UUID uuid) {
        return programRepository.existsById(uuid);
    }
}
