package ru.skillbox.diplom.group33.social.service.controllers;

import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import ru.skillbox.diplom.group33.social.service.model.User;
import ru.skillbox.diplom.group33.social.service.service.UserService;

@RestController
@RequestMapping("/")
public class RegistrationController {

    private final UserService userService;


    public RegistrationController(UserService userService) {
        this.userService = userService;
    }

    @PostMapping("registration")
    public String registration(@RequestBody User user)
    {
        userService.register(user);
        return "Ok";
    }
}
