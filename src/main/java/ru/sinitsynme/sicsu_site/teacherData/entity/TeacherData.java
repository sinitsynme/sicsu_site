package ru.sinitsynme.sicsu_site.teacherData.entity;

import ru.sinitsynme.sicsu_site.group.entity.Group;
import ru.sinitsynme.sicsu_site.user.data.UserData;
import ru.sinitsynme.sicsu_site.user.entity.User;

import javax.persistence.*;
import java.util.Set;

@Entity
public class TeacherData extends UserData {

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "teachers_seq")
    @SequenceGenerator(name = "teachers_seq", sequenceName = "SEQ_TEACHER", allocationSize = 1)
    private Long id;

    private String firstName;
    private String lastName;

    @OneToOne(mappedBy = "teacherData", cascade = CascadeType.ALL)
    private User user;

    private String email;


    //after the basics are complete, a discipline will become an entity and have ManyToMany rel with teacher
    @ElementCollection
    private Set<String> disciplines;

    @ManyToMany(fetch = FetchType.LAZY, cascade = CascadeType.ALL)
    @JoinTable(name = "teachers_groups",
            joinColumns = @JoinColumn(name = "teacher_id"),
            inverseJoinColumns = @JoinColumn(name = "groups_id"))
    private Set<Group> groups;

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public Set<Group> getGroups() {
        return groups;
    }

    public void setGroups(Set<Group> groups) {
        this.groups = groups;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
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

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    public Set<String> getDisciplines() {
        return disciplines;
    }

    public void setDisciplines(Set<String> disciplines) {
        this.disciplines = disciplines;
    }
}
