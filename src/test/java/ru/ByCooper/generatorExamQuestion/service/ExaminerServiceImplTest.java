package ru.ByCooper.generatorExamQuestion.service;


import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import ru.ByCooper.generatorExamQuestion.exception.WrongVolumeException;
import ru.ByCooper.generatorExamQuestion.object.Question;

import java.util.*;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.*;

@ExtendWith(MockitoExtension.class)
class ExaminerServiceImplTest {

    @InjectMocks
    private ExaminerServiceImpl cut;

    @Mock
    private JavaQuestionService cutMock;

    private Set<Question> dataTest() {
        Set<Question> expected = new HashSet<>();
        expected.add(new Question("Что такое JAVA", "Это язык программирования"));
        expected.add(new Question("Что такое i++", "Это инкремент"));
        expected.add(new Question("Что такое for", "Это цикл"));
        expected.add(new Question("Что такое Set", "Это множество"));
        expected.add(new Question("Что такое --i", "Это декремент"));
        return expected;
    }
    private Question questionTest() {
       return new Question("Что такое JAVA", "Это язык программирования");
    }

    @Test
    void testGetQuestions() {
        when(cutMock.getAll()).thenReturn(dataTest());
        when(cutMock.getRandomQuestion()).thenReturn(questionTest());
        List<Question> actual = new ArrayList<>(cut.getQuestions(3));
        assertTrue(dataTest().containsAll(actual));
    }

    @Test
    void getQuestionsException() {
        assertThrows(WrongVolumeException.class, () -> cut.getQuestions(6));
    }
}