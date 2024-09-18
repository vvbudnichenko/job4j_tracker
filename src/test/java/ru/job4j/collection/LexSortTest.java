package ru.job4j.collection;

import org.junit.jupiter.api.Test;
import java.util.Arrays;
import static org.assertj.core.api.Assertions.assertThat;

class LexSortTest {

    @Test
    public void sortNum1And2And10() {
        String[] input = {
                "10. Task.",
                "1. Task.",
                "2. Task."
        };
        String[] output = {
                "1. Task.",
                "2. Task.",
                "10. Task."
        };
        Arrays.sort(input, new LexSort());
        assertThat(input).isEqualTo(output);
    }

    @Test
    public void sortNum2And2And22() {
        String[] input = {
                "2. Task.",
                "22. Task.",
                "17. Task."
        };
        String[] output = {
                "2. Task.",
                "17. Task.",
                "22. Task."
        };
        Arrays.sort(input, new LexSort());
        assertThat(input).isEqualTo(output);
    }
}