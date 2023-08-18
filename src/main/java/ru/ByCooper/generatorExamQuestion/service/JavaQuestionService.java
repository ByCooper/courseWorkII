package ru.ByCooper.generatorExamQuestion.service;

import ru.ByCooper.generatorExamQuestion.object.Question;
import org.springframework.stereotype.Service;

import java.util.*;

@Service
public class JavaQuestionService implements QuestionService {

    private final Set<Question> questions = new HashSet<>();
    Random random = new Random();

    private Question generate(String question, String answer){
        return new Question(question, answer);
    }

    @Override
    public Question add(String question, String answer) {
        questions.add(generate(question, answer));
        return generate(question, answer);
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

    @Override
    public Question getRandomQuestion() {
        List<Question> list = new ArrayList<>(getAll());
        int item = random.nextInt(getAll().size());
        return list.get(item);
    }
}
