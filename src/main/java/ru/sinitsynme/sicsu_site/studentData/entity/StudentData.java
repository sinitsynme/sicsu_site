package ru.sinitsynme.sicsu_site.studentData.entity;

import java.sql.Date;
import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToOne;
import javax.persistence.OneToOne;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;
import ru.sinitsynme.sicsu_site.user.data.UserData;
import ru.sinitsynme.sicsu_site.group.entity.Group;
import ru.sinitsynme.sicsu_site.user.entity.User;

@Entity
@Table(name = "student_data")
public class StudentData extends UserData {

  @Id
  @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "students_seq")
  @SequenceGenerator(name = "students_seq", sequenceName = "SEQ_STUDENT", allocationSize=1)
  private Long id;

  private String firstName;
  private String lastName;

  @OneToOne(mappedBy = "studentData", cascade = CascadeType.ALL)
  private User user;

  private Date birthDate;

  private String email;

  @ManyToOne(fetch = FetchType.LAZY, cascade = CascadeType.ALL)
  @JoinTable(name="students_groups", joinColumns = @JoinColumn(name = "student_data_id"), inverseJoinColumns = @JoinColumn(name="group_id"))
  private Group studentGroup;

  private byte courseNumber;

  public User getUser() {
    return user;
  }

  public void setUser(User user) {
    this.user = user;
  }

  public String getEmail() {
    return email;
  }

  public void setEmail(String email) {
    this.email = email;
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

  public Date getBirthDate() {
    return birthDate;
  }

  public void setBirthDate(Date birthDate) {
    this.birthDate = birthDate;
  }

  public Group getStudentGroup() {
    return studentGroup;
  }

  public void setStudentGroup(Group group) {
    this.studentGroup = group;
  }

  public byte getCourseNumber() {
    return courseNumber;
  }

  public void setCourseNumber(byte courseNumber) {
    this.courseNumber = courseNumber;
  }

  public String getGroupId(){
    if(studentGroup == null) return null;
    return studentGroup.getGroupFullId();
  }

}
