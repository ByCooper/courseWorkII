package ru.ByCooper.generatorExamQuestion.controller;

import org.springframework.web.bind.annotation.*;
import ru.ByCooper.generatorExamQuestion.data.Question;
import ru.ByCooper.generatorExamQuestion.service.ExaminerServiceImpl;

import java.util.Collection;

@RestController
@RequestMapping(path = "/exam/get")
public class ExamController {

    private final ExaminerServiceImpl examinerService;

    public ExamController(ExaminerServiceImpl examinerService) {
        this.examinerService = examinerService;
    }

    @GetMapping(path = "{amount}")
    public Collection<Question> getQuestion(@PathVariable int amount) {
        return examinerService.getQuestions(amount);
    }
}
