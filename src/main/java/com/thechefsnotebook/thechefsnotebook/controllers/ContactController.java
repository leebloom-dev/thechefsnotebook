package com.thechefsnotebook.thechefsnotebook.controllers;

import com.thechefsnotebook.data.ContactData;
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

    // private static List<Contact> contacts = new ArrayList<>();

    // Lives at /contact
    @GetMapping
    public String displayAllContacts(Model model) {
        // displaying conditional html
        boolean isSearching = false;
        model.addAttribute("isSearching", isSearching);
        model.addAttribute("title", "Contact");
        model.addAttribute("contacts", ContactData.getAll());
        return "/contacts/contact"; // HTML path
    }

    // Lives at /contact
    @PostMapping
    public String createSearchContact(@RequestParam String contactFirstName,
                                      @RequestParam String contactLastName,
                                      Model model) {
        // for displaying html
        boolean isSearching = true;
        model.addAttribute("isSearching", isSearching);

        // Empty Array List to hold searched contacts
        List<Contact> contactsSearched = new ArrayList<>();

        for (Contact contact : ContactData.getAll()) {

            // Condition: first name match AND last name empty
            if (contact.getFirstName().equalsIgnoreCase(contactFirstName) && contactLastName.isEmpty()) {
                contactsSearched.add(contact);
                model.addAttribute("contacts", contactsSearched);
            }

            // Condition: first name empty AND last name match
            if (contactFirstName.isEmpty() && contact.getLastName().equalsIgnoreCase(contactLastName)) {
                contactsSearched.add(contact);
                model.addAttribute("contacts", contactsSearched);
            }

            // Condition: first name AND last name match
            if (contact.getFirstName().equalsIgnoreCase(contactFirstName) && contact.getLastName().equalsIgnoreCase(contactLastName)) {
                contactsSearched.add(contact);
                model.addAttribute("contacts", contactsSearched);
            }

        }

        return "/contacts/contact";

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

        ContactData.add(new Contact(
            contactFirstName,
            contactLastName,
            contactEmail,
            contactCountry
        ));

        return "redirect:"; // redirect to this class's URL path

    }

}
