package ru.sinitsynme.sicsu_site.rest.dto;

import java.util.UUID;

public class GroupResponseDto {

    private UUID id;

    private String groupFullId;

    private ProgramResponseDto programResponseDto;

    public GroupResponseDto() {
    }

    public GroupResponseDto(UUID id, String groupFullId, ProgramResponseDto programResponseDto) {
        this.id = id;
        this.groupFullId = groupFullId;
        this.programResponseDto = programResponseDto;
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

    public ProgramResponseDto getProgramResponseDto() {
        return programResponseDto;
    }

    public void setProgramResponseDto(ProgramResponseDto programResponseDto) {
        this.programResponseDto = programResponseDto;
    }
}
