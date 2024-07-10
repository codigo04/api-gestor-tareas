package com.example.gestortareas.persistencia.crud;

import com.example.gestortareas.persistencia.entity.Tarea;
import org.springframework.data.repository.CrudRepository;

import java.util.List;
import java.util.Optional;

public interface TareaCrudRespository extends CrudRepository<Tarea, Integer> {
    //buscar por nombre
     Optional<Tarea> findByTitulo(String nombre);

    //buscar por estado
     List<Tarea> findAllByEstado(String estado);


    //buscar tareas de un usuario
     Optional<List<Tarea>> findAllByIdUsuario(int idUsuario);

}
