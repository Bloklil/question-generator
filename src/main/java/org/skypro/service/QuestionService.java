package org.skypro.service;

import org.skypro.questions.Question;

import java.util.Collection;

public interface QuestionService {

    Question add(String question, String answer);

    Question remove(String question, String answer);

    Collection<Question> getAll();

    Question getRandomQuestion();
}