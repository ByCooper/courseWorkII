package ru.ByCooper.generatorExamQuestion.service;

import ru.ByCooper.generatorExamQuestion.object.Question;

import java.util.Collection;

public interface ExaminerService {
    Collection<Question> getQuestions(int item);
}
