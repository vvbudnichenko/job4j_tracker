package ru.job4j.collection;

import java.util.Comparator;

public class LexSort implements Comparator<String> {
    public int compare(String left, String right) {
        String[] numberLeft = left.split("\\.");
        String[] numberRight = right.split("\\.");
        return Integer.compare(Integer.parseInt(numberLeft[0]), Integer.parseInt(numberRight[0]));
    }
}
