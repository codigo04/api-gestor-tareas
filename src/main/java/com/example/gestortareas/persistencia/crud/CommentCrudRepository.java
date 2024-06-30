package com.example.gestortareas.persistencia.crud;

import com.example.gestortareas.persistencia.entity.Comentario;
import org.springframework.data.repository.CrudRepository;

public interface CommentCrudRepository extends CrudRepository<Comentario,Integer> {

}
