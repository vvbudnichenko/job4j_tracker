package ru.job4j.oop.record;

public class PersonMain {
    public static void main(String[] args) {
        Person person = new Person("Ivan", 23);
        System.out.println("Name " + person.getName() + " , Age: " + person.getAge());
        System.out.println(person + System.lineSeparator());
        PersonRecord personRecord = new PersonRecord("Victor", 12);
        System.out.println("Name: " + personRecord.name() + " , Age: " +  personRecord.age());
    }
}
