package ru.job4j.ex;

public class FactorialRecursion {
    public static int calc(int n) {
        return (n == 0 || n == 1) ? 1 : calc(n - 1) * n;
    }

    public static void main(String[] args) {
        int result = calc(5);
        System.out.println(result);
        int result2 = calc(0);
        System.out.println(result2);
    }
}