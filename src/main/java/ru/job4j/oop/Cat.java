package ru.job4j.oop;

public class Cat {

    private String food;
    private String name;

    public void show() {
        System.out.println(this.food);
        System.out.println(this.name);
    }

    public void eat(String meat) {
        this.food = meat;
    }

    public void nickname(String catName) {
        this.name = catName;
    }

    public String sound() {
        return  "may-may";
    }

    public static void main(String[] args) {
        System.out.println("There is gav's food");
        Cat gav = new Cat();
        gav.eat("kotleta");
        gav.nickname("Gav");
        gav.show();
        System.out.println("There is black's food.");
        Cat black = new Cat();
        black.eat("fish");
        black.nickname("Black");
        black.show();
    }
}
