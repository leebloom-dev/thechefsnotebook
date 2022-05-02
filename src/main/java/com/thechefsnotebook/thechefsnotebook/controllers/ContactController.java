package com.thechefsnotebook.thechefsnotebook.controllers;

import com.thechefsnotebook.thechefsnotebook.model.Contact;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.ArrayList;
import java.util.List;

@Controller
@RequestMapping("contact")
public class ContactController {

    private static List<Contact> contacts = new ArrayList<>();

    // Lives at /contact
    @GetMapping
    public String displayAllContacts(Model model) {
        model.addAttribute("title", "Contact");
        model.addAttribute("contacts", contacts);
        return "contact";
    }

    // Lives at /contact/form
    @GetMapping("form")
    public String renderContactForm(Model model) {
        model.addAttribute("title", "Contact Form");
        // returns to contactForm.html
        return "contactForm";
    }

    // Lives at /contacts/form
    @PostMapping("form")
    public String createContact(@RequestParam String contactName,
                                @RequestParam String contactEmail,
                                @RequestParam String contactCountry) {

        contacts.add(new Contact(contactName, contactEmail, contactCountry));
        return "redirect:"; // redirect to URL path

    }

}
