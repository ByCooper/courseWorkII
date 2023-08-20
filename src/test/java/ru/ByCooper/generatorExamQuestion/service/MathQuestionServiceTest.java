package ru.ByCooper.generatorExamQuestion.service;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import ru.ByCooper.generatorExamQuestion.data.MathQuestionRepository;
import ru.ByCooper.generatorExamQuestion.data.Question;

import java.util.Collection;
import java.util.HashSet;
import java.util.Set;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.when;

@ExtendWith(MockitoExtension.class)
class MathQuestionServiceTest {

    @InjectMocks
    private MathQuestionService cut;

    @Mock
    private MathQuestionRepository cutMock;


    public Collection<Question> setTest() {
        Set<Question> questions = new HashSet<>();
        questions.add(new Question("Что такое аксиома?", "Не доказываемая закономерность"));
        questions.add(new Question("Что такое сумма чисел?", "Результат сложения двух и более чисел"));
        questions.add(new Question("Что такое математика?", "Это гимнастика ума"));
        questions.add(new Question("Что такое многочлен?", "Это сумма одночленов"));
        questions.add(new Question("Что такое одночлен?", "Это произведение числовых и буквенных множителей, а также их степеней"));
        return questions;
    }

    public Question questionTest() {
        return new Question("Что такое математика?", "Это гимнастика ума");
    }


    @Test
    void testAddRepo() {
        //Подготовка входных данных
        when(cutMock.getAll()).thenReturn(setTest());
        when(cutMock.add(any())).thenReturn(questionTest());
        String question = "Что такое математика?";
        String answer = "Это гимнастика ума";
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
        String question = "Что такое математика?";
        String answer = "Это гимнастика ума";
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
        String question = "Что такое математика?";
        String answer = "Это гимнастика ума";
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