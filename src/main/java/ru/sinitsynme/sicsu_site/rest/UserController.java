package ru.sinitsynme.sicsu_site.rest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;
import ru.sinitsynme.sicsu_site.enums.UserRole;
import ru.sinitsynme.sicsu_site.rest.dto.PersonalDataRequestDto;
import ru.sinitsynme.sicsu_site.service.UserService;

import javax.mail.MessagingException;
import javax.validation.Valid;

@RestController
@RequestMapping("/users")
public class UserController {

    private final UserService userService;

    @Autowired
    public UserController(UserService userService) {
        this.userService = userService;
    }

    @GetMapping
    public ResponseEntity<?> addNewUser(@ModelAttribute @Valid PersonalDataRequestDto requestDto, String userRole, BindingResult bindingResult) throws MessagingException {
        if (bindingResult.hasErrors()) {
            return ResponseEntity.badRequest().body("Invalid input data!");
        }

        return ResponseEntity.ok(userService.registerUser(requestDto, UserRole.valueOf(userRole)));

    }

}
