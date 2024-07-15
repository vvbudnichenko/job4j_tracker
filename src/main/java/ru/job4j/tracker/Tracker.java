package ru.job4j.tracker;

import java.util.Arrays;

public class Tracker {
    private final Item[] items = new Item[100];
    private int ids = 1;
    private int size = 0;

    public Item add(Item item) {
        item.setId(ids++);
        items[size++] = item;
        return item;
    }

    public Item findById(int id) {
        for (int index = 0; index < size; index++) {
            Item item = items[index];
            if (item.getId() == id) {
                return item;
            }
        }
        return null;
    }

    public Item[] findAll() {
        Item[] result = new Item[items.length];
        int size = 0;
        for (Item temp : items) {
            if (temp != null) {
                result[size] = temp;
                size++;
            }
        }
        return Arrays.copyOf(result, size);
    }

    public Item[] findByName(String key) {
        Item[] result = findAll();
        int size = 0;
        for (Item temp : result) {
            if (key.equals(temp.getName())) {
                result[size++] = temp;
            }
        }
        return Arrays.copyOf(result, size);
    }
}