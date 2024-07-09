package ru.job4j.tracker.oop;

public class Jukebox {

    public void music(int position) {
        if (position == 1) {
            System.out.println("Пусть бегут неуклюже");
        } else if (position == 2) {
            System.out.println("Спокойной ночи");
        } else {
            System.out.println("Песня не найдена");
        }
    }

    public static void main(String[] args) {
        Jukebox firstChoice = new Jukebox();
        firstChoice.music(2);
        Jukebox secondChoice = new Jukebox();
        firstChoice.music(1);
        Jukebox wrongChoice = new Jukebox();
        firstChoice.music(3);
    }
}