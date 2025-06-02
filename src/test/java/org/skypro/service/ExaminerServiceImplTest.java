package org.skypro.service;

import org.junit.jupiter.api.*;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.*;
import org.mockito.junit.jupiter.MockitoExtension;
import org.skypro.questions.Question;
import org.springframework.web.server.ResponseStatusException;

import java.util.*;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.when;

@ExtendWith(MockitoExtension.class)
public class ExaminerServiceImplTest {

    @Mock
    private QuestionService questionService;

    @InjectMocks
    private ExaminerServiceImpl examinerService;

    @Test
    void correctQuestion() {
        Question q1 = new Question("23", "123");
        Question q2 = new Question("34", "234");
        Question q3 = new Question("45", "345");
        Set<Question> all = Set.of(q1, q2, q3);

        when(questionService.getAll()).thenReturn(all);
        when(questionService.getRandomQuestion())
                .thenReturn(q1)
                .thenReturn(q2)
                .thenReturn(q3);

        Collection<Question> result = examinerService.getQuestion(3);

        assertEquals(3, result.size());
        assertTrue(all.containsAll(result));
    }

    @Test
    void moreQuestion() {
        when(questionService.getAll()).thenReturn(Set.of(new Question("123", "1234")));

        ResponseStatusException exception = assertThrows(ResponseStatusException.class, () -> examinerService.getQuestion(2));

        assertEquals("Запрошено больше вопросов, чем есть.", exception.getReason());
    }
}
