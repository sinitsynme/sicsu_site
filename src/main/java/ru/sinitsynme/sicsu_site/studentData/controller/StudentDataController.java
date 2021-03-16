package ru.sinitsynme.sicsu_site.studentData.controller;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import ru.sinitsynme.sicsu_site.studentData.entity.StudentData;
import ru.sinitsynme.sicsu_site.studentData.service.StudentDataService;

@Controller
@RequestMapping("/students")
public class StudentDataController {

  private final StudentDataService studentService;

  @Autowired
  public StudentDataController(
      StudentDataService studentService) {
    this.studentService = studentService;
  }

  @PreAuthorize("hasAnyAuthority('ROLE_ADMIN', 'ROLE_TEACHER')")
  @GetMapping
  public String getAllStudents() {
    List<StudentData> studentDataList = studentService.getAllStudents();
    return "studentlist";
  }

//  @GetMapping("/")
//  public String getStudentPage(@PathVariable Long id, Model model) {
//    Optional<StudentData> studentOpt = studentService.getStudentDataById(id);
//    if(studentOpt.isPresent()){
//      StudentData student = studentOpt.get();
//      model.addAttribute("student", student);
//    }
//    else model.addAttribute("error", true);
//    return "cabinet";


}


