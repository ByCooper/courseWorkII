package ru.ByCooper.generatorExamQuestion.data;

import java.util.Collection;

public interface QuestionRepository {

    Question add(Question question);
    Question remove(Question question);
    Collection<Question> getAll();
}
