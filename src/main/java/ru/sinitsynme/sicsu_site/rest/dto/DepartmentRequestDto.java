package ru.sinitsynme.sicsu_site.rest.dto;

public class DepartmentRequestDto {

    private String name;

    public DepartmentRequestDto() {
    }

    public DepartmentRequestDto(String name) {
        this.name = name;

    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }


}
