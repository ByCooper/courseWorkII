package ru.ByCooper.generatorExamQuestion.service;

import org.springframework.stereotype.Service;
import ru.ByCooper.generatorExamQuestion.data.Question;
import ru.ByCooper.generatorExamQuestion.exception.UnsupportedOperationException;

import java.util.Collection;
import java.util.Random;

@Service
public class MathQuestionService implements QuestionService {

    @Override
    public Question add(String question, String answer) {
        throw new UnsupportedOperationException();
    }

    @Override
    public Question add(Question question) {
        throw new UnsupportedOperationException();
    }

    @Override
    public Question remove(Question question) {
        throw new UnsupportedOperationException();
    }

    @Override
    public Collection<Question> getAll() {
        throw new UnsupportedOperationException();
    }

    @Override
    public Question getRandomQuestion() {
        Random random = new Random();
        if (random.nextBoolean()) {
            if (random.nextBoolean()) {
                int a = random.nextInt(1000);
                int b = random.nextInt(1000);
                return new Question(a + " + " + b + " ?", (a + b) + " ");
            } else {
                int a = random.nextInt(1000);
                int b = random.nextInt(1000);
                return new Question(a + " - " + b + " ?", (a - b) + " ");
            }
        } else {
            if (random.nextBoolean()) {
                int a = random.nextInt(1000);
                int b = random.nextInt(1000);
                return new Question(a + " * " + b + " ?", (a * b) + " ");
            } else {
                double a = random.nextInt(1000);
                double b = random.nextInt(1000);
                return new Question(a + " : " + b + " ?", (a / b) + " ");
            }
        }
    }
}
