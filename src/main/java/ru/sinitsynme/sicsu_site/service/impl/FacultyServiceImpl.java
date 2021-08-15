package ru.sinitsynme.sicsu_site.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import ru.sinitsynme.sicsu_site.entity.FacultyEntity;
import ru.sinitsynme.sicsu_site.exception.ResourceNotFoundException;
import ru.sinitsynme.sicsu_site.mapper.FacultyMapper;
import ru.sinitsynme.sicsu_site.rest.dto.FacultyRequestDto;
import ru.sinitsynme.sicsu_site.rest.dto.FacultyResponseDto;
import ru.sinitsynme.sicsu_site.service.FacultyService;
import ru.sinitsynme.sicsu_site.service.entityservice.FacultyEntityService;

import java.util.UUID;

@Service
@Transactional
public class FacultyServiceImpl implements FacultyService {

    private final FacultyEntityService facultyEntityService;
    private final FacultyMapper facultyMapper;

    @Autowired
    public FacultyServiceImpl(FacultyEntityService facultyEntityService, FacultyMapper facultyMapper) {
        this.facultyEntityService = facultyEntityService;
        this.facultyMapper = facultyMapper;
    }

    @Override
    public FacultyResponseDto saveFaculty(FacultyRequestDto requestDto) {
        return facultyMapper.toResponseDto(facultyEntityService.saveEntity(new FacultyEntity(requestDto.getName())));
    }

    @Override
    public FacultyResponseDto editFaculty(FacultyRequestDto requestDto, UUID facultyId) {
        FacultyEntity facultyEntity = facultyEntityService.getEntity(facultyId);
        facultyEntity.setName(requestDto.getName());
        return facultyMapper.toResponseDto(facultyEntityService.saveEntity(facultyEntity));
    }

    @Override
    public void deleteFaculty(UUID facultyId) {
        if(!facultyEntityService.existsById(facultyId)){
           throw new ResourceNotFoundException(String.format("Faculty with ID = %s wasn't found", facultyId));
        }
        facultyEntityService.deleteEntityById(facultyId);
    }

    @Override
    public FacultyResponseDto getFaculty(UUID facultyId) {
        return facultyMapper.toResponseDto(facultyEntityService.getEntity(facultyId));
    }

    @Override
    public Page<FacultyResponseDto> getAllFaculties() {
        return facultyEntityService.getAllEntities(PageRequest.of(0, 15)).map(facultyMapper::toResponseDto);
    }
}
