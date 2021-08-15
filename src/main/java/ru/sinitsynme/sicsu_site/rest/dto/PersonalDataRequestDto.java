package ru.sinitsynme.sicsu_site.rest.dto;

import javax.validation.constraints.*;
import java.sql.Date;


public class PersonalDataRequestDto {

    @Size(min = 2, max = 30)
    private String firstName;

    @Size(min = 2, max = 30)
    private String lastName;

    @Size(min = 2, max = 30)
    private String patronymic;

    @NotNull
    private Date birthDate;

    @NotNull
    @Email
    private String email;

    public PersonalDataRequestDto() {
    }

    public PersonalDataRequestDto(String firstName, String lastName, String patronymic, Date birthDate, String email) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.patronymic = patronymic;
        this.birthDate = birthDate;
        this.email = email;
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

    public Date getBirthDate() {
        return birthDate;
    }

    public void setBirthDate(Date birthDate) {
        this.birthDate = birthDate;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }
}
