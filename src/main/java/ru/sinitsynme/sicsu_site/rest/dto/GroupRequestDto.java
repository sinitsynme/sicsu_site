package ru.sinitsynme.sicsu_site.rest.dto;

import java.util.UUID;

public class GroupRequestDto {

    private String groupFullId;

    private UUID facultyId;

    public GroupRequestDto() {
    }

    public GroupRequestDto(String groupFullId, UUID facultyId) {
        this.groupFullId = groupFullId;
        this.facultyId = facultyId;
    }

    public String getGroupFullId() {
        return groupFullId;
    }

    public void setGroupFullId(String groupFullId) {
        this.groupFullId = groupFullId;
    }

    public UUID getFacultyId() {
        return facultyId;
    }

    public void setFacultyId(UUID facultyId) {
        this.facultyId = facultyId;
    }
}
