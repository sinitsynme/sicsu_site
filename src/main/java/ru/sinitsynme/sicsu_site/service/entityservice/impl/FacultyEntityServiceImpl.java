package ru.sinitsynme.sicsu_site.service.entityservice.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import ru.sinitsynme.sicsu_site.entity.FacultyEntity;
import ru.sinitsynme.sicsu_site.exception.ResourceNotFoundException;
import ru.sinitsynme.sicsu_site.repository.FacultyRepository;
import ru.sinitsynme.sicsu_site.service.entityservice.FacultyEntityService;

import java.util.UUID;

@Service
public class FacultyEntityServiceImpl implements FacultyEntityService {

    private final FacultyRepository facultyRepository;

    @Autowired
    public FacultyEntityServiceImpl(FacultyRepository facultyRepository) {
        this.facultyRepository = facultyRepository;
    }

    @Override
    public FacultyEntity getEntity(UUID facultyId) {
        return facultyRepository.findById(facultyId).orElseThrow(
                () -> new ResourceNotFoundException(String.format("Faculty with ID = %s wasn't found", facultyId))
        );
    }

    @Override
    public FacultyEntity saveEntity(FacultyEntity entity) {
        return facultyRepository.save(entity);
    }

    @Override
    public void deleteEntityById(UUID facultyId) {
        facultyRepository.deleteById(facultyId);
    }

    @Override
    public Page<FacultyEntity> getAllEntities(Pageable pageable) {
        return facultyRepository.findAll(pageable);
    }

    @Override
    public boolean existsById(UUID uuid) {
        return facultyRepository.existsById(uuid);
    }
}
