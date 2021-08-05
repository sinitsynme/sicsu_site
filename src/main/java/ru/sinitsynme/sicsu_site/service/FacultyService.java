package ru.sinitsynme.sicsu_site.service;

import org.springframework.data.domain.Page;
import ru.sinitsynme.sicsu_site.rest.dto.FacultyRequestDto;
import ru.sinitsynme.sicsu_site.rest.dto.FacultyResponseDto;

import java.util.UUID;

public interface FacultyService {

    FacultyResponseDto saveFaculty(FacultyRequestDto requestDto);

    FacultyResponseDto editFaculty(FacultyRequestDto requestDto, UUID facultyId);

    FacultyResponseDto deleteFaculty(UUID facultyId);

    FacultyResponseDto getFaculty(UUID facultyId);

    Page<FacultyResponseDto> getAllFaculties();


}
