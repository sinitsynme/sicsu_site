package ru.sinitsynme.sicsu_site.rest.dto;

public class FacultyRequestDto {

    private String name;

    public FacultyRequestDto(String name) {
        this.name = name;
    }

    public FacultyRequestDto() {
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
