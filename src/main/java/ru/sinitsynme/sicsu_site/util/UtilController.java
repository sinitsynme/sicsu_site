package ru.sinitsynme.sicsu_site.util;

import java.util.HashSet;
import java.util.Set;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import ru.sinitsynme.sicsu_site.studentData.entity.StudentData;
import ru.sinitsynme.sicsu_site.studentData.service.StudentDataService;
import ru.sinitsynme.sicsu_site.user.entity.Role;
import ru.sinitsynme.sicsu_site.user.entity.User;
import ru.sinitsynme.sicsu_site.user.service.UserDetailsServiceImpl;
import ru.sinitsynme.sicsu_site.user.service.UserService;

@Controller
@RequestMapping("/util")
public class UtilController {

  private final UserService userService;

  public UtilController(UserService userService) {
    this.userService = userService;
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

    userService.saveUser(admin);

    return "redirect:/login";
  }


}
