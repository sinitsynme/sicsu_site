package ru.sinitsynme.sicsu_site.rest.dto;

import java.util.UUID;

public class PersonalDataResponseDto {

    private UUID id;

    private String firstName;

    private String lastName;

    private String patronymic;

    private String email;

    public PersonalDataResponseDto() {
    }

    public PersonalDataResponseDto(UUID id, String firstName, String lastName, String patronymic, String email) {
        this.id = id;
        this.firstName = firstName;
        this.lastName = lastName;
        this.patronymic = patronymic;
        this.email = email;
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

    public String getPatronymic() {
        return patronymic;
    }

    public void setPatronymic(String patronymic) {
        this.patronymic = patronymic;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }
}
