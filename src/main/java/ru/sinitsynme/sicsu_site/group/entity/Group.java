package ru.sinitsynme.sicsu_site.group.entity;

import java.util.Set;
import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToMany;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import ru.sinitsynme.sicsu_site.studentData.entity.StudentData;
import ru.sinitsynme.sicsu_site.teacherData.entity.TeacherData;

@Entity
@Table(name = "groups")
public class Group {

  @Id
  @GeneratedValue(strategy = GenerationType.AUTO)
  private Long id;

  private String groupFullId;

  @OneToMany(mappedBy = "studentGroup")
  private Set<StudentData> students;

  @ManyToMany(mappedBy = "groups")
  private Set<TeacherData> teachers;

  public Long getId() {
    return id;
  }

  public void setId(Long id) {
    this.id = id;
  }

  public String getGroupFullId() {
    return groupFullId;
  }

  public void setGroupFullId(String groupFullId) {
    this.groupFullId = groupFullId;
  }

  public Set<StudentData> getStudents() {
    return students;
  }

  public void setStudents(Set<StudentData> students) {
    this.students = students;
  }

  public Set<TeacherData> getTeachers() {
    return teachers;
  }

  public void setTeachers(Set<TeacherData> teachers) {
    this.teachers = teachers;
  }
}
