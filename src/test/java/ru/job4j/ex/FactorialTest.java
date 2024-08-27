package ru.job4j.ex;

import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.assertThrows;

class FactorialTest {

    @Test
    void whenFactorialNumberIsNegative() {
        IllegalArgumentException exception = assertThrows(
                IllegalArgumentException.class,
                () -> {
                    new Factorial().calc(-2);
                });
        assertThat(exception.getMessage()).isEqualTo("Number could not be less than 0");
    }

    @Test
    void whenNumerisZeroThanOne() {
        int result = new Factorial().calc(0);
        int expected = 1;
        assertThat(result).isEqualTo(expected);
    }
}