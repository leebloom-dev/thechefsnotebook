package com.thechefsnotebook.thechefsnotebook.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("journal")
public class BlogController {

    // responds to GET requests at "/journal"
    @GetMapping
    public String renderIndex() {
        return "journal/index";
    }

}