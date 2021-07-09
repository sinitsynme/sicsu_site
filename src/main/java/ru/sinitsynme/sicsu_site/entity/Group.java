package ru.sinitsynme.sicsu_site.entity;

import javax.persistence.*;
import java.util.List;
import java.util.UUID;

@Entity
@Table(name = "groups")
public class Group {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private UUID id;

    private String groupFullId;

    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "program_id")
    private Program program;

    @OneToMany(fetch = FetchType.LAZY, cascade = {CascadeType.MERGE, CascadeType.PERSIST}, mappedBy = "group")
    private List<Student> students;

    public Group() {
    }

    public Group(String groupFullId, Program program) {
        this.groupFullId = groupFullId;
        this.program = program;
    }

    public UUID getId() {
        return id;
    }

    public void setId(UUID id) {
        this.id = id;
    }

    public Program getProgram() {
        return program;
    }

    public void setProgram(Program program) {
        this.program = program;
    }

    public String getGroupFullId() {
        return groupFullId;
    }

    public void setGroupFullId(String groupFullId) {
        this.groupFullId = groupFullId;
    }

    public List<Student> getStudents() {
        return students;
    }

    public void setStudents(List<Student> students) {
        this.students = students;
    }


}
