package ru.ByCooper.generatorExamQuestion.data;

import org.springframework.stereotype.Repository;

import javax.annotation.PostConstruct;
import java.util.Collection;
import java.util.HashSet;
import java.util.Set;
@Repository
public class MathQuestionRepository implements QuestionRepository{

    Set<Question> questions = new HashSet<>();

    @PostConstruct
    private void init() {
        questions.add(new Question("Что такое аксиома?", "Не доказываемая закономерность"));
        questions.add(new Question("Что такое сумма чисел?", "Результат сложения двух и более чисел"));
        questions.add(new Question("Что такое математика?", "Это гимнастика ума"));
        questions.add(new Question("Что такое многочлен?", "Это сумма одночленов"));
        questions.add(new Question("Что такое одночлен?", "Это произведение числовых и буквенных множителей, а также их степеней"));
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
