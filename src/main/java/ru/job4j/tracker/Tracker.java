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
        int index = indexOf(id);
        return index != -1 ? items[index] : null;
    }

    public Item[] findAll() {
        Item[] result = new Item[items.length];
        int size = 0;
        for (Item temp : items) {
            if (temp != null) {
                result[size++] = temp;
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

    public boolean replace(int id, Item item) {
        if (id < 0) {
            System.out.println("Please enter positive number. Try again. ");
        } else {
            int index = indexOf(id);
            if (index != -1) {
                item.setId(id);
                items[index] = item;
                System.out.println("Item with id " + id + " was replaced successfully.");
                return true;
            } else {
                System.out.println("You try to replace non-existing item. Try again. ");
            }
        }
        return false;
    }

    private int indexOf(int id) {
        int result = -1;
        for (int index = 0; index < size; index++) {
            if (items[index].getId() == id) {
                result = index;
                break;
            }
        }
        return result;
    }

    public void delete(int id) {
        int index = indexOf(id);
        if (id < 0) {
            System.out.println("Please enter positive number.");
        } else {
            if (index != -1) {
                System.arraycopy(items, index + 1, items, index, size - index - 1);
                items[size - 1] = null;
                size--;
                System.out.println("Item with id " + id + " was deleted successfully.");
            } else {
                System.out.println("You try to delete non-existing item.");
            }
        }
    }
}