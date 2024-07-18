package ru.job4j.oop;

public class Tamagotchi {
    public static void ert(String[] args) {
        String source = "+!?";
        char symbol1 = source.charAt(0);
        char symbol2 = source.charAt(1);
        char symbol3 = source.charAt(2);
        for (int i = 0; i < source.length(); i++) {
            if (source.charAt(i) == symbol1) {
                System.out.print(symbol1);
                System.out.print(symbol1);
                System.out.println(symbol1);
            } else if (source.charAt(i) == symbol2) {
                System.out.print(symbol2);
                System.out.print(symbol2);
                System.out.print(symbol2);
                System.out.println(symbol2);
            } else if (source.charAt(i) == symbol3) {
                System.out.print(symbol3);
                System.out.println(symbol3);
            }
        }
    }

    public static void getGreeting(String name, int age) {
        System.out.println(String.format("Привет! Я %s, мне столько лет: %d", name, age));
    }

    public static void main(String[] args) {
        getGreeting(" ", 126);
    }
}
