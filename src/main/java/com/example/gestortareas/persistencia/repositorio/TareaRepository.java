package com.example.gestortareas.persistencia.repositorio;

import com.example.gestortareas.domain.Task;
import com.example.gestortareas.domain.repository.TaskRespository;
import com.example.gestortareas.persistencia.crud.TareaCrudRespository;
import com.example.gestortareas.persistencia.entity.Tarea;
import com.example.gestortareas.persistencia.mapper.TaskMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public class TareaRepository implements TaskRespository {

    @Autowired
    private TaskMapper taskMapper;
    @Autowired
    private TareaCrudRespository tareaCrudRespository;

    @Override
    public Task createTask(Task task) {
        Tarea tarea = taskMapper.toTarea(task);

        return taskMapper.toTask(tareaCrudRespository.save(tarea));
    }

    @Override
    public List<Task> getTasks() {

        List<Tarea> tareas = (List<Tarea>) tareaCrudRespository.findAll();

        return taskMapper.toTasks(tareas);
    }

    @Override
    public Optional<Task> getTask(int taskId) {

        Optional<Tarea> tarea = tareaCrudRespository.findById(taskId);

        return tarea.map(tareaMap -> taskMapper.toTask(tareaMap));
    }

    @Override
    public Optional<List<Task>> getTaskIdUsuario(int idUser) {
        Optional<List<Tarea>> tareas =tareaCrudRespository.findAllByIdUsuario(idUser);

        return tareas.map(tareaMap -> taskMapper.toTasks(tareaMap));
    }


    @Override
    public Task updateTask(Task task) {

        Tarea tarea = taskMapper.toTarea(task);

        return taskMapper.toTask(tareaCrudRespository.save(tarea));
    }

    @Override
    public void deleteTask(int taskId) {

        tareaCrudRespository.deleteById(taskId);
    }
}
