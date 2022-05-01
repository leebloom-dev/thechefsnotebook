package com.thechefsnotebook.thechefsnotebook.controllers;

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

    private static List<String> contactNames = new ArrayList<>();
    private static List<String> contactEmails = new ArrayList<>();
    private static List<String> contactCountries = new ArrayList<>();

    // Lives at /contact
    @GetMapping
    public String displayAllContacts(Model model) {
        model.addAttribute("contactNames", contactNames);
        model.addAttribute("contactEmails", contactEmails);
        model.addAttribute("contactCountries", contactCountries);
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
        contactNames.add(contactName);
        contactEmails.add(contactEmail);
        contactCountries.add(contactCountry);
        return "redirect:"; // redirect to URL path
    }

}
