package ru.sinitsynme.sicsu_site.rest.dto;

import ru.sinitsynme.sicsu_site.enums.ProgramType;

import java.util.UUID;

public class ProgramResponseDto {

    private UUID id;

    private String name;

    private ProgramType type;

    private FacultyResponseDto facultyResponseDto;

    public ProgramResponseDto() {
    }

    public ProgramResponseDto(UUID id, String name, ProgramType type, FacultyResponseDto facultyResponseDto) {
        this.id = id;
        this.name = name;
        this.type = type;
        this.facultyResponseDto = facultyResponseDto;
    }

    public UUID getId() {
        return id;
    }

    public void setId(UUID id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public ProgramType getType() {
        return type;
    }

    public void setType(ProgramType type) {
        this.type = type;
    }

    public FacultyResponseDto getFacultyResponseDto() {
        return facultyResponseDto;
    }

    public void setFacultyResponseDto(FacultyResponseDto facultyResponseDto) {
        this.facultyResponseDto = facultyResponseDto;
    }
}
