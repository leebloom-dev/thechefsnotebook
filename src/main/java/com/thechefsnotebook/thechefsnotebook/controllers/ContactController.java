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

//    private static List<Contact> contactNames = new ArrayList<>();
//    private static List<Contact> contactEmails = new ArrayList<>();
//    private static List<Contact> contactCountries = new ArrayList<>();
    private static List<Contact> contacts = new ArrayList<>();

    // Lives at /contact
    @GetMapping
    public String displayAllContacts(Model model) {
//        model.addAttribute("contactNames", contactNames);
//        model.addAttribute("contactEmails", contactEmails);
//        model.addAttribute("contactCountries", contactCountries);
        model.addAttribute("contacts", contacts);
        return "contact";
    }

    // Lives at /contact/form
    @GetMapping("form")
    public String renderContactForm() {
        // returns to contactForm.html
        return "contactForm";
    }

    // Lives at /contacts/form
    @PostMapping("form")
    public String createContact(@RequestParam String contactName,
                                @RequestParam String contactEmail,
                                @RequestParam String contactCountry) {
//        contactNames.add(contactName);
//        contactEmails.add(contactEmail);
//        contactCountries.add(contactCountry);
        contacts.add(new Contact(contactName, contactEmail, contactCountry));
        return "redirect:"; // redirect to URL path
    }

}
