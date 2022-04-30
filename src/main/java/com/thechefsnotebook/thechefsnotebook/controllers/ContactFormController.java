package com.thechefsnotebook.thechefsnotebook.controllers;

import com.thechefsnotebook.thechefsnotebook.models.Contact;
import com.thechefsnotebook.thechefsnotebook.models.ContactBusiness;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.List;

@Controller
public class ContactFormController {

    // Handles request at "/form"
    @GetMapping("/contactForm")
    public String contactForm() {
        return "/contactForm";
    }

    // TODO: Handles GET/POST requests of the form "/contactFormSubmitted"
    @RequestMapping(path="/contactFormSubmitted", method={RequestMethod.GET, RequestMethod.POST})
    public String contactFormSubmitted(Model model,
                                       @RequestParam String name,
                                       @RequestParam String email,
                                       @RequestParam String country) {

        // Get list of contacts from Class ContactBusiness
        ContactBusiness business = new ContactBusiness();
        List<Contact> contactList = business.getContactList();

        // Add additional Contact information
        contactList.add(new Contact(name, email, country));
        model.addAttribute("contacts", contactList);

        return "contactFormSubmitted";

    }

}
