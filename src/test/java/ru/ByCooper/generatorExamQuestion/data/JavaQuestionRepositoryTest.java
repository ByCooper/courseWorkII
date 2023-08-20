package ru.ByCooper.generatorExamQuestion.data;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Qualifier;

import java.util.ArrayList;
import java.util.Collection;
import java.util.HashSet;

import static org.junit.jupiter.api.Assertions.*;

class JavaQuestionRepositoryTest {

    JavaQuestionRepository cut = new JavaQuestionRepository();

    @Test
    void testAdd() {
        //Подготовка входных данных
        Question actual = cut.add(new Question("question1", "answer1"));

        //Подготовка ожидаемого результата
        Question expected = new Question("question1", "answer1");

        //Начало теста
        assertEquals(expected, actual);
    }

    @Test
    void remove() {
        //Подготовка входных данных
        cut.add(new Question("Что такое JAVA", "Это язык программирования"));
        Question actual = cut.remove(new Question("Что такое JAVA", "Это язык программирования"));

        //Подготовка ожидаемого результата
        Question expected = new Question("Что такое JAVA", "Это язык программирования");

        //Начало теста
        assertEquals(expected, actual);
        System.out.println(cut.getAll());
        assertFalse(cut.getAll().contains(actual));
    }

    @Test
    void getAll() {
        //Подготовка входных данных
        cut.add(new Question("Что такое JAVA", "Это язык программирования"));
        Collection<Question> actual = cut.getAll();

        //Подготовка ожидаемого результата
        Collection<Question> expected = new HashSet<>();
        expected.add(new Question("Что такое JAVA", "Это язык программирования"));

        //Начало теста
        assertArrayEquals(expected.toArray(), actual.toArray());
    }
}