package com.thechefsnotebook.thechefsnotebook.controllers;

import com.thechefsnotebook.thechefsnotebook.models.Contact;
import com.thechefsnotebook.thechefsnotebook.models.ContactBusiness;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import java.util.List;

@Controller
public class ContactController {

    @GetMapping("/contact")
    public String listContact(Model model) {

        // Getting the list of contacts from Class ContactBusiness
        ContactBusiness business = new ContactBusiness();
        List<Contact> contactList = business.getContactList();

        // adding the contact list to model's attribute "contacts"
        model.addAttribute("contacts", contactList);

        return "contact";

    }

}
