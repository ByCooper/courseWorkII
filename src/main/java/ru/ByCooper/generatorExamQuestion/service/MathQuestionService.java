package ru.ByCooper.generatorExamQuestion.service;

import org.springframework.stereotype.Service;
import ru.ByCooper.generatorExamQuestion.data.MathQuestionRepository;
import ru.ByCooper.generatorExamQuestion.data.Question;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import java.util.Random;

@Service
public class MathQuestionService implements QuestionService {

    private final MathQuestionRepository mathRepo;

    public MathQuestionService(MathQuestionRepository mathRepo) {
        this.mathRepo = mathRepo;
    }

    private Question generate(String question, String answer) {
        return new Question(question, answer);
    }

    @Override
    public Question add(String question, String answer) {
        return generate(question, answer);
    }

    @Override
    public Question add(Question question) {
        return mathRepo.add(question);
    }

    @Override
    public Question remove(Question question) {
        return mathRepo.remove(question);
    }

    @Override
    public Collection<Question> getAll() {
        return mathRepo.getAll();
    }

    @Override
    public Question getRandomQuestion() {
        Random random = new Random();
        List<Question> list = new ArrayList<>(mathRepo.getAll());
        int item = random.nextInt(getAll().size());
        return list.get(item);
    }
}
