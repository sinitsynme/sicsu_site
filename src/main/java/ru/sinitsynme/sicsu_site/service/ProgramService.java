package ru.sinitsynme.sicsu_site.service;

import org.springframework.data.domain.Page;
import ru.sinitsynme.sicsu_site.rest.dto.ProgramRequestDto;
import ru.sinitsynme.sicsu_site.rest.dto.ProgramResponseDto;

import java.util.UUID;

public interface ProgramService {

    ProgramResponseDto saveProgram(ProgramRequestDto requestDto);

    ProgramResponseDto editProgram(ProgramRequestDto requestDto, UUID programId);

    ProgramResponseDto deleteProgram(UUID programId);

    ProgramResponseDto getProgram(UUID programId);

    Page<ProgramResponseDto> getAllPrograms();

    Page<ProgramResponseDto> getAllProgramsFromFaculty(UUID facultyId);

    ProgramResponseDto addProgramToFaculty(UUID programId, UUID facultyId);

    ProgramResponseDto removeProgramFromFaculty(UUID programId);

}
