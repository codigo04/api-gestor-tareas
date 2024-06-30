package com.example.gestortareas.persistencia.crud;

import com.example.gestortareas.persistencia.entity.Proyecto;
import com.example.gestortareas.persistencia.entity.Tarea;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;
import java.util.Optional;

public interface TareaCrudRespository extends JpaRepository<Tarea, Integer> {
    /*buscar por nombre
    public Optional<Proyecto> findByNombre(String nombre);

    //buscar por estado
    public List<Proyecto> findAllByEstado(int estado);

    //buscar tareas de un usuario
    public Optional<List<Proyecto>> findAllByIdUsuario(int idUsuario);

     */
}
