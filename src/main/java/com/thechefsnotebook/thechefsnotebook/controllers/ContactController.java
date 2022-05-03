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
        return "/contacts/contact"; // HTML path
    }

    // Lives at /contact/form
    @GetMapping("form")
    public String renderContactForm(Model model) {
        model.addAttribute("title", "Contact Form");
        // returns to contactForm.html
        return "contacts/contactForm";
    }

    // Lives at /contact/form
    @PostMapping("form")
    public String createContact(@RequestParam String contactFirstName,
                                @RequestParam String contactLastName,
                                @RequestParam String contactEmail,
                                @RequestParam String contactCountry) {

        contacts.add(new Contact(
                contactFirstName,
                contactLastName,
                contactEmail,
                contactCountry)
        );

        return "redirect:"; // redirect to this class's URL path

    }

    // Lives at /contact/search
    @GetMapping("search")
    public String renderSearchContact() {
        return "/contacts/contactSearch";
    }

    // Lives at /contact/search
    @PostMapping("search")
    public String createSearchContact(@RequestParam String contactFirstName,
                                      @RequestParam String contactLastName,
                                      Model model) {

        // Empty Array List to hold searched contacts
        List<Contact> searchContacts = new ArrayList<>();

        // TODO: Conditional code that searches first/last name from contacts
        for (int i = 0; i < contacts.size(); i++) {
            if (contacts.get(i).getFirstName().toLowerCase().equals(contactFirstName.toLowerCase()) &&
                    contacts.get(i).getLastName().toLowerCase().equals(contactLastName.toLowerCase())) {
                // add the contact information from an index to the searchContact Array List
                searchContacts.add(contacts.get(i));
            }
        }

        // Add attribute value to model to determine if there is items in Array List
        if (searchContacts.size() != 0) {
            model.addAttribute("contacts", searchContacts);
        } else {
            model.addAttribute("contacts", "Damn you got nothing");
        }
        return "/contacts/contactSearch";

    }

}
