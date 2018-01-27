package org.kobzon.spring_project.controllers;

import org.kobzon.spring_project.entities.Role;
import org.kobzon.spring_project.entities.User;
import org.kobzon.spring_project.pojos.UserRegistration;
import org.kobzon.spring_project.services.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.oauth2.provider.token.TokenStore;
import org.springframework.web.bind.annotation.*;

import java.util.Arrays;
import java.util.regex.Pattern;

@RestController
public class UserController {
    @Autowired
    private UserService userService;

    @PostMapping(value = "/register")
    public String register(@RequestBody UserRegistration userRegistration) {
        if (userService.findByUsername(userRegistration.getUsername()) != null)
            return "User already exists";
        Pattern pattern = Pattern.compile("[^a-zA-Z0-9]");
        if (pattern.matcher(userRegistration.getUsername()).find())
            return "No special characters are allowed in the username";
        if (userRegistration.getUsername().length()<6 ||  userRegistration.getUsername().length()>32)
            return "Username length must be between 6 and 32 characters";
        userService.save(new User(userRegistration.getUsername(), userRegistration.getPassword(), Arrays.asList(new Role("USER"))));
        return "User created";
    }

}
