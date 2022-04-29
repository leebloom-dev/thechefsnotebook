package com.thechefsnotebook.thechefsnotebook.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

@Controller
@ResponseBody
@RequestMapping("/school")
public class HelloController {

    // Handles request of the form /school
    @RequestMapping(method = {RequestMethod.GET, RequestMethod.POST})
    public String mySchool(@RequestParam String name) {
        return "Welcome to " + name + "!";
    }

    // handles request of the form /school/{name}
    @GetMapping("/{name}")
    public String mySchoolYokohamaHighSchool(@PathVariable String name) {
        return "This is " + name + "!";
    }

    // handles request at /school/form
    @GetMapping("/form")
    public String schoolForm() {
        return "<html>" +
                    "<body>" +
                        "<form action='/school' method='post'>" + // submit a request to /school
                            "<input type='text' name='name' />" +
                            "<input type='submit' value='Greet me!' />" +
                        "</form>" +
                    "</body>" +
                "</html>";
    }
}
