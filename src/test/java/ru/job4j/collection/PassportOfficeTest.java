package ru.job4j.collection;

import org.junit.jupiter.api.Test;
import static org.assertj.core.api.Assertions.assertThat;

public class PassportOfficeTest {
    @Test
    public void whenTestAddMethod() {
        Citizen citizen = new Citizen("2f44a", "Petr Arsentev");
        PassportOffice office = new PassportOffice();
        office.add(citizen);
        assertThat(office.get(citizen.getPassport())).isEqualTo(citizen);
    }

    @Test
    public void whenTestAddSamePassport() {
        Citizen citizen = new Citizen("112233R", "Lida Ivanova");
        Citizen citizenTwo = new Citizen("112233R", "Kira Ivanova");
        PassportOffice office = new PassportOffice();
        office.add(citizen);
        boolean added = office.add(citizenTwo);
        assertThat(added).isFalse();
        assertThat(office.get(citizen.getPassport())).isEqualTo(citizen);
    }

    @Test
    public void whenNoOneCitizenIsNull() {
        Citizen citizen = new Citizen("", "");
        PassportOffice office = new PassportOffice();
        assertThat(office.get(citizen.getPassport())).isNull();
    }
}