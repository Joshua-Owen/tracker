package com.xenii.tracker;

import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;


@RestController
@RequestMapping("/tasks")
public class TaskController {

    private List<Task> tasks = new ArrayList<>();
    private Long nextId = 1L;
  
 
    @GetMapping
    public List<Task> getTasks() 
    {
        return tasks;
    }

    @PostMapping
    public Task addTask(@RequestBody Task task) 
    {
        Boolean completed = task.getCompleted() != null ? task.getCompleted() : false;
        
        Task newTask = new Task(nextId++, task.getTitle(), completed);
        tasks.add(newTask);
        return newTask;
    }

    @DeleteMapping("/{id}")
    public String deleteTask(@PathVariable Long id)
    {
        tasks.removeIf((task) -> task.getId().equals(id));
        return "Task deleted";
    }

    @PutMapping("/{id}")
    public Task putMethodName(@PathVariable Long id, @RequestBody Task updatedTask) 
    {
        
        for (Task task : tasks)
        {
            if (task.getId().equals(id))
            {
                Boolean completed = updatedTask.getCompleted() != null ? updatedTask.getCompleted() : false;

                task.setTitle(updatedTask.getTitle() != null ? updatedTask.getTitle() : task.getTitle());
                task.setCompleted(completed);
                return task;
            }
        }
        throw new RuntimeException("Task not found");
    }
    
    
}