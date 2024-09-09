package ru.job4j.collection;

import org.junit.jupiter.api.Test;
import static org.assertj.core.api.Assertions.assertThat;

public class UniqueTextTest {
    @Test
    public void isEquals() {
        UniqueText uniqueText = new UniqueText();
        String origin = "My cat eats a mouse";
        String text = "My cat eats a mouse";
        assertThat(uniqueText.isEquals(origin, text)).isTrue();
    }

    @Test
    public void isNotEquals() {
        UniqueText uniqueText = new UniqueText();
        String origin = "My cat eats a mouse";
        String text = "A mouse is eaten by a cat";
        assertThat(uniqueText.isEquals(origin, text)).isFalse();
    }

    @Test
    public void isEqualsAndReplaceWordsForTest() {
        UniqueText uniqueText = new UniqueText();
        String origin = "A life is the longest road";
        String text = "A road is the longest life";
        assertThat(uniqueText.isEquals(origin, text)).isTrue();
    }
}