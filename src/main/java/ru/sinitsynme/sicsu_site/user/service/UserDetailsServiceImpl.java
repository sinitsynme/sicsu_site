package ru.sinitsynme.sicsu_site.user.service;

import java.util.List;
import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;
import ru.sinitsynme.sicsu_site.studentData.service.StudentDataService;
import ru.sinitsynme.sicsu_site.teacherData.service.TeacherDataService;
import ru.sinitsynme.sicsu_site.user.entity.User;
import ru.sinitsynme.sicsu_site.user.repository.UserRepository;


@Service
public class UserDetailsServiceImpl implements UserDetailsService {

  private final UserRepository userRepository;
  private final TeacherDataService teacherDataService;
  private final StudentDataService studentDataService;

  public UserDetailsServiceImpl(
      UserRepository userRepository,
      TeacherDataService teacherDataService,
      StudentDataService studentDataService) {
    this.userRepository = userRepository;
    this.teacherDataService = teacherDataService;
    this.studentDataService = studentDataService;
  }

  @Override
  public UserDetails loadUserByUsername(String s) throws UsernameNotFoundException {
    return userRepository.findByUsername(s);
  }

  public User getCurrentUser(){
    return (User) loadUserByUsername(getCurrentUserName());
  }


  public List<User> getUserList(){
    return userRepository.findAll();
  }

  public String getCurrentUserName(){
    return SecurityContextHolder.getContext().getAuthentication().getName();
  }


  public Optional<?> getCurrentUserData(){
    User currentUser = getCurrentUser();
    if(currentUser.isStudent()){
      return studentDataService.getStudentDataById(currentUser.getId());
    }
    else if(currentUser.isTeacher()){ //edit repository
      return teacherDataService.getTeacherById(currentUser.getId());
    }
    return Optional.empty();
  }




}
