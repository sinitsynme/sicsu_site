package ru.sinitsynme.sicsu_site.user.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
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
    return "userlist";
  }
}
