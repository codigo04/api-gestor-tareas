package com.example.gestortareas.persistencia.repositorio;

import com.example.gestortareas.domain.Role;
import com.example.gestortareas.domain.repository.RoleRepository;
import com.example.gestortareas.persistencia.crud.RolCrudRepository;
import com.example.gestortareas.persistencia.entity.Rol;
import com.example.gestortareas.persistencia.mapper.RoleMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public class RolRepository implements RoleRepository {

    @Autowired
    RolCrudRepository rolCrudRepository;
    @Autowired
    RoleMapper mapper;


    /**
     * @param rol
     * @return
     */
    @Override
    public Optional<Role> findByNombreRol(String rol) {

        Optional<Rol> optionalRol =  rolCrudRepository.findByNombreRol(rol);
        return optionalRol.map(mapRol ->  mapper.toRole(mapRol));
    }
}
