package com.example.gestortareas.persistencia.mapper;


import com.example.gestortareas.domain.Project;
import com.example.gestortareas.domain.Role;

import com.example.gestortareas.persistencia.entity.Rol;
import org.mapstruct.InheritInverseConfiguration;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.Mappings;

import java.util.Set;

@Mapper(componentModel = "spring")
public interface RoleMapper {
    @Mappings({
            @Mapping(source ="idRol" ,target = "idRole"),
            @Mapping(source ="nombreRol" ,target = "nameRole")

    })
    Role toRole(Rol rol);

    @InheritInverseConfiguration
    Set<Rol> toRoles(Set<Role> roles);
}
