package org.skypro.service;

import org.skypro.questions.Question;
import org.skypro.questions.QuestionRepository;
import org.springframework.stereotype.Service;

import java.util.*;

@Service
public class JavaQuestionService implements QuestionService {

    private final QuestionRepository questionRepository;
    private final Random random = new Random();

    public JavaQuestionService(QuestionRepository questionRepository) {
        this.questionRepository = questionRepository;
    }

    @Override
    public Question add(String question, String answer) {
        Question q = new Question(question, answer);
        return questionRepository.add(q);
    }

    @Override
    public Question remove(String question, String answer) {
        Question q = new Question(question, answer);
        return questionRepository.remove(q);
    }

    @Override
    public Collection<Question> getAll() {
        return questionRepository.getAll();
    }

    @Override
    public Question getRandomQuestion() {
        Collection<Question> questions = questionRepository.getAll();
        if (questions.isEmpty()) {
            throw new IllegalStateException("Вопросы отсутствуют");
        }
        List<Question> list = List.copyOf(questions);
        return list.get(random.nextInt(list.size()));
    }
}
