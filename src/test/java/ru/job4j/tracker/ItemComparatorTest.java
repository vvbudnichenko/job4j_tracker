package ru.job4j.tracker;

import org.junit.jupiter.api.Test;

import java.util.Arrays;
import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

class ItemComparatorTest {

    @Test
    void whenSortedItemAscByName() {
        List<Item> list = Arrays.asList(new Item(1, "Lola"), new Item(2, "Boris"), new Item(3, "Nora"), new Item(4, "Sasha"), new Item(5, "Irina"));
        list.sort(new ItemAscByName());
        List<Item> expected = Arrays.asList(new Item(2, "Boris"), new Item(5, "Irina"), new Item(1, "Lola"), new Item(3, "Nora"), new Item(4, "Sasha"));
        assertThat(list).isEqualTo(expected);
    }

    @Test
    void whenSortedItemDescByName() {
        List<Item> list = Arrays.asList(new Item(1, "Lola"), new Item(2, "Boris"), new Item(3, "Nora"), new Item(4, "Sasha"), new Item(5, "Irina"));
        list.sort(new ItemDescByName());
        List<Item> expected = Arrays.asList(new Item(4, "Sasha"), new Item(3, "Nora"), new Item(1, "Lola"), new Item(5, "Irina"), new Item(2, "Boris"));
        assertThat(list).isEqualTo(expected);
    }
}
