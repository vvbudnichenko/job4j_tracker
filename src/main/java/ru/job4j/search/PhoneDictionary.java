package ru.job4j.search;

import java.util.ArrayList;

public class PhoneDictionary {

    private ArrayList<Person> person = new ArrayList<>();

    public void add(Person person) {
        this.person.add(person);
    }

    public ArrayList<Person> find(String key) {
        ArrayList<Person> result = new ArrayList<>();
        for (Person members : person) {
            if (members.getName().contains(key)
                    || members.getSurname().contains(key)
                    || members.getPhone().contains(key)
                    || members.getAddress().contains(key)) {
                result.add(members);
            }
        }
        return result;
    }
}