package com.example.gestortareas.web.controller;


import com.example.gestortareas.domain.Project;
import com.example.gestortareas.domain.Task;
import com.example.gestortareas.domain.service.TaskService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/task")
public class TaskController {
    @Autowired
    TaskService taskService;

    @PostMapping("/v1/task/create")
    public Task createProject(@RequestBody Task task) {

        return taskService.createTask(task);
    }


}
