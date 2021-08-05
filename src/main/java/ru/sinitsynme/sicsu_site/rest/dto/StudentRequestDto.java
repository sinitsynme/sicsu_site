package ru.sinitsynme.sicsu_site.rest.dto;

import java.util.UUID;

public class StudentRequestDto {

    private String info;

    private UUID personalDataId;

    public StudentRequestDto() {
    }

    public StudentRequestDto(String info, UUID personalDataId) {
        this.info = info;
        this.personalDataId = personalDataId;
    }

    public String getInfo() {
        return info;
    }

    public void setInfo(String info) {
        this.info = info;
    }

    public UUID getPersonalDataId() {
        return personalDataId;
    }

    public void setPersonalDataId(UUID personalDataId) {
        this.personalDataId = personalDataId;
    }
}
