package com.thechefsnotebook.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class HomeController {

    // responds to GET requests at URL "localhost:8080/"
    @GetMapping
    public String displayHomePage(Model model) {

        model.addAttribute("title", "Home Page");
        return "index";

    }
    
}
