package ru.job4j.oop.record;

import java.util.StringJoiner;

public class ConcatTest {
    public static String text(String... strings) {
       StringBuilder builder = new StringBuilder();
        for (String string : strings) {
            builder.append(string);
        }
        return builder.toString() + ". Количество переданных элементов " + strings.length;
    }

    public static String text(int x, String... strings) {
        StringBuilder builder = new StringBuilder();
        builder.append(x);
        for (String string : strings) {
            builder.append(string);
        }
        return builder.toString() + ". Количество переданных элементов " + strings.length;
    }

    public static void main(String[] args) {
        System.out.println(text());
        System.out.println(text("hello"));
        System.out.println(text("hello ", "привет"));
        System.out.println(System.lineSeparator());
        System.out.println(text(0, " hello ", " привет "));
    }
}
