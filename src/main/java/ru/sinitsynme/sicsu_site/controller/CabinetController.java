package ru.sinitsynme.sicsu_site.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import ru.sinitsynme.sicsu_site.entity.Student;
import ru.sinitsynme.sicsu_site.entity.Teacher;
import ru.sinitsynme.sicsu_site.service.UserService;

import java.util.Optional;

@Controller
@RequestMapping("/cabinet")
public class CabinetController {

    private final UserService userService;

    //move to service

    @Autowired
    public CabinetController(UserService userService) {
        this.userService = userService;
    }

    @GetMapping
    public String getCabinetPage(Model model) {
//        Optional<UserData> optionalUserData = userService.getCurrentUserData();
//        if (optionalUserData.isPresent()) {
//            UserData userData = optionalUserData.get();
//            model.addAttribute("userData", userData);
//            if (userData instanceof Student) {
//                return "cabinet/student";
//            } else if (userData instanceof Teacher) {
//                return "cabinet/teacher";
//            }
//        }
        model.addAttribute("error", "Missing data");
        return "utilPages/errorPage";
    }


    @GetMapping(path = {"/changepsw/{userId}", "/changepsw"})
    public String changePassword(Model model, @PathVariable Optional<Long> userId) {
        if (userId.isPresent()) {
            model.addAttribute("userId", userId.get());
        } else model.addAttribute("userId", userService.getCurrentUser().getId());
        return "authReg/changePasswordPage";
    }


}
