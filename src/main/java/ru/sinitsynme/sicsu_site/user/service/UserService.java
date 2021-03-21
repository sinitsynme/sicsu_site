package ru.sinitsynme.sicsu_site.user.service;

import java.util.List;
import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Sort;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Service;
import ru.sinitsynme.sicsu_site.user.data.UserData;
import ru.sinitsynme.sicsu_site.user.entity.User;
import ru.sinitsynme.sicsu_site.user.repository.UserRepository;

@Service
public class UserService {

  private final UserRepository userRepository;
  private final UserDetailsServiceImpl userDetailsService;

  @Autowired
  public UserService(UserRepository userRepository,
      UserDetailsServiceImpl userDetailsService) {
    this.userRepository = userRepository;
    this.userDetailsService = userDetailsService;
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

  public User getUserByUsername(String username){
    return (User) userDetailsService.loadUserByUsername(username);
  }

  public User getCurrentUser() {
    return userRepository.findByUsername(getCurrentUserName());
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
