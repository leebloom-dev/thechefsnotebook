package com.thechefsnotebook.thechefsnotebook.models;

import java.util.ArrayList;
import java.util.List;

public class ContactBusiness {

    // Returns hard-coded List of Contact objects.
    public List<Contact> getContactList() {

        List<Contact> listContact = new ArrayList<>();

        listContact.add(new Contact("Sakura Haruna", "sakura.haruna@gmail.com", "Japan"));
        listContact.add(new Contact("Ryoko Habuki", "ryoko.habuki@gmail.com", "Japan"));
        listContact.add(new Contact("Moon Jae-in", "moon.jae-in@gmail.com", "South Korea"));
        listContact.add(new Contact("Spongebob Squarpants", "spongebob.squarepants@gmail.com", "United States"));

        return listContact;

    }
}
