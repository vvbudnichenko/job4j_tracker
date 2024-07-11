package ru.job4j.oop;

public class Calculator {

    private static int x = 5;

    public static int sum(int y) {
        return x + y;
    }

    public static int minus(int a) {
        return a - x;
    }

    public int multiply(int a) {
        return x * a;
    }

    public int divide(int b) {
        return b / x;
    }

    public int sumAllOperation(int c) {
        return sum(c) + minus(c) + multiply(c) + divide(c);
    }

    public static void main(String[] args) {
        int result = Calculator.sum(10);
        System.out.println("Result of sum function is: " + result + System.lineSeparator());
        result = Calculator.minus(7);
        System.out.println("Result of minus function is: " + result + System.lineSeparator());
        Calculator example = new Calculator();
        System.out.println("Result of multiply function is: " + example.multiply(5) + System.lineSeparator());
        System.out.println("Result of divide function is: " + example.divide(5) + System.lineSeparator());
        System.out.println("Final result is sum of all presented functions in a class: " + example.sumAllOperation(5));
    }
}
