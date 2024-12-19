package com.appTest;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.times;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

import java.util.Optional;

import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.springframework.boot.test.context.SpringBootTest;

import com.app.Todo;
import com.app.TodoRepository;
import com.app.TodoService;

@SpringBootTest
class TodoServiceTest {

    @Mock
    private TodoRepository todoRepository;

    @InjectMocks
    private TodoService todoService;

    @Test
    void testCreateTodo() {
        Todo todo = new Todo();
        todo.setTitle("Test-Todo");
        todo.setCompleted(false);

        when(todoRepository.save(any(Todo.class))).thenReturn(todo);

        Todo createdTodo = todoService.createTodo(todo);

        assertNotNull(createdTodo);
        assertEquals("Test-Todo", createdTodo.getTitle());
        assertFalse(createdTodo.isCompleted());
    }

    @Test
    void testUpdateTodo(){
        Todo existingTodo = new Todo();
        existingTodo.setId(1L);
        existingTodo.setTitle("Test-Todo2");
        existingTodo.setCompleted(true);

        when(todoRepository.findById(1L)).thenReturn(Optional.of(existingTodo));

        Todo updatedTodo = new Todo();
        updatedTodo.setTitle("Test-Todo3");
        updatedTodo.setCompleted(true);
        when(todoRepository.save(any(Todo.class))).thenReturn(updatedTodo);
 
        existingTodo = todoService.updateTodo(1L, updatedTodo);

        assertNotNull(existingTodo);
        assertEquals(existingTodo.getId(), updatedTodo.getId());
        assertEquals(existingTodo.getTitle(), updatedTodo.getTitle());
        assertEquals(existingTodo.isCompleted(), updatedTodo.isCompleted());
    }

    @Test
    void testDeleteTodo() {
        Todo todoToDelete = new Todo();
        todoToDelete.setId(42L);
        todoToDelete.setTitle("Test-Todo-zum-Deleten");
        todoToDelete.setCompleted(false);

        when(todoRepository.save(any(Todo.class))).thenReturn(todoToDelete);

        todoService.deleteTodoById(todoToDelete.getId());

        verify(todoRepository, times(1)).deleteById(42L);

        when(todoRepository.findById(42L)).thenReturn(Optional.empty());
        Optional<Todo> deletedTodo = todoRepository.findById(42L);
        assertTrue(deletedTodo.isEmpty());    
    }
}
