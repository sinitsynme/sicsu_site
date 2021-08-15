package ru.sinitsynme.sicsu_site.rest.dto;

import ru.sinitsynme.sicsu_site.enums.ProgramType;

import java.util.UUID;

public class ProgramRequestDto {

    private String name;

    private ProgramType type;

    public ProgramRequestDto() {
    }

    public ProgramRequestDto(String name, ProgramType type, UUID facultyId) {
        this.name = name;
        this.type = type;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public ProgramType getType() {
        return type;
    }

    public void setType(ProgramType type) {
        this.type = type;
    }
}
