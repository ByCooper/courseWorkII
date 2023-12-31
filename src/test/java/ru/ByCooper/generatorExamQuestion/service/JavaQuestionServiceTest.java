package ru.ByCooper.generatorExamQuestion.service;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import ru.ByCooper.generatorExamQuestion.data.JavaQuestionRepository;
import ru.ByCooper.generatorExamQuestion.data.Question;

import java.util.Collection;
import java.util.HashSet;
import java.util.Set;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.when;

@ExtendWith(MockitoExtension.class)
class JavaQuestionServiceTest {
    @InjectMocks
    private JavaQuestionService cut;
    @Mock
    private JavaQuestionRepository cutMock;

    public Collection<Question> setTest() {
        Set<Question> questions = new HashSet<>();
        questions.add(new Question("Что такое JAVA", "Это язык программирования"));
        questions.add(new Question("Что такое i++", "Это инкремент"));
        questions.add(new Question("Что такое for", "Это цикл"));
        questions.add(new Question("Что такое Set", "Это множество"));
        questions.add(new Question("Что такое --i", "Это декремент"));
        return questions;
    }

    public Question questionTest() {
        return new Question("Что такое JAVA", "Это язык программирования");
    }


    @Test
    void testAddRepo() {
        //Подготовка входных данных
        when(cutMock.getAll()).thenReturn(setTest());
        when(cutMock.add(any())).thenReturn(questionTest());
        String question = "Что такое JAVA";
        String answer = "Это язык программирования";
        Question actual = cut.add(new Question(question, answer));
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
        when(cutMock.getAll()).thenReturn(setTest());
        String question = "Что такое JAVA";
        String answer = "Это язык программирования";
        Question actual = cut.add(question, answer);
        Question question1 = new Question(question, answer);

        //Подготовка ожидаемого результата
        Question expected = new Question(question, answer);

        //Начало теста
        assertEquals(expected, actual);
        assertTrue(cut.getAll().contains(question1));
    }

    @Test
    void testRemove() {
        //Подготовка входных данных
        when(cutMock.remove(any())).thenReturn(questionTest());
        String question = "Что такое JAVA";
        String answer = "Это язык программирования";
        Question question1 = new Question(question, answer);
        Question actual = cut.remove(question1);

        //Подготовка ожидаемого результата
        Question expected = new Question(question, answer);

        //Начало теста
        assertEquals(expected, actual);
    }

    @Test
    void testGetAll() {
        //Подготовка входных данных
        when(cutMock.getAll()).thenReturn(setTest());
        Collection<Question> actual = cut.getAll();

        //Подготовка ожидаемого результата
        Collection<Question> expected = cut.getAll();

        //Начало теста
        assertArrayEquals(expected.toArray(), actual.toArray());
    }

    @Test
    void testGetRandomQuestion() {
        //Подготовка входных данных
        when(cutMock.getAll()).thenReturn(setTest());
        Question actual = cut.getRandomQuestion();

        //Подготовка ожидаемого результата
        Collection<Question> expected = setTest();

        //Начало теста
        assertTrue(expected.contains(actual));
    }
}