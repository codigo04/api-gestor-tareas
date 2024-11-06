package com.example.gestortareas.domain.repository;

import com.example.gestortareas.domain.Role;


import java.util.Optional;

public interface RoleRepository {
    Optional<Role> findByNombreRol(String rol);
}
