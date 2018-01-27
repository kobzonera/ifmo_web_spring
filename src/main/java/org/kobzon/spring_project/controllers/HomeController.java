package org.kobzon.spring_project.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class HomeController{

    @GetMapping(value= "/")
    public String index(){
            return "index";
        }

    @GetMapping(value= "/authorize")
    public String authorize(){
        return "authorize";
    }

}
