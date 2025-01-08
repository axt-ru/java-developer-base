package ru.otus.java.basic.homeworks.pw10;

import java.util.HashMap;
import java.util.List;
import java.util.ArrayList;

public class PhoneBook {

    private final HashMap<String, List<String>> contacts;

    public PhoneBook() {
        contacts = new HashMap<>();
    }

    public void add(String name, String phoneNumber) {
        contacts.computeIfAbsent(name, key -> new ArrayList<>()).add(phoneNumber);
    }

    public List<String> find(String name) {
        return contacts.getOrDefault(name, new ArrayList<>());

    }

    public boolean containsPhoneNumber(String phoneNumber) {
        for (List<String> numbers : contacts.values()) {
            if (numbers.contains(phoneNumber)) {
                return true;
            }
        }
        return false;
    }

    public void telephoneBook() {
        for (String name: contacts.keySet()) {
            System.out.println("Имя: " + name + " - Номер телефона: " + contacts.get(name));
        }
    }
}
