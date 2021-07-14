package ru.sinitsynme.sicsu_site.rest.dto;

import java.sql.Date;
import java.util.UUID;

public class StudentResponseDto {

    private UUID id;

    private String firstName;

    private String lastName;

    private Date date;

    private GroupResponseDto groupResponseDto;

    public StudentResponseDto() {
    }

    public StudentResponseDto(UUID id, String firstName, String lastName, Date date) {
        this.id = id;
        this.firstName = firstName;
        this.lastName = lastName;
        this.date = date;
    }

    public UUID getId() {
        return id;
    }

    public void setId(UUID id) {
        this.id = id;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public Date getDate() {
        return date;
    }

    public void setDate(Date date) {
        this.date = date;
    }

    public GroupResponseDto getGroupResponseDto() {
        return groupResponseDto;
    }

    public void setGroupResponseDto(GroupResponseDto groupResponseDto) {
        this.groupResponseDto = groupResponseDto;
    }
}
