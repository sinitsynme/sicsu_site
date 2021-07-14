package ru.sinitsynme.sicsu_site.rest.dto;

import java.util.UUID;

public class DepartmentRequestDto {

    private String name;

    private UUID facultyId;

    public DepartmentRequestDto() {
    }

    public DepartmentRequestDto(String name, UUID facultyId) {
        this.name = name;
        this.facultyId = facultyId;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public UUID getFacultyId() {
        return facultyId;
    }

    public void setFacultyId(UUID facultyId) {
        this.facultyId = facultyId;
    }
}
