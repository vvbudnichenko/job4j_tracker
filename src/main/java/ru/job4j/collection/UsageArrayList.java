package ru.job4j.collection;

import java.util.ArrayList;

public class UsageArrayList {

    public static void main(String[] args) {
        ArrayList<String> names = new ArrayList<>();
        names.add("Petr");
        names.add("Ivan");
        names.add("Stepan");
        for (String value : names) {
            System.out.println(value);
        }
        int a = 1;
        Integer b;
        Integer c;
        b = Integer.valueOf(a);
        c = a;
        System.out.println("First: " + b + " Second: " + c);
        num(Integer.valueOf(a));
        Integer d = 5;
        int f = d;
        System.out.println("int f = " + f);
        Integer m = 5;
        int n = m.intValue();
        System.out.println("int n = " + n);
        Integer k = 5;
        Integer l = 6;
        System.out.println(k.intValue() * l.intValue());
        System.out.println("Auto Unboxing:  " + k * l);
        Integer g  = 250;
        Integer h = 250;
        System.out.println(g == h);
    }

    static void num(Integer num) {
        System.out.println("Value of type is: " + num);
    }

    static void num(int num) {
        System.out.println("Parent value of type is: " + num);
    }
}