package ru.job4j.collection;

import java.util.Comparator;

public class DepartmentsDescComparator implements Comparator<String> {
    @Override
    public int compare(String left, String right) {
        String[] leftString = left.split("/");
        String[] rightString = right.split("/");
        int rsl = rightString[0].compareTo(leftString[0]);
        int minLength = Math.min(leftString.length, rightString.length);
        if (rsl == 0) {
            for (int i = 0; i < minLength; i++) {
                rsl = leftString[i].compareTo(rightString[i]);
                if (rsl != 0) {
                    return rsl;
                }
            }
        }
        int cmp = Integer.compare(leftString.length, rightString.length);
        if (cmp != 0) {
            rsl = cmp;
        } else {
            for (int i = 0; i < minLength; i++) {
                rsl = leftString[i].compareTo(rightString[i]);
            }
        }
        return rsl;
    }
}
