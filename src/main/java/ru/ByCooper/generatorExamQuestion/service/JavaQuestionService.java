package ru.ByCooper.generatorExamQuestion.service;

import ru.ByCooper.generatorExamQuestion.data.JavaQuestionRepository;
import ru.ByCooper.generatorExamQuestion.data.Question;
import org.springframework.stereotype.Service;

import java.util.*;

@Service
public class JavaQuestionService implements QuestionService {

    private final JavaQuestionRepository javaRepo;

    public JavaQuestionService(JavaQuestionRepository repository) {
        this.javaRepo = repository;
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
        return javaRepo.add(question);
    }

    @Override
    public Question remove(Question question) {
        return javaRepo.remove(question);
    }

    @Override
    public Collection<Question> getAll() {
        return javaRepo.getAll();
    }

    @Override
    public Question getRandomQuestion() {
        Random random = new Random();
        List<Question> list = new ArrayList<>(javaRepo.getAll());
        int item = random.nextInt(getAll().size());
        return list.get(item);
    }
}
