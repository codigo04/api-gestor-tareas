package com.example.gestortareas.persistencia.repositorio;

import com.example.gestortareas.domain.Comment;
import com.example.gestortareas.domain.repository.CommentRepository;
import com.example.gestortareas.persistencia.crud.ComentarioCrudRepository;
import com.example.gestortareas.persistencia.crud.TareaCrudRespository;
import com.example.gestortareas.persistencia.entity.Comentario;
import com.example.gestortareas.persistencia.entity.Proyecto;
import com.example.gestortareas.persistencia.mapper.CommentMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public class ComentarioRespository implements CommentRepository {
      @Autowired
     private ComentarioCrudRepository  comentarioCrudRepository;
      @Autowired
      private CommentMapper mapper;
    /**
     * @param comment
     * @return  Optional<Comment>
     */
    @Override
    public Optional<Comment> createCommentTask(Comment comment) {
        //Comentario proyecto = mapper.toComentario(comment);

        Comentario comentario = comentarioCrudRepository.save(mapper.toComentario(comment));

        return Optional.of(mapper.toComment(comentario)) ;
    }

    /**
     * @return List<Comment>
     */
    @Override
    public List<Comment> readCommentsTask(int taskId) {
       List<Comment>comentarios =  mapper.toComments(comentarioCrudRepository.findAllByIdTarea(taskId));
        return comentarios;
    }

    /**
     *
     */
    @Override
    public void deleteCommentsTask(int taskId) {
         comentarioCrudRepository.deleteById(taskId);
    }

    /**
     * @return Comment
     */
    @Override
    public Comment updateCommentTask(Comment comment) {
         Comentario comentario =  comentarioCrudRepository.save(mapper.toComentario(comment));


        return mapper.toComment(comentario);
    }
}
