package ru.sinitsynme.sicsu_site.rest.dto;

import java.util.UUID;

public class DepartmentResponseDto {

    private UUID id;

    private String name;

    private FacultyResponseDto faculty;

    public DepartmentResponseDto() {
    }

    public DepartmentResponseDto(UUID id, String name, FacultyResponseDto faculty) {
        this.id = id;
        this.name = name;
        this.faculty = faculty;
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

    public FacultyResponseDto getFaculty() {
        return faculty;
    }

    public void setFaculty(FacultyResponseDto faculty) {
        this.faculty = faculty;
    }
}
