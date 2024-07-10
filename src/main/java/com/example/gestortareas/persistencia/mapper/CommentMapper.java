package com.example.gestortareas.persistencia.mapper;


import com.example.gestortareas.domain.Comment;
import com.example.gestortareas.persistencia.entity.Comentario;
import org.mapstruct.InheritInverseConfiguration;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.Mappings;

import java.util.List;

@Mapper(componentModel = "spring")
public interface CommentMapper {

    @Mappings({
            @Mapping(source = "idComentario" ,target = "commentId"),
            @Mapping(source = "comentario" ,target = "comment"),
            @Mapping(source = "fechaComentario" ,target = "dateComment"),
            @Mapping(source = "idTarea" ,target = "taskId")

    })

    Comment toComment(Comentario comentario);
    List<Comment> toComments(List<Comentario> comentarios);

    @InheritInverseConfiguration
    Comentario toComentario(Comment comment);
}
