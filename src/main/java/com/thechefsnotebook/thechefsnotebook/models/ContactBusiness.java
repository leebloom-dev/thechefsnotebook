package com.thechefsnotebook.thechefsnotebook.models;

import java.util.ArrayList;
import java.util.List;

public class ContactBusiness {

    // Returns hard-coded List of Contact objects.
    public List<Contact> getContactList() {

        List<Contact> listContact = new ArrayList<>();

        listContact.add(new Contact("Sakura Haruna", "sakura.haruna@gmail.com", "Japan"));

        return listContact;

    }
}
