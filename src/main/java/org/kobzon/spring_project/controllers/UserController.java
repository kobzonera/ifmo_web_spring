package org.kobzon.spring_project.controllers;

import org.kobzon.spring_project.entities.Role;
import org.kobzon.spring_project.entities.User;
import org.kobzon.spring_project.pojos.UserRegistration;
import org.kobzon.spring_project.services.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.Arrays;

@RestController
public class UserController {
    @Autowired
    private UserService userService;

    @PostMapping(value = "/register")
    public String register(@RequestBody UserRegistration userRegistration) {
        if (userService.getUser(userRegistration.getUsername()) != null)
            return "User already exists";
        else if (userRegistration.getPassword().length() < 8)
            return "Password less than 8 characters";
        userService.save(new User(userRegistration.getUsername(), userRegistration.getPassword(), Arrays.asList(new Role("USER"))));
        return "User created";
    }
}
