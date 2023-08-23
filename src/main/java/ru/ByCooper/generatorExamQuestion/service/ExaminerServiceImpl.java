package ru.ByCooper.generatorExamQuestion.service;

import org.springframework.beans.factory.annotation.Qualifier;
import ru.ByCooper.generatorExamQuestion.exception.WrongVolumeException;
import ru.ByCooper.generatorExamQuestion.data.Question;
import org.springframework.stereotype.Service;

import java.util.*;

@Service
public class ExaminerServiceImpl implements ExaminerService {
    private final List<QuestionService> questionServices = new ArrayList<>();

    public ExaminerServiceImpl(@Qualifier("javaQuestionService") QuestionService javaQuestionService,
                               @Qualifier("mathQuestionService") QuestionService mathQuestionService) {
        questionServices.add(javaQuestionService);
        questionServices.add(mathQuestionService);
    }

    @Override
    public Collection<Question> getQuestions(int item) {
        Random random = new Random();
        Set<Question> questions = new HashSet<>();
            while (questions.size() < item) {
                questions.add(questionServices.get(random.nextInt(questionServices.size())).getRandomQuestion());
                System.out.println(questions);
            }
            return questions;
    }
}
