package org.skypro.service;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import org.skypro.questions.AllQuestionRepository;
import org.skypro.questions.Question;
import org.skypro.questions.QuestionRepository;

import java.util.*;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;


@ExtendWith(MockitoExtension.class)
public class JavaQuestionServiceTest {

    @Mock
    private AllQuestionRepository allQuestionRepository;

    @InjectMocks
    private JavaQuestionService service;

    @Test
    void addQuestions() {
        Question question = new Question("Что такое джава?", "язык программирования");

        when(allQuestionRepository.add(question)).thenReturn(question);
        when(allQuestionRepository.getAll()).thenReturn(Set.of(question));

        Question added = service.add("Что такое джава?", "язык программирования");

        assertTrue(service.getAll().contains(added));
        verify(allQuestionRepository).add(question);
        verify(allQuestionRepository).getAll();
    }

    @Test
    void removeQuestion() {
        Question question = service.add("Что такое джава?", "язык программирования");
        assertEquals(question, service.remove("Что такое джава?", "язык программирования"));
        assertFalse(service.getAll().contains(question));
    }

    @Test
    void nonExistQuestion() {
        Question question = new Question("какой-то несуществующий вопрос", "такой же ответ");

        when(allQuestionRepository.remove(question)).thenThrow(new NoSuchElementException("Вопрос не найден."));

        assertThrows(NoSuchElementException.class, () ->
                service.remove("какой-то несуществующий вопрос", "такой же ответ"));

        verify(allQuestionRepository).remove(question);
    }

    @Test
    void nonModifiableCollection() {
        Question question = new Question("то-то тут?", "то-то тамс.");
        when(allQuestionRepository.getAll()).thenReturn(Set.of(question));

        Collection<Question> all = service.getAll();

        assertThrows(UnsupportedOperationException.class, () -> all.clear());
    }

    @Test
    void returnRandomQuest() {
        Question question = new Question("то-то тут?", "то-то тамс.");

        when(allQuestionRepository.getAll()).thenReturn(Set.of(question));

        Question random = service.getRandomQuestion();

        assertEquals(question, random);
    }
}