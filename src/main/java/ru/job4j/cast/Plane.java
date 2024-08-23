package ru.job4j.cast;

public class Plane implements Vehicle {
    @Override
    public void move() {
        System.out.println(getClass().getSimpleName() + " летит из точки в точку");
    }

    @Override
    public void typeOfVehicle() {
        System.out.println(getClass().getSimpleName() + " воздушный тип транспортного средства");
    }
}
