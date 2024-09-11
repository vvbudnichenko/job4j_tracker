package ru.job4j.queue;

import java.util.Queue;

public class AppleStore {
    private final Queue<Customer> queue;

    private final int count;

    public AppleStore(Queue<Customer> queue, int count) {
        this.queue = queue;
        this.count = count;
    }

    public String getLastHappyCustomer() {
        Customer result = null;
        int temp = count;
        for (Customer counts : queue) {
            temp--;
            if (temp == 0) {
                result = counts;
                break;
            }
        }
        return result.name();
    }

    public String getFirstUpsetCustomer() {
        int temp = count;
        Customer result = new Customer(" ", 0);
        for (Customer counts : queue) {
            temp--;
            if (temp < 0) {
                result = counts;
                break;
            }
        }
        return result.name();
    }
}