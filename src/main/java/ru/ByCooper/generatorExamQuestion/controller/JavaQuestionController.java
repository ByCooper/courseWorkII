package ru.ByCooper.generatorExamQuestion.controller;

import ru.ByCooper.generatorExamQuestion.object.Question;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import ru.ByCooper.generatorExamQuestion.service.JavaQuestionService;

import java.util.Collection;

@RestController
@RequestMapping("/exam/java")
public class JavaQuestionController {

    private final JavaQuestionService javaQuestionService;

    public JavaQuestionController(JavaQuestionService javaQuestionService) {
        this.javaQuestionService = javaQuestionService;
    }

    @GetMapping("/add")
    public Question getAdd(@RequestParam("question") String question, @RequestParam("answer") String answer) {
        return javaQuestionService.add(new Question(question, answer));
    }
    @GetMapping("/remove")
    public Question getRemove(@RequestParam("question") String question, @RequestParam("answer") String answer) {
        return javaQuestionService.remove(new Question(question, answer));
    }
    @GetMapping()
    public Collection<Question> getAll() {
        return javaQuestionService.getAll();
    }

//    @GetMapping("/go")
//    public Question getRandom() {
//        return javaQuestionService.getRandomQuestion();
//    }
}
