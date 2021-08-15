package ru.sinitsynme.sicsu_site.service.entityservice.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import ru.sinitsynme.sicsu_site.entity.GroupEntity;
import ru.sinitsynme.sicsu_site.entity.StudentEntity;
import ru.sinitsynme.sicsu_site.exception.ResourceNotFoundException;
import ru.sinitsynme.sicsu_site.repository.StudentRepository;
import ru.sinitsynme.sicsu_site.service.entityservice.StudentEntityService;

import java.util.UUID;

@Service
public class StudentEntityServiceImpl implements StudentEntityService {

    private final StudentRepository studentRepository;

    @Autowired
    public StudentEntityServiceImpl(StudentRepository studentRepository) {
        this.studentRepository = studentRepository;
    }

    @Override
    public StudentEntity getEntity(UUID uuid) {
        return studentRepository
                .findById(uuid)
                .orElseThrow(() -> new ResourceNotFoundException(String.format("Student with ID = %s was not found", uuid)));
    }

    @Override
    public StudentEntity saveEntity(StudentEntity entity) {
        return studentRepository.save(entity);
    }

    @Override
    public void deleteEntityById(UUID entityId) {
        studentRepository.deleteById(entityId);
    }

    @Override
    public Page<StudentEntity> getAllEntities(Pageable pageable) {
        return studentRepository.findAll(pageable);
    }

    @Override
    public boolean existsById(UUID uuid) {
        return studentRepository.existsById(uuid);
    }

    @Override
    public Page<StudentEntity> findAllByGroup(GroupEntity groupEntity, Pageable pageable) {
        return studentRepository.findAllByGroup(groupEntity, pageable);
    }

    @Override
    public Page<StudentEntity> filterAllStudents(String firstNameSymbols, String lastNameSymbols, String groupFullIdSymbols, Pageable pageable) {
        return studentRepository.filterStudents(firstNameSymbols, lastNameSymbols, groupFullIdSymbols, pageable);
    }
}
