package org.skypro.service;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.skypro.questions.Question;

import java.util.Collection;
import java.util.NoSuchElementException;

import static org.junit.jupiter.api.Assertions.*;

public class JavaQuestionServiceTest {
    private JavaQuestionService service;

    @BeforeEach
    void setup() {
        service = new JavaQuestionService();
    }

    @Test
    void addQuestions() {
        Question question = service.add("Что такое джава?", "язык программирования");
        assertTrue(service.getAll().contains(question));
    }

    @Test
    void removeQuestion() {
        Question question = service.add("Что такое джава?", "язык программирования");
        assertEquals(question, service.remove("Что такое джава?", "язык программирования"));
        assertFalse(service.getAll().contains(question));
    }

    @Test
    void nonExistQuestion() {
        assertThrows(NoSuchElementException.class, () ->
                service.remove("какой-то несуществующий вопрос", "такой же ответ"));
    }

    @Test
    void nonModifiableCollection() {
        Collection<Question> all = service.getAll();
        assertThrows(UnsupportedOperationException.class, () -> all.clear());
    }

    @Test
    void returnRandomQuest() {
        Question random = service.getRandomQuestion();
        assertTrue(service.getAll().contains(random));
    }
}
