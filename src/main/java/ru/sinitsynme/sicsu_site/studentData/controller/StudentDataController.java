package ru.sinitsynme.sicsu_site.studentData.controller;

import freemarker.template.SimpleDate;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;
import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PatchMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import ru.sinitsynme.sicsu_site.group.entity.Group;
import ru.sinitsynme.sicsu_site.group.service.GroupService;
import ru.sinitsynme.sicsu_site.studentData.entity.StudentData;
import ru.sinitsynme.sicsu_site.studentData.service.StudentDataService;
import ru.sinitsynme.sicsu_site.user.entity.User;
import ru.sinitsynme.sicsu_site.user.service.UserDetailsServiceImpl;
import ru.sinitsynme.sicsu_site.user.service.UserService;

@Controller
@RequestMapping("/students")
public class StudentDataController {

  private final StudentDataService studentService;
  private final GroupService groupService;
  private final UserService userService;

  public StudentDataController(
      StudentDataService studentService,
      GroupService groupService, UserService userService) {
    this.studentService = studentService;
    this.groupService = groupService;
    this.userService = userService;
  }

  @PreAuthorize("hasAnyAuthority('ROLE_ADMIN', 'ROLE_TEACHER')")
  @GetMapping
  public String getAllStudents() {
    List<StudentData> studentDataList = studentService.getAllStudents();
    return "studentlist";
  }

  @PreAuthorize("hasAuthority('ROLE_ADMIN')")
  @PostMapping("/new")
  public String registerStudent(StudentData student,
      String birthDate,
      String groupId,
      Long userId,
      Model model) throws ParseException {

    Date date = new SimpleDateFormat("yyyy-MM-dd").parse(birthDate);
    java.sql.Date sqlDate = new java.sql.Date(date.getTime());

    Group group = groupService.getByGroupFullId(groupId);

    student.setBirthDate(sqlDate);
    student.setStudentGroup(group);
    studentService.saveStudentData(student);

    group.getStudents().add(student);
    groupService.saveGroup(group);

    Optional<User> user = userService.getUserById(userId);
    if(user.isPresent()){
      User userRegistering = user.get();
      userRegistering.setStudentData(student);
      userRegistering.setActive(true);
      userService.saveUser(userRegistering);
      return "redirect:/users";
    }
    else{
      model.addAttribute("error", "Something went wrong");
      return "errorPage";
    }


  }




}


