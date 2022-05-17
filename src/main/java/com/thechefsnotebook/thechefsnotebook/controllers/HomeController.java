package com.thechefsnotebook.thechefsnotebook.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class HomeController {

    // responds to GET requests at "/"
    @GetMapping
    public String index(Model model) {
        model.addAttribute("title", "Home");
        return "index";
    }

}
