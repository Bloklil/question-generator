package org.skypro.questions;

import org.junit.jupiter.api.*;

import java.util.Collection;

import static org.junit.jupiter.api.Assertions.*;

public class AllQuestionRepositoryTest {

    private AllQuestionRepository repository;

    @BeforeEach
    void setUp() {
        repository = new AllQuestionRepository();
    }

    @Test
    void addQuest() {
        Question question = new Question("2+2", "4");

        Question question1 = repository.add(question);

        assertTrue(repository.getAll().contains(question1));
    }

    @Test
    void removeQuest() {
        Question question = new Question("2+2", "4");
        repository.add(question);
        Question remove = repository.remove(question);
        assertEquals(question, remove);
        assertFalse(repository.getAll().contains(question));
    }

    @Test
    void returnAllQuestions() {
        Question q1 = new Question("2+2", "4");
        Question q2 = new Question("1+1", "2");

        repository.add(q1);
        repository.add(q2);

        Collection<Question> all = repository.getAll();

        assertEquals(20, all.size());
        assertTrue(all.contains(q1));
        assertTrue(all.contains(q2));
    }
}
