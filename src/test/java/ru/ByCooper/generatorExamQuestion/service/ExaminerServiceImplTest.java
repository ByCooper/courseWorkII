package ru.ByCooper.generatorExamQuestion.service;


import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import ru.ByCooper.generatorExamQuestion.exception.WrongVolumeException;
import ru.ByCooper.generatorExamQuestion.data.Question;

import java.util.*;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.*;

@ExtendWith(MockitoExtension.class)
class ExaminerServiceImplTest {

    @InjectMocks
    private ExaminerServiceImpl cut;

    @Mock
    private JavaQuestionService cutJavaMock;

    @Mock
    private MathQuestionService cutMathMock;

    public List<Question> javaDataTest() {
        List<Question> questions = new ArrayList<>();
        questions.add(new Question("Что такое JAVA", "Это язык программирования"));
        questions.add(new Question("Что такое i++", "Это инкремент"));
        questions.add(new Question("Что такое for", "Это цикл"));
        questions.add(new Question("Что такое Set", "Это множество"));
        questions.add(new Question("Что такое --i", "Это декремент"));
        return questions;
    }
    public List<Question> mathDataTest() {
        List<Question> questions = new ArrayList<>();
        questions.add(new Question("Что такое аксиома?", "Не доказываемая закономерность"));
        questions.add(new Question("Что такое сумма чисел?", "Результат сложения двух и более чисел"));
        questions.add(new Question("Что такое математика?", "Это гимнастика ума"));
        questions.add(new Question("Что такое многочлен?", "Это сумма одночленов"));
        questions.add(new Question("Что такое одночлен?", "Это произведение числовых и буквенных множителей, а также их степеней"));
        return questions;
    }

    public Collection<Question> testRandom(List<Question> i, List<Question> j) {
        List<Question> set = new ArrayList<>();
        set.addAll(i);
        set.addAll(j);
        return set;
    }

    @Test
    void testGetQuestions() {
        when(cutJavaMock.getAll()).thenReturn(javaDataTest());
        when(cutJavaMock.getRandomQuestion()).thenReturn(javaDataTest().get(0))
                .thenReturn(javaDataTest().get(1))
                .thenReturn(javaDataTest().get(2))
                .thenReturn(javaDataTest().get(3))
                .thenReturn(javaDataTest().get(4));
        when(cutMathMock.getRandomQuestion()).thenReturn(mathDataTest().get(0))
                .thenReturn(mathDataTest().get(1))
                .thenReturn(mathDataTest().get(2))
                .thenReturn(mathDataTest().get(3))
                .thenReturn(mathDataTest().get(4));
        Set<Question> actual = new HashSet<>(cut.getQuestions(5));
        assertTrue(testRandom(javaDataTest(), mathDataTest()).containsAll(actual));
    }

    @Test
    void testGetQuestionsException() {
        assertThrows(WrongVolumeException.class, () -> cut.getQuestions(15));
    }
}