package ru.sinitsynme.sicsu_site.teacherData.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import ru.sinitsynme.sicsu_site.teacherData.entity.TeacherData;
import ru.sinitsynme.sicsu_site.teacherData.service.TeacherDataService;

@Controller
@RequestMapping("/teachers")
public class TeacherDataController {

  private final TeacherDataService teacherDataService;

  @Autowired
  public TeacherDataController(
      TeacherDataService teacherDataService) {
    this.teacherDataService = teacherDataService;
  }

  @PostMapping("/new")
  public String registerTeacher(TeacherData teacherData, Long userId, Model model){
    if(teacherDataService.registerTeacher(teacherData, userId)){
      return "redirect:/users";
    }
    model.addAttribute("error", "Something went wrong");
    return "utilPages/errorPage";
  }



}
