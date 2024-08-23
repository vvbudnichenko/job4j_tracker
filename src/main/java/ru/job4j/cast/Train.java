package ru.job4j.cast;

public class Train implements Vehicle {
    @Override
    public void typeOfVehicle() {
        System.out.println(getClass().getSimpleName() + " едет по рельсам из пункта в пункт");
    }

    @Override
    public void move() {
        System.out.println(getClass().getSimpleName() + " рельсовый тип транспортного средства");
    }
}
