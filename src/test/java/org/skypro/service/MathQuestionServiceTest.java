/*package org.skypro.service;

import org.junit.jupiter.api.Test;
import org.skypro.questions.Question;

import java.util.*;

import static org.junit.jupiter.api.Assertions.*;

public class MathQuestionServiceTest {
        private final MathQuestionService service = new MathQuestionService();

        @Test
        void addQuestions() {
            Question question = service.add("2+2", "4");
            assertTrue(service.getAll().contains(question));
        }

        @Test
        void removeQuestion() {
            Question question = service.add("2+2", "4");
            assertEquals(question, service.remove("2+2", "4"));
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
            assertThrows(UnsupportedOperationException.class, all::clear);
        }

        @Test
        void returnRandomQuest() {
            service.add("2+2", "4");
            Question random = service.getRandomQuestion();
            assertTrue(service.getAll().contains(random));
        }
}*/
