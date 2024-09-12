package ru.job4j.collection;

import java.util.HashMap;

public class UsageMap {

    public static void main(String[] args) {
        HashMap<String, String> users = new HashMap<>();
        users.put("igorpetrov@gmail.com", "Igor Ivanovich Petrov");
        users.put("egorpetrov@gmail.com", "Egor Ivanovich Petrov");
        users.put("ivanpetrov@gmail.com", "Ivan Ivanovich Petrov");
        users.put("olegpetrov@gmail.com", "Oleg Ivanovich Petrov");
        users.put("olegpetrov@gmail.com", "Oleg Nickitich Petrov");
        users.put("olegpetrov@gmail.com", "Oleg Nickitich Lang");
        for (String key : users.keySet()) {
            String value = users.get(key);
            System.out.println("Key is: " + key + " and value is: " + value);
        }
    }
}
