package com.app;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;

@Entity
public class Todo {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY) // automatic id-generation
    private Long id;
    private String title;
    private boolean completed;

    // Constructor
    public Todo(){}

    // Constructor with 2 Parameters
    public Todo(String title, boolean completed){
        this.title = title;
        this.completed = completed;
    }

    // Constructor with 3 Parameters
    public Todo(Long id, String title, boolean completed) {
        this.id = id;
        this.title = title;
        this.completed = completed;
    }

    // Getter and Setter
    public Long getId(){ return id; }

    public void setId(Long id){ this.id = id; }

    public String getTitle(){ return title; }

    public void setTitle(String title){ this.title = title; }

    public boolean isCompleted(){ return completed; }
    public void setCompleted(boolean completed){ this.completed = completed; }
}
