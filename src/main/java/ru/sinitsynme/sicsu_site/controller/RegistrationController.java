package ru.sinitsynme.sicsu_site.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import ru.sinitsynme.sicsu_site.enums.Role;
import ru.sinitsynme.sicsu_site.entity.User;
import ru.sinitsynme.sicsu_site.service.UserService;

import java.util.HashSet;

@Controller
@PreAuthorize("hasAuthority('ROLE_ADMIN')")
@RequestMapping("/registration")
public class RegistrationController {

    private final UserService userService;

    @Autowired
    public RegistrationController(UserService userService) {
        this.userService = userService;
    }


    @GetMapping
    public String getRegForm(Model model) {
//    model.addAttribute("roles", Arrays.stream(Role.values()).filter(it -> it != Role.ROLE_ADMIN));
        return "/authReg/registration";
    }

    @PostMapping
    public String register(@RequestParam String confirm_psw, User user, Model model,
                           String dataType) {

        if (dataType == null) {
            model.addAttribute("message", "You have to choose a role!");
            return "/authReg/registration";
        }

        User dbUser = userService.getUserByUsername(user.getUsername());

        if (!user.getPassword().equals(confirm_psw)) {
            model.addAttribute("message", "The passwords are not equal!");
            return "/authReg/registration";
        }

        if (dbUser != null) {
            model.addAttribute("message", "The user with the same username already exists!");
            return "/authReg/registration";
        }

        user.setRoles(new HashSet<>());

        if (dataType.equals("Student")) {
            user.getRoles().add(Role.ROLE_STUDENT);
        } else if (dataType.equals("Teacher")) {
            user.getRoles().add(Role.ROLE_TEACHER);
        }
        //maybe there will be some other roles

        userService.saveUser(user);
        model.addAttribute("userRegistering", user);

        if (dataType.equals("Student")) {
            return "/authReg/studentReg";
        } else {
            return "/authReg/teacherReg";
        }
    }


}
