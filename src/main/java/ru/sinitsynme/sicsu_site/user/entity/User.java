package ru.sinitsynme.sicsu_site.user.entity;

import java.util.Collection;
import java.util.Set;
import javax.persistence.CascadeType;
import javax.persistence.CollectionTable;
import javax.persistence.ElementCollection;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import ru.sinitsynme.sicsu_site.studentData.entity.StudentData;
import ru.sinitsynme.sicsu_site.teacherData.entity.TeacherData;

@Entity
@Table(name = "usr")
public class User implements UserDetails {

  @Id
  @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "users_seq")
  @SequenceGenerator(name = "users_seq", sequenceName = "SEQ_USER", allocationSize=1)
  private Long id;

  @ElementCollection(fetch = FetchType.EAGER, targetClass = Role.class)
  @CollectionTable(name = "user_role", joinColumns = @JoinColumn(name = "user_id"))
  @Enumerated(EnumType.STRING)
  private Set<Role> roles;

  private String username;

  private String password;

  private Boolean isActive;

  @OneToOne(cascade = CascadeType.ALL)
  private StudentData studentData;

  @OneToOne(cascade = CascadeType.ALL)
  private TeacherData teacherData;


  public User() {
  }

  public Set<Role> getRoles() {
    return roles;
  }

  public void setRoles(Set<Role> roles) {
    this.roles = roles;
  }

  public Long getId() {
    return id;
  }

  public void setId(Long id) {
    this.id = id;
  }

  public StudentData getStudentData() {
    return studentData;
  }

  public void setStudentData(StudentData studentData) {
    this.studentData = studentData;
  }

  public TeacherData getTeacherData() {
    return teacherData;
  }

  public void setTeacherData(TeacherData teacherData) {
    this.teacherData = teacherData;
  }

  @Override
  public Collection<? extends GrantedAuthority> getAuthorities() {
    return roles;
  }

  @Override
  public String getPassword() {
    return password;
  }

  public void setPassword(String password) {
    this.password = password;
  }

  @Override
  public String getUsername() {
    return username;
  }

  public void setUsername(String username) {
    this.username = username;
  }

  public Boolean getActive() {
    return isActive;
  }

  public void setActive(Boolean active) {
    isActive = active;
  }

  @Override
  public boolean isAccountNonExpired() {
    return true;
  }

  @Override
  public boolean isAccountNonLocked() {
    return true;
  }

  @Override
  public boolean isCredentialsNonExpired() {
    return true;
  }

  @Override
  public boolean isEnabled() {
    return isActive;
  }

  public boolean isAdmin() {
    return roles.contains(Role.ROLE_ADMIN);
  }

  public boolean isStudent() {
    return roles.contains(Role.ROLE_STUDENT);
  }

  public boolean isTeacher() {
    return roles.contains(Role.ROLE_TEACHER);
  }

}
