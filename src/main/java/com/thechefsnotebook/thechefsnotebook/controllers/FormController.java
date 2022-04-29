package com.thechefsnotebook.thechefsnotebook.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

@Controller
public class FormController {

    // TODO: Handles request at "/form"
    // Form will pass input to "/formSubmitted
    @GetMapping("/form")
    public String someForm() {
        return "form";
    }

    // TODO: Handles GET/POST requests of the form "/formSubmitted"
    @RequestMapping(path="/formSubmitted", method={RequestMethod.GET, RequestMethod.POST})
    @ResponseBody
    public String formSubmitted(@RequestParam String name) {
        return "From the form you submitted, your name is: " + name;
    }

}
