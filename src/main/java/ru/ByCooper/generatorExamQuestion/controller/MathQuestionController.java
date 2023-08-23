package ru.ByCooper.generatorExamQuestion.controller;

import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import ru.ByCooper.generatorExamQuestion.data.Question;
import ru.ByCooper.generatorExamQuestion.service.QuestionService;

import java.util.Collection;

@RestController
@RequestMapping("/exam/math")
public class MathQuestionController {

    @ExceptionHandler(RuntimeException.class)
    public ResponseEntity<String> handleException(RuntimeException e) {
        return new ResponseEntity<> (e.getMessage(), HttpStatus.METHOD_NOT_ALLOWED);
    }

    private final QuestionService questionService;

    public MathQuestionController(@Qualifier("mathQuestionService") QuestionService questionService) {
        this.questionService = questionService;
    }

    @GetMapping("/add")
    public Question getAdd(@RequestParam("question") String question, @RequestParam("answer") String answer) {
        return questionService.add(new Question(question, answer));
    }
    @GetMapping("/remove")
    public Question getRemove(@RequestParam("question") String question, @RequestParam("answer") String answer) {
        return questionService.remove(new Question(question, answer));
    }
    @GetMapping()
    public Collection<Question> getAll() {
        return questionService.getAll();
    }
}
