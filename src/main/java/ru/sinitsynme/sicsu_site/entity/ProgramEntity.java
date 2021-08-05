package ru.sinitsynme.sicsu_site.entity;

import ru.sinitsynme.sicsu_site.enums.ProgramType;

import javax.persistence.*;
import java.util.List;
import java.util.UUID;

@Entity
@Table(name = "program")
public class ProgramEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private UUID id;

    private String name;

    @Enumerated(EnumType.STRING)
    private ProgramType type;

    @OneToMany(mappedBy = "program", fetch = FetchType.LAZY)
    private List<GroupEntity> groupList;

    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "faculty_id")
    private FacultyEntity faculty;


    public ProgramEntity() {
    }

    public ProgramEntity(String name, ProgramType type) {
        this.name = name;
        this.type = type;
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

    public ProgramType getType() {
        return type;
    }

    public void setType(ProgramType type) {
        this.type = type;
    }

    public List<GroupEntity> getGroupList() {
        return groupList;
    }

    public void setGroupList(List<GroupEntity> groupList) {
        this.groupList = groupList;
    }

    public FacultyEntity getFaculty() {
        return faculty;
    }

    public void setFaculty(FacultyEntity faculty) {
        this.faculty = faculty;
    }
}
