package ru.job4j.function;

import org.junit.jupiter.api.Test;

import java.util.Arrays;
import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

class FunctionCalculatorTest {
    @Test
    void whenLinearFunctionThenLinearResults() {
        FunctionCalculator function = new FunctionCalculator();
        List<Double> result = function.diapason(5, 8, x -> 2 * x + 1);
        List<Double> expected = Arrays.asList(11D, 13D, 15D);
        assertThat(result).containsAll(expected);
    }

    @Test
    void whenNonLinearFunctionThenLinearResults() {
        FunctionCalculator function = new FunctionCalculator();
        List<Double> result = function.diapason(5, 8, x -> 4 * Math.pow(x, 2) + 5 * x + 9);
        List<Double> expected = Arrays.asList(134.0, 183.0, 240.0);
        assertThat(result).containsAll(expected);
    }

    @Test
    void whenExponentialFunctionThenLinearResults() {
        FunctionCalculator function = new FunctionCalculator();
        List<Double> result = function.diapason(2, 5, x -> Math.pow(x, 3));
        List<Double> expected = Arrays.asList(8.0, 27.0, 64.0);
        assertThat(result).containsAll(expected);
    }

    @Test
    void whenExponentialFunctionWhenXIsPowerThenLinearResults() {
        FunctionCalculator function = new FunctionCalculator();
        List<Double> result = function.diapason(2, 5, x -> Math.pow(2, x));
        List<Double> expected = Arrays.asList(4.0, 8.0, 16.0);
        assertThat(result).containsAll(expected);
    }
}