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

    @RequestMapping("/contact")
    public String listContact(Model model) {

        // Getting the list of contacts from Class ContactBusiness
        ContactBusiness business = new ContactBusiness();
        List<Contact> contactList = business.getContactList();

        // adding the contact list to model's attribute "contacts"
        model.addAttribute("contacts", contactList);

        return "contact";

    }

}
