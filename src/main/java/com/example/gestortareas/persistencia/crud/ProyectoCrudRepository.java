package com.example.gestortareas.persistencia.crud;

import com.example.gestortareas.persistencia.entity.Proyecto;
import org.springframework.data.repository.CrudRepository;

import java.util.List;
import java.util.Optional;

public interface ProyectoCrudRepository extends CrudRepository<Proyecto,Integer> {


     //apache kafla

    //buscar por nombre
    public Optional<Proyecto> findByNombre(String nombre);

    //buscar por estado
    public List<Proyecto> findAllByEstado(int estado);

    //buscar tareas de un usuario
    public Optional<List<Proyecto>> findAllByIdUsuario(int idUsuario);
}
