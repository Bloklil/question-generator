package org.skypro.service;

import org.skypro.questions.*;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;

import java.util.*;

@Service
public class ExaminerServiceImpl implements ExaminerService {

    private final List<QuestionService> questionServices;
    private final Random random = new Random();

    public ExaminerServiceImpl(List<QuestionService> questionServices) {
        this.questionServices = questionServices;
    }

    @Override
    public Collection<Question> getQuestion(int amount) {
        if (amount <= 0) {
            throw new ResponseStatusException(HttpStatus.BAD_REQUEST, "Количество вопросов должно быть положительным.");
        }

        Set<Question> result = new HashSet<>();
        List<Question> availableQuestions = new ArrayList<>();
        for (QuestionService service : questionServices) {
            try {
                availableQuestions.addAll(service.getAll());
            } catch (UnsupportedOperationException ignored) {
            }
        }
        Collections.shuffle(availableQuestions);
        Iterator<Question> iterator = availableQuestions.iterator();
        while (result.size() < amount && iterator.hasNext()) {
            result.add(iterator.next());
        }
        while (result.size() < amount) {
            QuestionService service = questionServices.get(random.nextInt(questionServices.size()));
            try {
                result.add(service.getRandomQuestion());
            } catch (Exception ignored) {
            }
        }
        if (result.size() < amount) {
            throw new ResponseStatusException(HttpStatus.BAD_REQUEST, "Запрошено больше вопросов, чем есть.");

        }
        return result;

    }
}
