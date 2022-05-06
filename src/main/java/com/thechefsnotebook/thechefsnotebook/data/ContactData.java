package com.thechefsnotebook.thechefsnotebook.data;

import java.util.Collection;
import java.util.HashMap;
import java.util.Map;

import com.thechefsnotebook.thechefsnotebook.model.Contact;

public class ContactData {

    // holds a list of key/value pairs.
    private static Map<Integer, Contact> contacts = new HashMap<>();

    // returns a collection of values contained this map. 
    public static Collection<Contact> getAll() {
        return contacts.values();
    }

    // using the 'key' to return a value from the Map's key/value pair.
    public static Contact getById(Integer id) {
        return contacts.get(id);
    }

    // Adding key/value to map where key: id and value: contact informationß
    public static void add(Contact contact) {
        contacts.put(contact.getId(), contact);
    }

    // using the 'key to remove the key/value pair in the map 
    public static void remove(Integer id) {
        if (contacts.containsKey(id)) {
            contacts.remove(id);
        }
    }
    
}