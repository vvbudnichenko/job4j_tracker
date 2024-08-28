package ru.job4j.tracker.input;

import org.junit.jupiter.api.Test;
import ru.job4j.tracker.output.Output;
import ru.job4j.tracker.output.StubOutput;

import static org.assertj.core.api.Assertions.assertThat;

class ValidateInputTest {

    @Test
    void whenInvalidInput() {
        Output output = new StubOutput();
        Input in = new MockInput(
                new String[]{"one", "1"}
        );
        ValidateInput input = new ValidateInput(output, in);
        int selected = input.askInt("Enter menu");
        assertThat(selected).isEqualTo(1);
    }

    @Test
    void whenInvalidInputFive() {
        Output output = new StubOutput();
        Input in = new MockInput(
                new String[]{"9"}
        );
        ValidateInput input = new ValidateInput(output, in);
        int selected = input.askInt("Enter menu");
        assertThat(selected).isEqualTo(9);
    }

    @Test
    void whenValidInputSomeTimes() {
        Output output = new StubOutput();
        Input in = new MockInput(
                new String[]{"1", "2", "5", "3", "4", "6"}
        );
        ValidateInput input = new ValidateInput(output, in);
        int selected = input.askInt("Enter menu");
        assertThat(selected).isEqualTo(1);
        selected = input.askInt("Enter menu");
        assertThat(selected).isEqualTo(2);
        selected = input.askInt("Enter menu");
        assertThat(selected).isEqualTo(5);
        selected = input.askInt("Enter menu");
        assertThat(selected).isEqualTo(3);
        selected = input.askInt("Enter menu");
        assertThat(selected).isEqualTo(4);
        selected = input.askInt("Enter menu");
        assertThat(selected).isEqualTo(6);
    }

    @Test
    void whenInputValueIsNegative() {
        Output output = new StubOutput();
        Input in = new MockInput(
                new String[]{"-1", "-5"}
        );
        ValidateInput input = new ValidateInput(output, in);
        int selected = input.askInt("Enter menu");
        assertThat(selected).isEqualTo(-1);
        selected = input.askInt("Enter menu");
        assertThat(selected).isEqualTo(-5);
    }
}