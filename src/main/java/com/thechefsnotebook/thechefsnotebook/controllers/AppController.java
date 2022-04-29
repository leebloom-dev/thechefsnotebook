package com.thechefsnotebook.thechefsnotebook.controllers;

import com.thechefsnotebook.thechefsnotebook.models.Contact;
import com.thechefsnotebook.thechefsnotebook.models.ContactBusiness;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.List;

@Controller
public class AppController {

    @RequestMapping("/")
    public String welcome() {
        return "index";
    }

}
