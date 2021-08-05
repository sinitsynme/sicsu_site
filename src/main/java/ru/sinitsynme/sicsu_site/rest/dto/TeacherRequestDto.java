package ru.sinitsynme.sicsu_site.rest.dto;

import java.util.UUID;

public class TeacherRequestDto {

    private String info;

    private String achievements;

    private UUID personalDataId;

    public TeacherRequestDto() {
    }

    public TeacherRequestDto(String info, String achievements, UUID personalDataId) {
        this.info = info;
        this.achievements = achievements;
        this.personalDataId = personalDataId;
    }

    public String getInfo() {
        return info;
    }

    public void setInfo(String info) {
        this.info = info;
    }

    public String getAchievements() {
        return achievements;
    }

    public void setAchievements(String achievements) {
        this.achievements = achievements;
    }

    public UUID getPersonalDataId() {
        return personalDataId;
    }

    public void setPersonalDataId(UUID personalDataId) {
        this.personalDataId = personalDataId;
    }
}
