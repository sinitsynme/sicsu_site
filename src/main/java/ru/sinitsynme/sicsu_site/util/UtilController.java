package ru.sinitsynme.sicsu_site.util;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import ru.sinitsynme.sicsu_site.enums.UserRole;
import ru.sinitsynme.sicsu_site.entity.User;
import ru.sinitsynme.sicsu_site.service.UserService;

import java.util.HashSet;
import java.util.Set;

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
        Set<UserRole> roles = new HashSet<>();
        roles.add(UserRole.ROLE_ADMIN);
        admin.setRoles(roles);
        admin.setActive(true);

        userService.saveUser(admin);

        return "redirect:/login";
    }


}
