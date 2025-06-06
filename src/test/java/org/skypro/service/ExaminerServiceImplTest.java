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
    private JavaQuestionService javaQuestionService;

    @InjectMocks
    private ExaminerServiceImpl examinerService;

    @BeforeEach
    void setUp() {
        examinerService = new ExaminerServiceImpl(List.of(javaQuestionService));
    }

    @Test
    void correctQuestion() {
        Question q1 = new Question("23", "123");
        Set<Question> all = Set.of(q1);

        when(javaQuestionService.getAll()).thenReturn(all);

        Collection<Question> result = examinerService.getQuestion(1);

        assertEquals(1, result.size());
        assertTrue(all.containsAll(result));
    }

    @Test
    void moreQuestion() {
        when(javaQuestionService.getAll()).thenReturn(Set.of(new Question("123", "1234")));

        ResponseStatusException exception = assertThrows(ResponseStatusException.class, () -> examinerService.getQuestion(2));

        assertEquals("Запрошено больше вопросов, чем есть.", exception.getReason());
    }
}
