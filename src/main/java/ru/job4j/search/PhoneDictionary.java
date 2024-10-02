package ru.job4j.search;

import java.util.ArrayList;
import java.util.function.Predicate;

public class PhoneDictionary {

    private ArrayList<Person> person = new ArrayList<>();

    public void add(Person person) {
        this.person.add(person);
    }

    public ArrayList<Person> find(String key) {
        Predicate<Person> compareName = i -> i.getName().contains(key);
        Predicate<Person> compareSurname = i -> i.getSurname().contains(key);
        Predicate<Person> comparePhone = i -> i.getPhone().contains(key);
        Predicate<Person> compareAddress = i -> i.getAddress().contains(key);
        Predicate<Person> combine = compareName.or(compareSurname).or(comparePhone).or(compareAddress);
        ArrayList<Person> result = new ArrayList<>();
        for (var members : person) {
            if (combine.test(members)) {
                result.add(members);
            }
        }
        return result;
    }
}