package ru.sinitsynme.sicsu_site.util;

import java.util.HashSet;
import java.util.Set;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import ru.sinitsynme.sicsu_site.user.entity.Role;
import ru.sinitsynme.sicsu_site.user.entity.User;
import ru.sinitsynme.sicsu_site.user.service.UserDetailsServiceImpl;

@Controller
@RequestMapping("/util")
public class UtilController {

  private final UserDetailsServiceImpl userDetailsService;

  @Autowired
  public UtilController(
      UserDetailsServiceImpl userDetailsService) {
    this.userDetailsService = userDetailsService;
  }

  //for admin registration
  @GetMapping("/regAdmin")
  public String regAdmin() {

    User admin = new User();
    admin.setUsername("admin");
    admin.setPassword("sicsu_admin2021");
    Set<Role> roles = new HashSet<>();
    roles.add(Role.ROLE_ADMIN);
    admin.setRoles(roles);
    admin.setActive(true);

    userDetailsService.saveUser(admin);

    return "redirect:/login";
  }

}
