package ru.sinitsynme.sicsu_site.service.impl;

import org.springframework.data.domain.Page;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import ru.sinitsynme.sicsu_site.rest.dto.FacultyRequestDto;
import ru.sinitsynme.sicsu_site.rest.dto.FacultyResponseDto;
import ru.sinitsynme.sicsu_site.service.FacultyService;

import java.util.UUID;

@Service
@Transactional
public class FacultyServiceImpl implements FacultyService {
    @Override
    public FacultyResponseDto saveFaculty(FacultyRequestDto requestDto) {
        return null;
    }

    @Override
    public FacultyResponseDto editFaculty(FacultyRequestDto requestDto, UUID facultyId) {
        return null;
    }

    @Override
    public FacultyResponseDto deleteFaculty(UUID facultyId) {
        return null;
    }

    @Override
    public FacultyResponseDto getFaculty(UUID facultyId) {
        return null;
    }

    @Override
    public Page<FacultyResponseDto> getAllFaculties() {
        return null;
    }
}
