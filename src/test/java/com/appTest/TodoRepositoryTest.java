package com.appTest;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;

import com.app.Todo;
import com.app.TodoRepository;

@DataJpaTest
class TodoRepositoryTest {

    @Autowired
    private TodoRepository todoRepository;

    @Test
    void testSaveTodo() {
        Todo todo = new Todo();
        todo.setTitle("Test-Todo");
        todo.setCompleted(false);

        Todo savedTodo = todoRepository.save(todo);

        assertNotNull(savedTodo.getId());
        assertEquals("Test-Todo", savedTodo.getTitle());
    }
}
