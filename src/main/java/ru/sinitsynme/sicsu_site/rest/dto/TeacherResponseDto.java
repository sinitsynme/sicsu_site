package ru.sinitsynme.sicsu_site.rest.dto;

import java.util.UUID;

public class TeacherResponseDto {

    private UUID id;

    private PersonalDataResponseDto personalDataResponseDto;

    private DepartmentResponseDto departmentResponseDto;

    public TeacherResponseDto() {
    }

    public TeacherResponseDto(UUID id, PersonalDataResponseDto personalDataResponseDto) {
        this.id = id;
        this.personalDataResponseDto = personalDataResponseDto;
    }

    public UUID getId() {
        return id;
    }

    public void setId(UUID id) {
        this.id = id;
    }

    public PersonalDataResponseDto getPersonalDataResponseDto() {
        return personalDataResponseDto;
    }

    public void setPersonalDataResponseDto(PersonalDataResponseDto personalDataResponseDto) {
        this.personalDataResponseDto = personalDataResponseDto;
    }

    public DepartmentResponseDto getDepartmentResponseDto() {
        return departmentResponseDto;
    }

    public void setDepartmentResponseDto(DepartmentResponseDto departmentResponseDto) {
        this.departmentResponseDto = departmentResponseDto;
    }
}
