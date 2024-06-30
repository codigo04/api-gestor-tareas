package com.example.gestortareas.persistencia.mapper;


import com.example.gestortareas.domain.Project;
import com.example.gestortareas.persistencia.entity.Proyecto;
import org.mapstruct.InheritInverseConfiguration;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.Mappings;

import java.util.List;

@Mapper(componentModel = "spring")
public interface ProjectMapper {

    @Mappings({
            @Mapping(source ="idProyecto" ,target = "projectId"),
            @Mapping(source ="nombre" ,target = "name"),
            @Mapping(source ="descripcion" ,target = "description"),
            @Mapping(source ="fechaInicio" ,target = "startDate"),
            @Mapping(source ="fechaFin" ,target = "endDate"),
            @Mapping(source ="estado" ,target = "estate"),
            @Mapping(source ="idUsuario" ,target = "userId")
    })
    Project toProject(Proyecto proyecto);

    List<Project> toProjects(List<Proyecto> proyectos);

    @InheritInverseConfiguration
    Proyecto toProyecto(Project project);
}
