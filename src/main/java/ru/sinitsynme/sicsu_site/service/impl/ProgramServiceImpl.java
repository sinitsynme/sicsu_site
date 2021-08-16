package ru.sinitsynme.sicsu_site.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import ru.sinitsynme.sicsu_site.entity.FacultyEntity;
import ru.sinitsynme.sicsu_site.entity.ProgramEntity;
import ru.sinitsynme.sicsu_site.exception.ResourceNotFoundException;
import ru.sinitsynme.sicsu_site.mapper.ProgramMapper;
import ru.sinitsynme.sicsu_site.rest.dto.ProgramRequestDto;
import ru.sinitsynme.sicsu_site.rest.dto.ProgramResponseDto;
import ru.sinitsynme.sicsu_site.service.ProgramService;
import ru.sinitsynme.sicsu_site.service.entityservice.FacultyEntityService;
import ru.sinitsynme.sicsu_site.service.entityservice.ProgramEntityService;
import ru.sinitsynme.sicsu_site.util.UtilHelper;

import java.util.UUID;

@Service
@Transactional
public class ProgramServiceImpl implements ProgramService {

    private final ProgramMapper programMapper;
    private final ProgramEntityService programEntityService;
    private final FacultyEntityService facultyEntityService;

    @Autowired
    public ProgramServiceImpl(ProgramMapper programMapper, ProgramEntityService programEntityService, FacultyEntityService facultyEntityService) {
        this.programMapper = programMapper;
        this.programEntityService = programEntityService;
        this.facultyEntityService = facultyEntityService;
    }

    @Override
    public ProgramResponseDto saveProgram(ProgramRequestDto requestDto) {
        return programMapper.toResponseDto(
                programEntityService.saveEntity(new ProgramEntity(requestDto.getName(), requestDto.getType())));
    }

    @Override
    public ProgramResponseDto editProgram(ProgramRequestDto requestDto, UUID programId) {
        ProgramEntity programFromDb = programEntityService.getEntity(programId);
        programFromDb.setName(requestDto.getName());
        programFromDb.setType(requestDto.getType());
        return programMapper.toResponseDto(
                programEntityService.saveEntity(programFromDb));
    }

    @Override
    public void deleteProgram(UUID programId) {
        if(!facultyEntityService.existsById(programId)){
            throw new ResourceNotFoundException(String.format("Program with ID = %s wasn't found", programId));
        }
    }

    @Override
    public ProgramResponseDto getProgram(UUID programId) {
        return programMapper.toResponseDto(programEntityService.getEntity(programId));
    }

    @Override
    public Page<ProgramResponseDto> getAllPrograms() {
        return programEntityService.getAllEntities(PageRequest.of(0, 20, Sort.by("type")))
                .map(programMapper::toResponseDto);
    }

    @Override
    public Page<ProgramResponseDto> getAllProgramsFromFaculty(UUID facultyId) {
        FacultyEntity facultyEntity = facultyEntityService.getEntity(facultyId);
        return UtilHelper.convertListToPage(facultyEntity.getProgramList(), 20, "type")
                .map(programMapper::toResponseDto);

    }

    @Override
    public ProgramResponseDto addProgramToFaculty(UUID programId, UUID facultyId) {
        FacultyEntity facultyEntity = facultyEntityService.getEntity(facultyId);
        ProgramEntity programEntity = programEntityService.getEntity(programId);
        facultyEntity.getProgramList().add(programEntity);
        facultyEntityService.saveEntity(facultyEntity);
        return programMapper.toResponseDto(programEntity);
    }

    @Override
    public ProgramResponseDto removeProgramFromFaculty(UUID programId) {
        ProgramEntity programEntity = programEntityService.getEntity(programId);
        programEntity.setFaculty(null);
        return programMapper.toResponseDto(programEntityService.saveEntity(programEntity));
    }
}
