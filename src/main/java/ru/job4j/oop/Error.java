package ru.job4j.oop;

public class Error {

    private boolean active;
    private int status;
    private String message;

    public Error() {
    }

    public Error(boolean active, int status, String message) {
        this.active = active;
        this.message = message;
        this.status = status;
    }

    public void printInfo() {
        System.out.println("Вид заявки " + active);
        System.out.println("Регион страны " + status + " определен.");
        System.out.println("Заявка принята в обработку. " + message);

    }

    public static void main(String[] args) {
        Error first = new Error();
        Error second = new Error(true, 23, "Ждите ответа.");
        first.printInfo();
        second.printInfo();
    }
}


