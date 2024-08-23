package ru.job4j.polymorphism;

public class Bus implements Transport {
    @Override
    public void move() {
        System.out.println("This transport is ready to go.");
    }

    @Override
    public void passengers(int count) {
        System.out.println("Number of passengers is " + count);
    }

    @Override
    public int refuel(int fuel) {
        return 0;
    }
}