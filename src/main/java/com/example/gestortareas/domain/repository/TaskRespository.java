package com.example.gestortareas.domain.repository;

import com.example.gestortareas.domain.Task;
import com.example.gestortareas.persistencia.entity.Tarea;

import java.util.List;
import java.util.Optional;

public interface TaskRespository {

    /*
    new TimesTamp(System.currentTimeMilles())
    Crear
    Leer
    Actualizar
    Eliminar
    Priorizar
    Asignar tareas a diferentes usuarios o proyectos
    */

    //crear tarea
    Task createTask(Task task);
     //buscar Tareas
    List<Task> getTasks ();


    //buscar tarea
    Optional<Task> getTask(int taskId);

    //buscar Tarea por id usuario
    Optional<List<Task>> getTaskIdUsuario(int idUser);

    //actualizar
    Task updateTask(Task task);

    //eliminar
    void deleteTask(int taskId);






}
