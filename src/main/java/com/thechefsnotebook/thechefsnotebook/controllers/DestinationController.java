package com.thechefsnotebook.thechefsnotebook.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

@Controller
@RequestMapping("/destinations") // setting the base path of this class
public class DestinationController {

    // TODO: Handles request of the form "/destinations/{name}
    @GetMapping("/destinations/{name}")
    public String destinationPathVariable(@PathVariable String name) {
        return "Your destination path variable is " + name;
    }

    // TODO: Handles GET/POST requests of the form "/destinations"
    @RequestMapping(method = {RequestMethod.GET, RequestMethod.POST})
    @ResponseBody
    public String destination(@RequestParam String name) {
        return "The destination you entered is " + name;
    }

    // TODO: Handles request at "/destinations/form
    // Form posts to "/destinations"
    @GetMapping("/form")
    public String destinationForm() {
        return "form";
    }

}
