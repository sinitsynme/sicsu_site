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
import javax.persistence.PrimaryKeyJoinColumn;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;
import ru.sinitsynme.sicsu_site.studentData.entity.StudentData;
import ru.sinitsynme.sicsu_site.teacherData.entity.TeacherData;

@Entity
@Table(name = "groups")
public class Group {

  @Id
  @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "groups_seq")
  @SequenceGenerator(name = "groups_seq", sequenceName = "SEQ_GROUP", allocationSize=1)
  private Long id;

  private String groupFullId;

  private String info;

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

  public String getInfo() {
    return info;
  }

  public void setInfo(String info) {
    this.info = info;
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
