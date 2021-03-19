package ru.sinitsynme.sicsu_site.user.controller;

import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PatchMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import ru.sinitsynme.sicsu_site.user.entity.User;
import ru.sinitsynme.sicsu_site.user.service.UserDetailsServiceImpl;

@Controller
@RequestMapping("/users")
@PreAuthorize("hasAuthority('ROLE_ADMIN')")
public class UserController {

  private final UserDetailsServiceImpl service;

  @Autowired
  public UserController(UserDetailsServiceImpl service) {
    this.service = service;
  }

  @GetMapping
  public String listAllUsers(Model model) {
    model.addAttribute("users", service.getUserList());
    return "userList";
  }

  @GetMapping("/{id}")
  public String getUserPage(Model model, @PathVariable Long id){
    Optional<User> optionalUser = service.getUserById(id);
    if(optionalUser.isPresent()){
      User user = optionalUser.get();
      if (user.getStudentData() != null){
        model.addAttribute("userData", user.getStudentData());
        return "cabinet/student";
      }
      else if(user.getTeacherData() != null){
        model.addAttribute("userData", user.getTeacherData());
        return "cabinet/teacher";
      }
      else {
        model.addAttribute("error", "Data is unavailable");
        return "errorPage";
      }
    }
    else{
      model.addAttribute("error", "Cannot find user with such id");
      return "errorPage";
    }
  }

  @DeleteMapping("/delete/{id}")
  public String deleteUser(Model model, @PathVariable Long id){
    Optional<User> userOptional = service.getUserById(id);
    if(userOptional.isPresent()){
      User user = userOptional.get();
      service.deleteUser(user);
      return "redirect:/users";
    }
    else{
      model.addAttribute("error", "Cannot find user with such id");
      return "errorPage";
    }
  }

  @GetMapping("/{id}/edit")
  public String getEditForm(Model model, @PathVariable Long id){
    Optional<User> userOptional = service.getUserById(id);
    if(userOptional.isPresent()){
      User user = userOptional.get();
      model.addAttribute("userRegistering", user);
      if (user.getStudentData() != null){
        model.addAttribute("userData", user.getStudentData());
        return "authReg/studentReg";
      }
      else if(user.getTeacherData() != null){
        model.addAttribute("userData", user.getTeacherData());
        return "authReg/teacherReg";
      }
      else {
        model.addAttribute("error", "Data is unavailable");
        return "errorPage";
      }
    }
    else{
      model.addAttribute("error", "Cannot find user with such id");
      return "errorPage";
    }
  }


}
