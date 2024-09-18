package ru.job4j.queue;

import org.junit.jupiter.api.Test;

import java.util.Comparator;

import static org.assertj.core.api.Assertions.assertThat;
import static ru.job4j.queue.Position.*;

class ScheduleTaskTest {
    @Test
    void whenDirectorTaskThenReadMethodTest() {
        Comparator<Task> comparator = new TaskByPositionAsc().thenComparing(new TaskByUrgencyDesc());
        ScheduleTask scheduleTask = new ScheduleTask(comparator);
        scheduleTask.addTask(new Task(DEPARTMENT_HEAD, "description_1", 10));
        scheduleTask.addTask(new Task(DIRECTOR, "description_2", 4));
        scheduleTask.addTask((new Task(DIRECTOR, "description_3", 8)));
        String expected = "description_3";
        String result = scheduleTask.readTask().description();
        assertThat(result).isEqualTo(expected);
    }

    @Test
    void whenTwoDepartmentHeadTaskAndEqualUrgencyThenGetMethodTest() {
        Comparator<Task> comparator = new TaskByPositionAsc().thenComparing(new TaskByUrgencyDesc());
        ScheduleTask scheduleTask = new ScheduleTask(comparator);
        scheduleTask.addTask(new Task(DEPARTMENT_HEAD, "description_1", 7));
        scheduleTask.addTask(new Task(MANAGER, "description_2", 10));
        scheduleTask.addTask(new Task(DEPARTMENT_HEAD, "description_3", 7));
        String expected = "description_1";
        String result = scheduleTask.getTask().description();
        assertThat(result).isEqualTo(expected);
        scheduleTask.getTask();
        expected = "description_2";
        result = scheduleTask.getTask().description();
        assertThat(result).isEqualTo(expected);
    }

    @Test
    void whenDirectorHasHigherUrgencyThenMANAGERThenGetMethodTest() {
        Comparator<Task> comparator = new TaskByUrgencyDesc().thenComparing(new TaskByPositionAsc());
        ScheduleTask scheduleTask = new ScheduleTask(comparator);
        scheduleTask.addTask(new Task(MANAGER, "description_1", 9));
        scheduleTask.addTask(new Task(DEPARTMENT_HEAD, "description_2", 8));
        scheduleTask.addTask(new Task(DIRECTOR, "description_3", 10));
        String expected = "description_3";
        String result = scheduleTask.getTask().description();
        assertThat(result).isEqualTo(expected);
        var outcome = scheduleTask.readTask().position();
        assertThat(outcome).isEqualTo(MANAGER);
    }

    @Test
    void whenAllDepartmentHeadHasHigherUrgencyThenDecriptionOneGetMethodTest() {
        Comparator<Task> comparator = new TaskByUrgencyDesc().thenComparing(new TaskByPositionAsc());
        ScheduleTask scheduleTask = new ScheduleTask(comparator);
        scheduleTask.addTask(new Task(DEPARTMENT_HEAD, "description_1", 8));
        scheduleTask.addTask(new Task(DEPARTMENT_HEAD, "description_2", 9));
        scheduleTask.addTask(new Task(DEPARTMENT_HEAD, "description_3", 10));
        String expected = "description_3";
        String result = scheduleTask.getTask().description();
        assertThat(result).isEqualTo(expected);
        expected = "description_1";
        scheduleTask.getTask();
        result = scheduleTask.getTask().description();
        assertThat(result).isEqualTo(expected);
    }
}