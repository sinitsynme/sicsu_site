package ru.sinitsynme.sicsu_site.teacherData.service;

import java.util.Optional;
import org.springframework.stereotype.Service;
import ru.sinitsynme.sicsu_site.teacherData.entity.TeacherData;
import ru.sinitsynme.sicsu_site.teacherData.repository.TeacherDataRepository;
import ru.sinitsynme.sicsu_site.user.entity.User;
import ru.sinitsynme.sicsu_site.user.service.UserService;


@Service
public class TeacherDataService {

  private final TeacherDataRepository teacherDataRepository;
  private final UserService userService;

  public TeacherDataService(
      TeacherDataRepository teacherDataRepository,
      UserService userService) {
    this.teacherDataRepository = teacherDataRepository;
    this.userService = userService;
  }

  public Optional<TeacherData> getTeacherById(Long id) {
    return teacherDataRepository.findById(id);
  }

  public boolean registerTeacher(TeacherData teacherData, Long userId) {
    Optional<User> userOptional = userService.getUserById(userId);
    if(userOptional.isPresent()){
      User user = userOptional.get();
      user.setActive(true);
      user.setTeacherData(teacherData);
      teacherData.setUser(user);

      teacherDataRepository.save(teacherData);
      userService.saveUser(user);
      return true;
    }
    return false;
  }


}
