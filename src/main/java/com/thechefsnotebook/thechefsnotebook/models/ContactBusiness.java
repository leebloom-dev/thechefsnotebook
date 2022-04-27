package com.thechefsnotebook.thechefsnotebook.models;

import java.util.ArrayList;
import java.util.List;

public class ContactBusiness {

    // Returns hard-coded List of Contact objects.
    public List<Contact> getContactList() {

        List<Contact> listContact = new ArrayList<>();

        listContact.add(new Contact("Sana Oi", "sana.oi@gmail.com", "Japan"));
        listContact.add(new Contact("Young-soon Yamamoto", "youngsoon.yamamoto@gmail.com", "Japan"));
        listContact.add(new Contact("Dasom Yoon", "dasom.yoon@gmail.com", "South Korea"));
        listContact.add(new Contact("Jamine Bloom", "jamie.bloom@gmail.com", "United States"));

        return listContact;

    }
}
