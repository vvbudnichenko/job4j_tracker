package ru.job4j.oop;

public class BallStory {

    public static void main(String[] args) {
        Wolf wolf = new Wolf();
        Fox fox = new Fox();
        Ball ball = new Ball();
        Hare hare = new Hare();
        wolf.tryEat(ball);
        hare.tryEat(ball);
        fox.tryEat(ball);
    }
}
