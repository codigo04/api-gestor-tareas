package com.example.gestortareas.persistencia.crud;

import com.example.gestortareas.persistencia.entity.Rol;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface RolCrudRepository extends JpaRepository<Rol,Long> {
    Optional<Rol> findByNombreRol(String rol);
}
