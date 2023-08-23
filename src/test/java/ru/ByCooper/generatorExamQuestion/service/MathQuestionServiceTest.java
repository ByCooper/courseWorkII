package ru.ByCooper.generatorExamQuestion.service;

import org.junit.jupiter.api.Test;
import ru.ByCooper.generatorExamQuestion.data.Question;
import ru.ByCooper.generatorExamQuestion.exception.UnsupportedOperationException;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.ArgumentMatchers.any;

class MathQuestionServiceTest {

    MathQuestionService cut = new MathQuestionService();

    @Test
    void testAddRepo() {
        assertThrows(UnsupportedOperationException.class, () ->
                cut.add(new Question("q", "a")));
    }

    @Test
    void testAdd() {
        assertThrows(UnsupportedOperationException.class, () ->
                cut.add("q", "a"));
    }

    @Test
    void testRemove() {
        assertThrows(UnsupportedOperationException.class, () ->
                cut.remove(new Question("q", "a")));
    }

    @Test
    void testGetAll() {
        assertThrows(UnsupportedOperationException.class, () ->
                cut.getAll());
    }

    @Test
    void testGetRandomQuestion() {
        //Подготовка входных данных
        Question actual = cut.getRandomQuestion();

        //Начало теста
        assertEquals(Question.class, actual.getClass());

    }
}