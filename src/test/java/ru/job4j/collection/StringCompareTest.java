package ru.job4j.collection;

import org.junit.jupiter.api.Test;
import static org.assertj.core.api.Assertions.assertThat;

public class StringCompareTest {
    @Test
    public void whenStringsAreEqualThenZero() {
        StringCompare compare = new StringCompare();
        int result = compare.compare(
                "Ivanov",
                "Ivanov"
        );
        assertThat(result).isEqualTo(0);
    }

    @Test
    public void whenLeftLessThanRightResultShouldBeNegative() {
        StringCompare compare = new StringCompare();
        int result = compare.compare(
                "Ivanov",
                "Ivanova"
        );
        assertThat(result).isLessThan(0);
    }

    @Test
    public void whenLeftGreaterThanRightResultShouldBePositive() {
        StringCompare compare = new StringCompare();
        int result = compare.compare(
                "Petrov",
                "Ivanova"
        );
        assertThat(result).isGreaterThan(0);
    }

    @Test
    public void secondCharOfLeftGreaterThanRightShouldBePositive() {
        StringCompare compare = new StringCompare();
        int result = compare.compare(
                "Petrov",
                "Patrov"
        );
        assertThat(result).isGreaterThan(0);
    }

    @Test
    public void secondCharOfLeftLessThanRightShouldBeNegative() {
        StringCompare compare = new StringCompare();
        int result = compare.compare(
                "Patrova",
                "Petrov"
        );
        assertThat(result).isLessThan(0);
    }

    @Test
    public void whenRightLessThanLeftResultShouldBeNegative() {
        StringCompare compare = new StringCompare();
        int result = compare.compare(
                "Aalto",
                "Lang"
        );
        assertThat(result).isLessThan(0);
    }

    @Test
    public void whenRightGreaterThanLeftResultShouldBePositive() {
        StringCompare compare = new StringCompare();
        int result = compare.compare(
                "Ivanova",
                "Ivanov"
        );
        assertThat(result).isGreaterThan(0);
    }

    @Test
    public void whenRightNumberGreaterThanLeftNumberResultShouldBePositive() {
        StringCompare compare = new StringCompare();
        int result = compare.compare(
                "6",
                "5"
        );
        assertThat(result).isGreaterThan(0);
    }

    @Test
    public void whenRightNumberLetterGreaterThanLeftNumberLetterResultShouldBePositive() {
        StringCompare compare = new StringCompare();
        int result = compare.compare(
                "A6",
                "A5"
        );
        assertThat(result).isGreaterThan(0);
    }
}