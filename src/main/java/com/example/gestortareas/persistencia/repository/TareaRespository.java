package com.example.gestortareas.persistencia.repository;

import com.example.gestortareas.domain.Task;
import com.example.gestortareas.domain.repository.TaskRespository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;
@Repository
public class TareaRespository implements TaskRespository {



    @Override
    public Task createTask(Task task) {
        return null;
    }

    @Override
    public List<Task> getTasks() {
        return List.of();
    }

    @Override
    public Optional<Task> getTask(int taskId) {
        return Optional.empty();
    }

    @Override
    public Task updateTask(Task task) {
        return null;
    }

    @Override
    public void deleteTask(int taskId) {

    }
}
