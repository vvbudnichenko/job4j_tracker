package ru.job4j.oop;

import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

public class BatteryTest {

    @Test
    public void whenThis30Another50ThenAnotherLoadEqual80() {
        Battery charger = new Battery(30);
        Battery another = new Battery(50);
        charger.exchange(another);
        int expected = 80;
        assertThat(another.about()).isEqualTo("My charge: " + expected + "%");
    }

    @Test
    public void whenThis80Another20ThenThisLoadEqual0() {
        Battery charger = new Battery(80);
        Battery another = new Battery(20);
        charger.exchange(another);
        int expected = 0;
        assertThat(charger.about()).isEqualTo("My charge: " + expected + "%");
    }

    @Test
    public void whenThis95Another0ThenAnotherLoadEqual80() {
        Battery charger = new Battery(95);
        Battery another = new Battery(0);
        charger.exchange(another);
        int expected = 95;
        assertThat(another.about()).isEqualTo("My charge: " + expected + "%");
    }

    @Test
    public void whenThis70AnotherFirst20AnotherSecond10ThenAnotherLoadEqual100() {
        Battery chargerFirst = new Battery(20);
        Battery chargerSecond = new Battery(10);
        Battery another = new Battery(70);
        chargerFirst.exchange(another);
        chargerSecond.exchange(another);
        int expected = 100;
        assertThat(another.about()).isEqualTo("My charge: " + expected + "%");
    }
}