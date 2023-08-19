package ru.ByCooper.generatorExamQuestion.service;

import org.junit.jupiter.api.Test;
import ru.ByCooper.generatorExamQuestion.object.Question;

import java.util.Collection;
import java.util.HashSet;
import java.util.Set;

import static org.junit.jupiter.api.Assertions.*;

class JavaQuestionServiceTest {

    JavaQuestionService cut = new JavaQuestionService();
    @Test
    void add() {
        //Подготовка входных данных
        String question = "Что такое JAVA";
        String answer = "Язык программирования";
        Question actual = cut.add(question, answer);
        Question question1 = new Question(question, answer);

        //Подготовка ожидаемого результата
        Question expected = new Question(question, answer);

        //Начало теста
        assertEquals(expected, actual);
        assertTrue(cut.getAll().contains(question1));
    }

    @Test
    void testAdd() {
        //Подготовка входных данных
        String question = "Что такое JAVA";
        String answer = "Язык программирования";
        Question question1 = new Question(question, answer);
        Question actual = cut.add(question1);

        //Подготовка ожидаемого результата
        Question expected = new Question(question, answer);

        //Начало теста
        assertEquals(expected, actual);
        assertTrue(cut.getAll().contains(question1));
    }

    @Test
    void remove() {
        //Подготовка входных данных
        String question = "Что такое JAVA";
        String answer = "Язык программирования";
        Question question1 = new Question(question, answer);
        cut.add(question1);
        Question actual = cut.remove(question1);

        //Подготовка ожидаемого результата
        Question expected = new Question(question, answer);

        //Начало теста
        assertEquals(expected, actual);
        assertFalse(cut.getAll().contains(question1));
    }

    @Test
    void getAll() {
        //Подготовка входных данных
        cut.add("Что такое JAVA", "Это язык программирования");
        cut.add("Что такое Set", "Это множество");
        cut.add("Что такое for", "Это цикл");
        Collection<Question> actual = cut.getAll();

        //Подготовка ожидаемого результата
        Collection<Question> expected = new HashSet<>();
        expected.add(new Question("Что такое JAVA", "Это язык программирования"));
        expected.add(new Question("Что такое Set", "Это множество"));
        expected.add(new Question("Что такое for", "Это цикл"));

        //Начало теста
        assertArrayEquals(expected.toArray(), actual.toArray());
    }

    @Test
    void getRandomQuestion() {
        //Подготовка входных данных
        cut.add("Что такое JAVA", "Это язык программирования");
        cut.add("Что такое Set", "Это множество");
        cut.add("Что такое for", "Это цикл");
        Question actual = cut.getRandomQuestion();

        //Подготовка ожидаемого результата
        Set<Question> expected = new HashSet<>();
        expected.add(new Question("Что такое JAVA", "Это язык программирования"));
        expected.add(new Question("Что такое Set", "Это множество"));
        expected.add(new Question("Что такое for", "Это цикл"));

        //Начало теста
        assertTrue(expected.contains(actual));
    }
}