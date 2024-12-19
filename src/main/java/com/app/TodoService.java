package com.app;

import java.util.List;
import java.util.Optional;

import org.springframework.stereotype.Service;

@Service
public class TodoService {

    private final TodoRepository todoRepository;

    public TodoService(TodoRepository todoRepository){
        this.todoRepository = todoRepository;
    }

    public List<Todo> getAllTodos(){ return todoRepository.findAll(); }

    public Optional<Todo> getTodoById(Long id){ return todoRepository.findById(id); }

    public Todo createTodo(Todo todo){ return todoRepository.save(todo); }

    public Todo updateTodo(Long id, Todo updatedTodo){
        return todoRepository.findById(id)
                .map(todo -> {
                    todo.setTitle(updatedTodo.getTitle());
                    todo.setCompleted(updatedTodo.isCompleted());
                    return todoRepository.save(todo);
                })
                .orElseThrow(() -> new RuntimeException("To-Do not found!"));
    }

    public void deleteTodoById(Long id){ todoRepository.deleteById(id); }
}
