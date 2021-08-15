package ru.sinitsynme.sicsu_site.rest.dto;

import java.util.UUID;

public class GroupRequestDto {

    private String groupFullId;

    public GroupRequestDto() {
    }

    public GroupRequestDto(String groupFullId) {
        this.groupFullId = groupFullId;
    }

    public String getGroupFullId() {
        return groupFullId;
    }

    public void setGroupFullId(String groupFullId) {
        this.groupFullId = groupFullId;
    }

}
