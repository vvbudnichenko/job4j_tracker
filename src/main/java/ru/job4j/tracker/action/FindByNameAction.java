package ru.job4j.tracker.action;

import ru.job4j.tracker.input.Input;
import ru.job4j.tracker.Item;
import ru.job4j.tracker.output.Output;
import ru.job4j.tracker.Tracker;

import java.util.ArrayList;

public class FindByNameAction implements UserAction {

    private final Output output;

    public FindByNameAction(Output output) {
        this.output = output;
    }

    @Override
    public String name() {
        return "Показать заявки по имени";
    }

    @Override
    public boolean execute(Input input, Tracker tracker) {
        output.println("=== Вывод заявки имени ===");
        String name = input.askStr("Введите имя: ");
        ArrayList<Item> items = tracker.findByName(name);
        if (!items.isEmpty()) {
            for (Item item : items) {
                output.println(item);
            }
        } else {
            output.println("Заявки с именем: " + name + " не найдены.");
        }
        return true;
    }
}
