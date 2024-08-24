package ru.job4j.oop;

public class Tamagotchi {
    public static void main(String[] args) {
        String source = "+!?";
        for (int i = 0; i < source.toCharArray().length; i++) {
            if (i == 0) {
                System.out.println("" + source.charAt(i) + source.charAt(i) + source.charAt(i));
            } else if (i == 1) {
                System.out.println("" + source.charAt(i) + source.charAt(i) + source.charAt(i) + source.charAt(i));
            } else {
                System.out.print("" + source.charAt(i) + source.charAt(i));
            }
        }
    }
}
