package ru.sinitsynme.sicsu_site.rest.dto;

import java.util.UUID;

public class StudentResponseDto {

    private UUID id;

    private String info;

    private PersonalDataResponseDto personalDataResponseDto;

    private GroupResponseDto groupResponseDto;

    public StudentResponseDto() {
    }

    public StudentResponseDto(UUID id, String info, PersonalDataResponseDto personalDataResponseDto, GroupResponseDto groupResponseDto) {
        this.id = id;
        this.info = info;
        this.personalDataResponseDto = personalDataResponseDto;
        this.groupResponseDto = groupResponseDto;
    }

    public UUID getId() {
        return id;
    }

    public void setId(UUID id) {
        this.id = id;
    }

    public String getInfo() {
        return info;
    }

    public void setInfo(String info) {
        this.info = info;
    }

    public PersonalDataResponseDto getPersonalDataResponseDto() {
        return personalDataResponseDto;
    }

    public void setPersonalDataResponseDto(PersonalDataResponseDto personalDataResponseDto) {
        this.personalDataResponseDto = personalDataResponseDto;
    }

    public GroupResponseDto getGroupResponseDto() {
        return groupResponseDto;
    }

    public void setGroupResponseDto(GroupResponseDto groupResponseDto) {
        this.groupResponseDto = groupResponseDto;
    }
}
