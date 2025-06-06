package org.skypro.controller;

import org.skypro.questions.AllQuestionRepository;
import org.skypro.questions.Question;
import org.springframework.web.bind.annotation.*;

import java.util.Collection;

@RestController
@RequestMapping("/exam/java")
public class JavaQuestionController {

    private final AllQuestionRepository questionRepository;

    public JavaQuestionController(AllQuestionRepository questionRepository) {
        this.questionRepository = questionRepository;
    }

    @GetMapping("/add")
    public Question add(@RequestParam String question, @RequestParam String answer) {
        return questionRepository.add(new Question(question, answer));
    }

    @GetMapping("/remove")
    public Question remove(@RequestParam String question, @RequestParam String answer) {
        return questionRepository.remove(new Question(question, answer));
    }

    @GetMapping
    public Collection<Question> getAll() {
        return questionRepository.getAll();
    }
}