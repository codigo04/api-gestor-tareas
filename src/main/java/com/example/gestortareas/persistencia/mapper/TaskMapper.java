package com.example.gestortareas.persistencia.mapper;


import com.example.gestortareas.domain.Task;
import com.example.gestortareas.persistencia.entity.Tarea;
import org.mapstruct.InheritInverseConfiguration;
import org.mapstruct.Mapping;
import org.mapstruct.Mappings;

import java.util.List;

public interface TaskMapper {
    @Mappings({
            @Mapping(source = "idTarea", target ="taskId" ),
            @Mapping(source = "titulo", target = "title"),
            @Mapping(source = "descripcion", target = "description"),
            @Mapping(source = "fechaCreacion", target = "dateCreation"),
            @Mapping(source = "fechaVencimiento", target = "dateExperition"),
            @Mapping(source = "prioridad", target ="priority" ),
            @Mapping(source = "estado", target = "pediente")

    })
    Task toTask(Tarea tarea);

    List<Task> toTasks(List<Tarea> tareas);

    @InheritInverseConfiguration
    Tarea TOTarea(Task task);


}
