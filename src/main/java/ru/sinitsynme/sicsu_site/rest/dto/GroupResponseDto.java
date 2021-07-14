package ru.sinitsynme.sicsu_site.rest.dto;

import java.util.UUID;

public class GroupResponseDto {

    private UUID id;

    private String groupFullId;

    private FacultyResponseDto facultyResponseDto;

    public GroupResponseDto() {
    }

    public GroupResponseDto(UUID id, String groupFullId, FacultyResponseDto facultyResponseDto) {
        this.id = id;
        this.groupFullId = groupFullId;
        this.facultyResponseDto = facultyResponseDto;
    }

    public UUID getId() {
        return id;
    }

    public void setId(UUID id) {
        this.id = id;
    }

    public String getGroupFullId() {
        return groupFullId;
    }

    public void setGroupFullId(String groupFullId) {
        this.groupFullId = groupFullId;
    }

    public FacultyResponseDto getFacultyResponseDto() {
        return facultyResponseDto;
    }

    public void setFacultyResponseDto(FacultyResponseDto facultyResponseDto) {
        this.facultyResponseDto = facultyResponseDto;
    }
}
