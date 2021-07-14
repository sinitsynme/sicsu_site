package ru.sinitsynme.sicsu_site.entity;

import javax.persistence.*;
import java.util.List;
import java.util.UUID;

@Entity
public class FacultyEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private UUID id;

    private String name;

    @OneToMany(mappedBy = "faculty", fetch = FetchType.LAZY)
    private List<DepartmentEntity> departments;

    @OneToMany(mappedBy = "faculty", fetch = FetchType.LAZY)
    private List<ProgramEntity> programList;

    public FacultyEntity() {
    }

    public FacultyEntity(String name) {
        this.name = name;
    }

    public UUID getId() {
        return id;
    }

    public void setId(UUID id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public List<DepartmentEntity> getDepartments() {
        return departments;
    }

    public void setDepartments(List<DepartmentEntity> departments) {
        this.departments = departments;
    }

    public List<ProgramEntity> getProgramList() {
        return programList;
    }

    public void setProgramList(List<ProgramEntity> programList) {
        this.programList = programList;
    }
}
