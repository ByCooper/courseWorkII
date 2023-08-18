package ru.ByCooper.generatorExamQuestion.service;

import ru.ByCooper.generatorExamQuestion.exception.WrongVolumeException;
import ru.ByCooper.generatorExamQuestion.object.Question;
import org.springframework.stereotype.Service;

import java.util.Collection;
import java.util.HashSet;
import java.util.Set;

@Service
public class ExaminerServiceImpl implements ExaminerService {
    private final JavaQuestionService questionService;

    public ExaminerServiceImpl(JavaQuestionService questionService) {
        this.questionService = questionService;
    }

    @Override
    public Collection<Question> getQuestions(int item) {
        Set<Question> questions = new HashSet<>();
        if (item <= questionService.getAll().size()) {
            while (questions.size() < item) {
                questions.add(questionService.getRandomQuestion());
            }
            return questions;
        }
        if (item > questionService.getAll().size()) {
            throw new WrongVolumeException("Количество запрашиваемых вопросов превышает общее количество вопросов");
        }
        return null;
    }
}
