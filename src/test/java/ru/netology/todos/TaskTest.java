package ru.netology.todos;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class TaskTest {
    @Test
    public void testGetTitle() {
        SimpleTask simpleTask = new SimpleTask(12, "Поехать на дачу");
        String actual = simpleTask.getTitle();
        String expected = "Поехать на дачу";
        Assertions.assertEquals(expected, actual);

    }

    @Test
    public void testGetId() {
        SimpleTask simpleTask = new SimpleTask(12, "Поехать на дачу");
        int actual = simpleTask.getId();
        int expected = 12;
        Assertions.assertEquals(expected, actual);

    }

    @Test
    public void testMatchesForSimpleTaskWhenTrue() {
        SimpleTask simpleTask = new SimpleTask(5, "Позвонить родителям");

        boolean actual = simpleTask.matches("родителям");
        boolean expected = true;

        Assertions.assertEquals(expected, actual);
    }

    @Test
    public void testMatchesForSimpleTaskWhenFalse() {
        SimpleTask simpleTask = new SimpleTask(5, "Позвонить родителям");

        boolean actual = simpleTask.matches("бабушке");
        boolean expected = false;

        Assertions.assertEquals(expected, actual);
    }

    @Test
    public void testMatchesForEpicTaskTrue() {
        String[] subtasks = {"Молоко", "Яйца", "Хлеб"};
        Epic epic = new Epic(55, subtasks);

        boolean actual = epic.matches("Яйца");
        boolean expected = true;

        Assertions.assertEquals(actual, expected);
    }

    @Test
    public void testMatchesForEpicTaskFalse() {
        String[] subtasks = {"Молоко", "Яйца", "Хлеб"};
        Epic epic = new Epic(55, subtasks);

        boolean actual = epic.matches("Окорок");
        boolean expected = false;
        Assertions.assertEquals(actual, expected);
    }

    @Test
    public void testGetSubtasks() {
        String[] subtasks = {"Молоко", "Яйца", "Хлеб"};
        Epic epic = new Epic(55, subtasks);
        String[] actual = subtasks;
        String[] expected = epic.getSubtasks();
        Assertions.assertEquals(actual, expected);
    }

    @Test
    public void testMatchesForMeetingTopicTrue() {
        Meeting meeting = new Meeting(
                555,
                "Выкатка 3й версии приложения",
                "Приложение НетоБанка",
                "Во вторник после обеда");

        boolean actual = meeting.matches("версии");
        boolean expected = true;
        Assertions.assertEquals(actual, expected);
    }

    @Test
    public void testMatchesForMeetingTopicFalse() {
        Meeting meeting = new Meeting(
                555,
                "Выкатка 3й версии приложения",
                "Приложение НетоБанка",
                "Во вторник после обеда");

        boolean actual = meeting.matches("Программа");
        boolean expected = false;
        Assertions.assertEquals(actual, expected);
    }

    @Test
    public void testMatchesForMeetingProjectTrue() {
        Meeting meeting = new Meeting(
                555,
                "Выкатка 3й версии приложения",
                "Приложение НетоБанка",
                "Во вторник после обеда");

        boolean actual = meeting.matches("НетоБанка");
        boolean expected = true;
        Assertions.assertEquals(actual, expected);
    }

    @Test
    public void testMatchesForMeetingProjectFalse() {
        Meeting meeting = new Meeting(
                555,
                "Выкатка 3й версии приложения",
                "Приложение НетоБанка",
                "Во вторник после обеда");

        boolean actual = meeting.matches("Программа");
        boolean expected = false;
        Assertions.assertEquals(actual, expected);
    }

    @Test
    void getTopic() {
        Meeting meeting = new Meeting(
                555,
                "Выкатка 3й версии приложения",
                "Приложение НетоБанка",
                "Во вторник после обеда");

        String actual = meeting.getTopic();
        String expected = "Выкатка 3й версии приложения";
        Assertions.assertEquals(actual, expected);
    }

    @Test
    void getProject() {
        Meeting meeting = new Meeting(
                555,
                "Выкатка 3й версии приложения",
                "Приложение НетоБанка",
                "Во вторник после обеда");

        String actual = meeting.getProject();
        String expected = "Приложение НетоБанка";
        Assertions.assertEquals(actual, expected);
    }

    @Test
    void getStart() {
        Meeting meeting = new Meeting(
                555,
                "Выкатка 3й версии приложения",
                "Приложение НетоБанка",
                "Во вторник после обеда");

        String actual = meeting.getStart();
        String expected = "Во вторник после обеда";
        Assertions.assertEquals(actual, expected);
    }


}