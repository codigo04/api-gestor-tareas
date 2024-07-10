package com.example.gestortareas.domain.service;

import com.example.gestortareas.domain.Task;
import com.example.gestortareas.domain.repository.TaskRespository;
import jakarta.persistence.EntityNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class TaskService {


    @Autowired
    TaskRespository tareaRepository;


    //crear tarea
    public Task createTask(Task task) {


        return tareaRepository.createTask(task);
    }

    //buscar tareas

    public List<Task> getTasks() {
        List<Task> tasks = tareaRepository.getTasks();

        return tasks;
    }

    //buscar tarea
    public Optional<Task> getTask(int idTask) {
        return tareaRepository.getTask(idTask);
    }

    //busar tareas de  usuario
    public Optional<List<Task>> getTaskUser(int idUser) {


        return tareaRepository.getTaskIdUsuario(idUser);
    }

    //Actualizar tarea
    public Task updateTask(int taskId, Task task) {
        Optional<Task> taskExist = getTask(taskId);

        if (taskExist.isPresent()) {
            Task tareaExistente = taskExist.get();
            tareaExistente.setTitle(task.getTitle());
            tareaExistente.setDescription(task.getDescription());
            tareaExistente.setPriority(task.getPriority());
            tareaExistente.setDateExperition(task.getDateExperition());
            return tareaExistente;
        }else{
            throw new EntityNotFoundException("Usuario con ID " + taskId + " no encontrado");
        }

    }

    //borrar tarea
    public void deleteTask(int taskId) {
        Optional<Task> taskExist = getTask(taskId);
        if (taskExist.isPresent()) {
            tareaRepository.deleteTask(taskId);
        }
    }

}
