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
    public List<Task> getTasks() {
        return tasks;
    }

    @PostMapping
    public Task addTask(@RequestBody Task task) {
        Task newTask = new Task(nextId++, task.getTitle(), task.getCompleted());
        tasks.add(newTask);
        return newTask;
    }
}