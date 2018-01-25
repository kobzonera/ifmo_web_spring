package org.kobzon.spring_project.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class HomeController {
    @RequestMapping(value="/")
    public String getIndex(){
        return "index";
    }

    @RequestMapping(value="/authorize")
    public String getAuthorize(){
        return "authorize";
    }
}