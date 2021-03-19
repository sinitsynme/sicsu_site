package ru.sinitsynme.sicsu_site.user.service;

import java.util.List;
import java.util.Optional;
import org.springframework.data.domain.Sort;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;
import ru.sinitsynme.sicsu_site.UserData;
import ru.sinitsynme.sicsu_site.studentData.service.StudentDataService;
import ru.sinitsynme.sicsu_site.teacherData.service.TeacherDataService;
import ru.sinitsynme.sicsu_site.user.entity.User;
import ru.sinitsynme.sicsu_site.user.repository.UserRepository;


@Service
public class UserDetailsServiceImpl implements UserDetailsService {

  private final UserRepository userRepository;
  //is there a point in services there?
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

  public User getCurrentUser() {
    return (User) loadUserByUsername(getCurrentUserName());
  }

  public Optional<User> getUserById(Long id) {
    return userRepository.findById(id);
  }

  public List<User> getUserList() {
    return userRepository.findAll(Sort.by("id"));
  }

  public void saveUser(User user) {
    userRepository.save(user);
  }

  public String getCurrentUserName() {
    return SecurityContextHolder.getContext().getAuthentication().getName();
  }


  public Optional<UserData> getCurrentUserData() {
    User currentUser = getCurrentUser();
    if (currentUser.isStudent()) {
      return Optional.ofNullable(currentUser.getStudentData());
    } else if (currentUser.isTeacher()) {
      return Optional.ofNullable(currentUser.getTeacherData());
    }
    return Optional.empty();
  }

  public void deleteUser(User user) {
    userRepository.delete(user);
  }


}
