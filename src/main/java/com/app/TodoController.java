package com.app;

import java.util.List;

import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/todos")
public class TodoController {

    private final TodoService todoService;

    public TodoController(TodoService todoService){
        this.todoService = todoService;
    }

    @GetMapping
    public List<Todo>getAllTodos(){ return todoService.getAllTodos(); }

    @GetMapping("/{id}")
    public Todo getTodoById(@PathVariable Long id){
        return todoService.getTodoById(id)
                .orElseThrow(() -> new RuntimeException("To-Do not found!"));
    }

    @PostMapping
    public Todo createTodo(@RequestBody Todo todo){ return todoService.createTodo(todo); }

    @PutMapping("/{id}")//Teilaktualisierung @PutMapping für eine komplette Aktualisierung
    public Todo updateTodo(@PathVariable Long id, @RequestBody Todo todo){ 
        return todoService.updateTodo(id, todo);
    }


    @DeleteMapping("/{id}")
    public void deleteTodoById(@PathVariable Long id){
        todoService.deleteTodoById(id);
    }

}
