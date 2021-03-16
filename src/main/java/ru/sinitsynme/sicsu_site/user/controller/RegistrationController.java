package ru.sinitsynme.sicsu_site.user.controller;

import java.util.HashSet;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import ru.sinitsynme.sicsu_site.user.entity.Role;
import ru.sinitsynme.sicsu_site.user.entity.User;
import ru.sinitsynme.sicsu_site.user.repository.UserRepository;

@Controller
@PreAuthorize("hasAuthority('ROLE_ADMIN')")
@RequestMapping("/registration")
public class RegistrationController {

  UserRepository userRepository;

  @Autowired
  public RegistrationController(
      UserRepository userRepository) {
    this.userRepository = userRepository;
  }

  @GetMapping
  public String getRegForm(Model model) {
//    model.addAttribute("roles", Arrays.stream(Role.values()).filter(it -> it != Role.ROLE_ADMIN));
    return "/authReg/registration";
  }

  @PostMapping
  public String register(@RequestParam String confirm_psw, User user, Model model,
      @RequestParam(required = false, defaultValue = "false") Boolean isStudent,
      @RequestParam(required = false, defaultValue = "false") Boolean isTeacher) {


    User dbUser = userRepository.findByUsername(user.getUsername());

    if (!user.getPassword().equals(confirm_psw)) {
      model.addAttribute("message", "The passwords are not equal!");
      return "/authReg/registration";
    }

    if (dbUser != null) {
      model.addAttribute("message", "The user with the same username already exists!");
      return "/authReg/registration";
    }

    if (!(isStudent || isTeacher) || (isStudent && isTeacher)) {
      model.addAttribute("message", "You have to choose only 1 role!");
      return "/authReg/registration";
    }
    user.setRoles(new HashSet<>());

    if (isStudent) {
      user.getRoles().add(Role.ROLE_STUDENT);
    }
    else if (isTeacher) {
      user.getRoles().add(Role.ROLE_TEACHER);
    }
    //maybe there will be some other roles

    userRepository.save(user);
    model.addAttribute("userRegistering", user);

//    if(isStudent){
//      return "studentReg";
//    }
//    else if(isTeacher){
//      return "teacherReg";
//    }

    return "redirect:/users";
  }

  @PostMapping("/student")
  public String StudentReg(Model model){
    return "redirect:/users";
  }


}
