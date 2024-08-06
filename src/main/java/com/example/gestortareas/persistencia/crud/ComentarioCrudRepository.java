package com.example.gestortareas.persistencia.crud;

import com.example.gestortareas.persistencia.entity.Comentario;
import org.springframework.data.repository.CrudRepository;

import java.util.List;

public interface ComentarioCrudRepository extends CrudRepository<Comentario,Integer> {


    List<Comentario> findByIdTarea(int tareaId);

     //void deleteByIdTarea(int tareaId);




}
