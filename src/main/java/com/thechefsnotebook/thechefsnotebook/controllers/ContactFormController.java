package com.thechefsnotebook.thechefsnotebook.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class ContactFormController {

    @GetMapping("/contactForm")
    public String contactForm() {
        return "/contactForm";
    }

}
