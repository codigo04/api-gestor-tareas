package com.example.gestortareas.persistencia.mapper;

import com.example.gestortareas.domain.User;
import com.example.gestortareas.persistencia.entity.Usuario;
import org.mapstruct.*;

import java.util.List;


@Mapper(componentModel = "spring")
public interface UserMapper {
    @Mappings({
            @Mapping(source = "idUsuario",target = "userId"),
            @Mapping(source = "nombre",target = "name"),
            @Mapping(source = "apellido",target = "lastName"),
            @Mapping(source = "contraseña",target = "password"),
            @Mapping(source = "correo",target = "gmail"),
            @Mapping(source = "fechaRegistro",target = "dateRegustration"),


    })

    User toUser(Usuario usuario);
    List<User> toUsers(List<Usuario> usuarios);
    @InheritInverseConfiguration
    Usuario toUsuario(User user);


}
