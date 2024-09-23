package ru.job4j.function;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.function.*;

public class FunctionalInterfaces {
    public static void main(String[] args) {
        Map<Integer, String> map = new HashMap<>();
        BiConsumer<Integer, String> biConsumer = (key, name) -> map.put(key, name);
        biConsumer.accept(1, "one");
        biConsumer.accept(2, "two");
        biConsumer.accept(3, "three");
        biConsumer.accept(4, "four");
        biConsumer.accept(5, "five");
        biConsumer.accept(6, "six");
        biConsumer.accept(7, "seven");

        BiPredicate<Integer, String> biPredicate = (key, name) -> key % 2 == 0 || name.length() == 4;
        for (Integer key : map.keySet()) {
            String value = map.get(key);
            if (biPredicate.test(key, value)) {
                System.out.println("key: " + key + " value: " + value);
            }
        }

        Supplier<List<String>> supplier = () -> new ArrayList<>(map.values());
        List<String> strings = supplier.get();

        Consumer<String> consumer = string -> System.out.println(string);
        Function<String, String> function = string -> string.toUpperCase();
        for (String string : strings) {
            consumer.accept(function.apply(string));
        }
    }
}

