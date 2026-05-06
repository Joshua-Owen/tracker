package com.xenii.tracker;

import org.springframework.web.bind.annotation.*;

import jakarta.validation.Valid;

import java.util.ArrayList;
import java.util.List;

@CrossOrigin(origins = "http://localhost:5173") //avoid CORS error as front and backends are on different ports
@RestController
@RequestMapping("/tasks")
public class TaskController 
{
    private final TaskRepository repository;

    public TaskController(TaskRepository repository)
    {
        this.repository = repository;
    }

  
 
    @GetMapping
    public List<Task> getTasks() 
    {
        //gets all tasks in the database
        return repository.findAll();
    }

    @PostMapping
    public Task addTask(@Valid @RequestBody Task task) 
    {
        // if the boolean object is null sets it false
        if (task.getCompleted() == null)
        {
            task.setCompleted(false);
        }
        //saves task in the database
        return repository.save(task);
    }

    @DeleteMapping("/{id}")
    public void deleteTask(@PathVariable Long id)
    {
        //removes if task id is found in the tasks list
        repository.deleteById(id);
    }

    @PutMapping("/{id}")
    public Task putMethodName(@PathVariable Long id, @RequestBody Task updatedTask) 
    {
        //gets the task in the database
        Task task = repository.findById(id).orElseThrow(() -> new RuntimeException("No task found with id: "+ id));
        
        //updates either the title or progress if a non null value is given
        if(updatedTask.getTitle() != null)
        {
            task.setTitle(updatedTask.getTitle());
        }
        if (updatedTask.getCompleted() != null)
        {
            task.setCompleted(updatedTask.getCompleted());
        }
        //saves the updated task to the database
        return repository.save(task);
    }
    
    
}