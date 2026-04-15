package com.xenii.tracker;

import java.lang.annotation.Native;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;

@Entity
public class Task {
    
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    
    @NotBlank(message = "A Title is required")
    @NotNull(message = "A Title is required")
    private String title;

    private Boolean completed;

    public Task() {}

    public Task(Long id, String title, Boolean completed) 
    {
        this.id = id;
        this.title = title;
        this.completed = completed;
    }

    public Long getId() 
    {
        return id;
    }

    public void setId(Long id) 
    {
        this.id = id;
    }

    public String getTitle() 
    {
        return title;
    }

    public void setTitle(String title) 
    {
        this.title = title;
    }

    public Boolean getCompleted() 
    {
        return completed;
    }

    public void setCompleted(Boolean completed) 
    {
        this.completed = completed;
    }
}