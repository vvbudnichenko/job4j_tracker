package ru.job4j.oop.io;

import java.util.Random;

public class MagicBall {

    public static void main(String[] args) {
        System.out.println("Будет ли завтра дождь? ");
        int answer = new Random().nextInt(3);
        System.out.println("Магический шар дает ответ : " + answer);
        switch (answer) {
            case 0 -> System.out.println("Да");
            case 1 -> System.out.println("Нет");
            default -> System.out.println("Может быть");
        }
    }
}