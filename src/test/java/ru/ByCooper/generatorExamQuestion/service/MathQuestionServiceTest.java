package ru.ByCooper.generatorExamQuestion.service;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import ru.ByCooper.generatorExamQuestion.data.Question;
import ru.ByCooper.generatorExamQuestion.exception.MathNullException;

import java.util.Collection;
import java.util.HashSet;
import java.util.Set;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.when;

class MathQuestionServiceTest {

    MathQuestionService cut = new MathQuestionService();

    @Test
    void testAddRepo() {
        assertThrows(MathNullException.class, () ->
                cut.add(new Question("q", "a")));
    }

    @Test
    void testAdd() {
        assertThrows(MathNullException.class, () ->
                cut.add("q", "a"));
    }

    @Test
    void testRemove() {
        assertThrows(MathNullException.class, () ->
                cut.remove(new Question("q", "a")));
    }

    @Test
    void testGetAll() {
        assertThrows(MathNullException.class, () ->
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