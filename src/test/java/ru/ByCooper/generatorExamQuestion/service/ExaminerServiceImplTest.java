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

    public List<Question> javaDataTest() {
        List<Question> questions = new ArrayList<>();
        questions.add(new Question("Что такое JAVA", "Это язык программирования"));
        questions.add(new Question("Что такое i++", "Это инкремент"));
        questions.add(new Question("Что такое for", "Это цикл"));
        questions.add(new Question("Что такое Set", "Это множество"));
        questions.add(new Question("Что такое --i", "Это декремент"));
        return questions;
    }

    @Test
    void testGetQuestions() {
        when(cutJavaMock.getRandomQuestion()).thenReturn(javaDataTest().get(0))
                .thenReturn(javaDataTest().get(1))
                .thenReturn(javaDataTest().get(2))
                .thenReturn(javaDataTest().get(3))
                .thenReturn(javaDataTest().get(4));
        Set<Question> actual = new HashSet<>(cut.getQuestions(5));
        assertTrue(javaDataTest().containsAll(actual));
    }
}