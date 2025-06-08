package org.skypro.controller;

import org.skypro.questions.Question;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.Collection;

import org.skypro.service.QuestionService;

@RestController
@RequestMapping("/exam/math")
public class MathQuestionController {

    private final QuestionService mathQuestionService;

    public MathQuestionController(QuestionService mathQuestionService) {
        this.mathQuestionService = mathQuestionService;
    }

    @GetMapping("/add")
    public Question addQuestion(@RequestParam String question, @RequestParam String answer) {
        return mathQuestionService.add(question, answer);
    }

    @GetMapping("/remove")
    public Question removeQuestion(@RequestParam String question, @RequestParam String answer) {
        return mathQuestionService.remove(question, answer);
    }

    @GetMapping
    public Collection<Question> getAll() {
        return mathQuestionService.getAll();
    }
}