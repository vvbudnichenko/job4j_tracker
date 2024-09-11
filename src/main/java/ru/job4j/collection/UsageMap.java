package ru.job4j.collection;

import java.util.HashMap;

public class UsageMap {

    public static void main(String[] args) {
        HashMap<String, String> users = new HashMap<>();
        users.put("igorpetrov@gmail.com", "Igor Ivanovich Petrov");
        users.put("egorpetrov@gmail.com", "Egor Ivanovich Petrov");
        for (String key : users.keySet()) {
            String value = users.get(key);
            System.out.println("Key is: " + key + " and value is: " + value);
        }
    }
}
