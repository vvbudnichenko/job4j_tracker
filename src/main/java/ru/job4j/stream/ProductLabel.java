package ru.job4j.stream;

import java.util.List;
import java.util.stream.Collectors;

public class ProductLabel {
    public List<String> generateLabels(List<Product> products) {
        return products.stream()
                .filter(a -> (a.getStandard() - a.getActual()) >= 0
                        && (a.getStandard() - a.getActual()) <= 3)
                .map(a -> new Label(a.getName(), a.getPrice() * 0.5f).toString())
                 .collect(Collectors.toList());
    }
}