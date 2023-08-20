package ru.ByCooper.generatorExamQuestion.data;

import org.springframework.stereotype.Repository;

import javax.annotation.PostConstruct;
import java.util.Collection;
import java.util.HashSet;
import java.util.Set;
@Repository
public class JavaQuestionRepository implements QuestionRepository{
    Set<Question> questions = new HashSet<>();

    @PostConstruct
    private void init() {
        questions.add(new Question("Что такое JAVA", "Это язык программирования"));
        questions.add(new Question("Что такое i++", "Это инкремент"));
        questions.add(new Question("Что такое for", "Это цикл"));
        questions.add(new Question("Что такое Set", "Это множество"));
        questions.add(new Question("Что такое --i", "Это декремент"));
    }

    @Override
    public Question add(Question question) {
        questions.add(question);
        return question;
    }

    @Override
    public Question remove(Question question) {
        questions.remove(question);
        return question;
    }

    @Override
    public Collection<Question> getAll() {
        return questions;
    }
}
