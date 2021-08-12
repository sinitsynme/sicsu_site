package ru.sinitsynme.sicsu_site.service.impl;

import org.springframework.data.domain.Page;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import ru.sinitsynme.sicsu_site.rest.dto.ProgramRequestDto;
import ru.sinitsynme.sicsu_site.rest.dto.ProgramResponseDto;
import ru.sinitsynme.sicsu_site.service.ProgramService;

import java.util.UUID;

@Service
@Transactional
public class ProgramServiceImpl implements ProgramService {
    @Override
    public ProgramResponseDto saveProgram(ProgramRequestDto requestDto) {
        return null;
    }

    @Override
    public ProgramResponseDto editProgram(ProgramRequestDto requestDto, UUID programId) {
        return null;
    }

    @Override
    public ProgramResponseDto deleteProgram(UUID programId) {
        return null;
    }

    @Override
    public ProgramResponseDto getProgram(UUID programId) {
        return null;
    }

    @Override
    public Page<ProgramResponseDto> getAllPrograms() {
        return null;
    }

    @Override
    public Page<ProgramResponseDto> getAllProgramsFromFaculty(UUID facultyId) {
        return null;
    }

    @Override
    public ProgramResponseDto addProgramToFaculty(UUID programId, UUID facultyId) {
        return null;
    }

    @Override
    public ProgramResponseDto removeProgramFromFaculty(UUID programId) {
        return null;
    }
}
