package org.skypro.questions;

import org.springframework.stereotype.Repository;

import java.util.*;

@Repository
public class AllQuestionRepository implements QuestionRepository {

    private Set<Question> questions = new HashSet<>();

    public AllQuestionRepository() {
        questionInfo();
    }

    public void questionInfo() {
        questions.add(new Question("Логический тип переменных (boolean)", "Тип, в котором хранится информация в формате true/false (т. е. «истина/ложь»)."));
        questions.add(new Question("Модификаторы доступа это?", "Это ключевые слова, которые определяют уровень доступа к классам, переменным и методам."));
    }

    @Override
    public Question add(Question question) {
        questions.add(question);
        return question;
    }

    @Override
    public Question remove(Question question) {
        if (questions.remove(question)) {
            return question;
        }
        throw new NoSuchElementException("Вопрос не найден.");
    }

    @Override
    public Collection<Question> getAll() {
        return Collections.unmodifiableSet(questions);
    }
}
