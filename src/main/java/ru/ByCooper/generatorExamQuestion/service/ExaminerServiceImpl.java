package ru.ByCooper.generatorExamQuestion.service;

import org.springframework.beans.factory.annotation.Qualifier;
import ru.ByCooper.generatorExamQuestion.exception.WrongVolumeException;
import ru.ByCooper.generatorExamQuestion.data.Question;
import org.springframework.stereotype.Service;

import java.util.Collection;
import java.util.HashSet;
import java.util.Random;
import java.util.Set;

@Service
public class ExaminerServiceImpl implements ExaminerService {
    private final JavaQuestionService javaQuestionService;
    private final MathQuestionService mathQuestionService;

    public ExaminerServiceImpl(@Qualifier("javaQuestionService") JavaQuestionService questionService,
                               @Qualifier("mathQuestionService") MathQuestionService mathQuestionService) {
        this.javaQuestionService = questionService;
        this.mathQuestionService = mathQuestionService;
    }

    @Override
    public Collection<Question> getQuestions(int item) {
        Random random = new Random();
        Set<Question> questions = new HashSet<>();
        if (item <= javaQuestionService.getAll().size()) {
            while (questions.size() < item) {
                if (random.nextBoolean()) {
                    questions.add(javaQuestionService.getRandomQuestion());
                } else {
                    questions.add(mathQuestionService.getRandomQuestion());
                }
            }
            return questions;
        }
        if (item > javaQuestionService.getAll().size() + mathQuestionService.getAll().size()) {
            throw new WrongVolumeException("Количество запрашиваемых вопросов превышает общее количество вопросов");
        }
        return null;
    }
}
