package com.example.gestortareas.persistencia.repository;

import com.example.gestortareas.persistencia.crud.UsuarioCrudRepository;
import com.example.gestortareas.persistencia.entity.Usuario;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;


@Repository
public class UsuarioRepository  {

    @Autowired
    private UsuarioCrudRepository usuarioCrudRepository;

    public  void buscar(Usuario usuario){

        usuarioCrudRepository.save(usuario);
    }
}
