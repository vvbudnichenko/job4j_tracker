package ru.job4j.cast;

public class Bus implements Vehicle {
    @Override
    public void move() {
        System.out.println(getClass().getSimpleName() + " едет по заданному маршруту");
    }

    @Override
    public void typeOfVehicle() {
        System.out.println(getClass().getSimpleName() + " наземный тип транспортного средства");
    }
}
