package ru.sinitsynme.sicsu_site.studentData.controller;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;
import java.util.Optional;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;
import ru.sinitsynme.sicsu_site.group.entity.Group;
import ru.sinitsynme.sicsu_site.group.service.GroupService;
import ru.sinitsynme.sicsu_site.studentData.entity.StudentData;
import ru.sinitsynme.sicsu_site.studentData.service.StudentDataService;
import ru.sinitsynme.sicsu_site.user.entity.User;
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
  public String getAllStudents(Model model) {
    List<StudentData> studentDataList = studentService.getAllStudents();
    model.addAttribute("students", studentDataList);
    return "studentlist";
  }

  @PreAuthorize("hasAuthority('ROLE_ADMIN')")
  @PostMapping("/new")
  public String registerStudent(StudentData student,
      String birthDate,
      Long userId,
      Model model) throws ParseException {

    Date date = new SimpleDateFormat("yyyy-MM-dd").parse(birthDate);
    java.sql.Date sqlDate = new java.sql.Date(date.getTime());

    student.setBirthDate(sqlDate);

    studentService.saveStudentData(student);



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
      return "utilPages/errorPage";
    }
  }

  @PreAuthorize("hasAuthority('ROLE_ADMIN')")
  @GetMapping("/{id}/groupSet")
  public ModelAndView getGroupSettingPage(@PathVariable Long id){
    ModelAndView modelAndView = new ModelAndView("/group/studentGroupSet");
    modelAndView.addObject("groups", groupService.getAllGroups());
    modelAndView.addObject("studentId", id);
    return modelAndView;
  }

  @PreAuthorize("hasAuthority('ROLE_ADMIN')")
  @PostMapping("/{id}/groupSet")
  public String setGroupToStudent(@PathVariable Long id, String groupName, Model model){

    Optional<StudentData> studentOptional = studentService.getStudentDataById(id);
    if(studentOptional.isPresent()){
      if(groupName == null){
        model.addAttribute("message", "You have to select a group!");
        model.addAttribute("studentId", id);
        model.addAttribute("groups", groupService.getAllGroups());
        return "/group/studentGroupSet";
      }
      StudentData student = studentOptional.get();
      String prevGroupId = student.getGroupId();
      if(prevGroupId != null){
        Group prevGroup = groupService.getByGroupFullId(prevGroupId);
        prevGroup.getStudents().remove(student);
      }

      Group group = groupService.getByGroupFullId(groupName);
      student.setStudentGroup(group);

      groupService.saveGroup(group);
      studentService.saveStudentData(student);

      return "redirect:/users/" + student.getUser().getId();
    }

    model.addAttribute("error", "Something went wrong");
    return "/utilPages/errorPage";
  }




}


