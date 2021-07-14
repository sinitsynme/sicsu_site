package ru.sinitsynme.sicsu_site.rest.dto;

import java.sql.Date;

public class TeacherRequestDto {

    private String firstName;

    private String lastName;

    private Date date;

    public TeacherRequestDto() {
    }

    public TeacherRequestDto(String firstName, String lastName, Date date) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.date = date;
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
}
