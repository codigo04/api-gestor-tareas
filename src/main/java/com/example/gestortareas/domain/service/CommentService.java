package com.example.gestortareas.domain.service;

import com.example.gestortareas.domain.Comment;
import com.example.gestortareas.domain.constants.AppMessage;
import com.example.gestortareas.domain.repository.CommentRepository;
import com.example.gestortareas.domain.repository.TaskRespository;
import com.example.gestortareas.domain.response.CreateCommentResponse;
import com.example.gestortareas.domain.response.ResponseBase;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.List;
import java.util.Optional;

@Service
public class CommentService {
    @Autowired
    private CommentRepository commentRepository;

    @Autowired
    private TaskRespository taskRespository;

    //metodos que llevaran logica de negocio

    //crear comentario a una tarea
    public ResponseBase<Comment> createCommentTask(Comment comment) {
        try {
            Optional<Comment> comment1 = commentRepository.createCommentTask(comment);
            if (comment1.isPresent()) {
                return new CreateCommentResponse(AppMessage.CODIGO_EXITO, AppMessage.MENSAJE_EXITO, comment1.get());
            } else {
                return new CreateCommentResponse(AppMessage.CODIGO_ERROR, AppMessage.INVALID_REQUEST, comment1.get());
            }
        } catch (Exception e) {
            return new ResponseBase<Comment>(AppMessage.CODIGO_ERROR, AppMessage.INVALID_REQUEST, null);
        }

    }

    //mostrar todos los comentarios de una tarea -> funcionando
    public ResponseBase<List<Comment>> getCommentTask(int taskId) {

        List<Comment> commentsTask = commentRepository.readCommentsTask(taskId);



        if (!commentsTask.isEmpty()) {

            return new ResponseBase<List<Comment>>(AppMessage.CODIGO_EXITO, AppMessage.SUSCCES_REQUEST, commentsTask);

        }else{
            return new ResponseBase<>(AppMessage.CODIGO_ERROR, AppMessage.COMMENT_NOT_FOUND, List.of());
        }



    }

    //buscar un comentario por su id -> funcionando
    public ResponseBase<Optional<Comment>> getComment(int commentId) {

        Optional<Comment> comment = commentRepository.readComment(commentId);

        if (comment.isPresent()) {
            return new ResponseBase<>(AppMessage.CODIGO_EXITO, AppMessage.SUSCCES_REQUEST, comment);
        } else {
            return new ResponseBase<>(AppMessage.CODIGO_ERROR, AppMessage.COMMENT_NOT_FOUND, Optional.empty());
        }

    }


    //borrar un comentario -> funcionando
    public ResponseBase<Boolean> deleteCommentDeTask(int commentId) {
        Optional<Comment> comments = commentRepository.readComment(commentId);

        if (comments.isPresent()) {
            commentRepository.deleteCommentsTask(commentId);
            return new ResponseBase<>(AppMessage.CODIGO_EXITO, AppMessage.SUSCCES_REQUEST, true);
        } else {
            return new ResponseBase<>(AppMessage.CODIGO_ERROR, AppMessage.INVALID_REQUEST, false);
        }

    }

    //actualizar un comentario  -> funcionando 

    public ResponseBase<Optional<Comment>> updateCommentTask(int commentId,Comment comment) {
        Optional<Comment> comentExist = commentRepository.readComment(commentId);

        //commentId
        // comment
        // dateComment
        // taskId

        if (comentExist.isPresent()) {
            Comment commentModif = comentExist.get();
            commentModif.setComment(comment.getComment());
            commentRepository.updateCommentTask(commentModif);
            return new ResponseBase<>(AppMessage.CODIGO_EXITO, AppMessage.MENSAJE_EXITO, Optional.of(commentModif));
        } else {
            return new ResponseBase<>(AppMessage.CODIGO_ERROR, AppMessage.MENSAJE_ERROR, Optional.empty());

        }



    }

}