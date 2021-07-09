package ru.sinitsynme.sicsu_site.entity;

import javax.persistence.*;
import java.util.List;
import java.util.UUID;

@Entity
public class Faculty {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private UUID id;

    private String name;

    @OneToMany(mappedBy = "faculty", fetch = FetchType.LAZY)
    private List<Department> departments;

    @OneToMany(mappedBy = "faculty", fetch = FetchType.LAZY)
    private List<Program> programList;

    public Faculty() {
    }

    public Faculty(String name) {
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

    public List<Department> getDepartments() {
        return departments;
    }

    public void setDepartments(List<Department> departments) {
        this.departments = departments;
    }

    public List<Program> getProgramList() {
        return programList;
    }

    public void setProgramList(List<Program> programList) {
        this.programList = programList;
    }
}
