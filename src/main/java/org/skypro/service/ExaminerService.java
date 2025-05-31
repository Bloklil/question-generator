package org.skypro.service;

import org.skypro.questions.Question;

import java.util.Collection;

public interface ExaminerService {
    Collection<Question> getQuestion(int amount);
}
