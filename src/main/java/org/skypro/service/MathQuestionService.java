package org.skypro.service;

import org.skypro.questions.Question;
import org.springframework.stereotype.Service;

import java.util.*;

@Service
public class MathQuestionService implements QuestionService {

    private final Random random = new Random();

    @Override
    public Question add(String question, String answer) {
        throw new UnsupportedOperationException("Добавление вопросов не поддерживается.");
    }

    @Override
    public Question remove(String question, String answer) {
        throw new UnsupportedOperationException("Удаление вопросов не поддерживается.");
    }

    @Override
    public Collection<Question> getAll() {
        throw new UnsupportedOperationException("Получение вопросов не поддерживается.");
    }

    @Override
    public Question getRandomQuestion() {
        int a = random.nextInt(5);
        int b = random.nextInt(4);
        String question = a + "*" + b + "+" + a + "=?";
        String answer = String.valueOf(a * b + a);
        return new Question(question, answer);
    }
}
