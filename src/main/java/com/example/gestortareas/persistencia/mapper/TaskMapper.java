package com.example.gestortareas.persistencia.mapper;


import com.example.gestortareas.domain.Task;
import com.example.gestortareas.persistencia.entity.Tarea;
import org.mapstruct.InheritInverseConfiguration;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.Mappings;
import org.springframework.stereotype.Component;

import java.util.List;

@Mapper(componentModel = "spring")
public interface TaskMapper {
    @Mappings({
            @Mapping(source = "idTarea", target ="taskId" ),
            @Mapping(source = "titulo", target = "title"),
            @Mapping(source = "descripcion", target = "description"),
            @Mapping(source = "fechaCreacion", target = "dateCreation"),
            @Mapping(source = "fechaVencimiento", target = "dateExperition"),
            @Mapping(source = "prioridad", target ="priority" ),
            @Mapping(source = "estado", target = "estate"),
            @Mapping(source = "idProyecto", target ="projectId" ),
            @Mapping(source = "idUsuario", target ="userId" ),


    })
    Task toTask(Tarea tarea);

    List<Task> toTasks(List<Tarea> tareas);

    @InheritInverseConfiguration
    Tarea toTarea(Task task);


}
