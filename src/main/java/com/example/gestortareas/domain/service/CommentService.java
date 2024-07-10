package com.example.gestortareas.domain.service;

import com.example.gestortareas.domain.Comment;
import com.example.gestortareas.domain.constants.AppMessage;
import com.example.gestortareas.domain.repository.CommentRepository;
import com.example.gestortareas.domain.response.CreateCommentResponse;
import com.example.gestortareas.domain.response.ResponseBase;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class CommentService {
    @Autowired
    private CommentRepository commentRepository;

    //metodos que llevaran logica de negocio

    public ResponseBase<Comment> createCommentTask(Comment comment){


        try {
            Optional<Comment> comment1 =  commentRepository.createCommentTask(comment);

            if (comment1.isPresent()){
                return new CreateCommentResponse(AppMessage.CODIGO_EXITO,AppMessage.MENSAJE_EXITO,comment1.get());
            }else{
                return new CreateCommentResponse(AppMessage.CODIGO_ERROR,AppMessage.INVALID_REQUEST,comment1.get());
            }
        }catch (Exception e){

            System.out.println("erro fatal");
            return new ResponseBase<Comment>(AppMessage.CODIGO_ERROR,AppMessage.INVALID_REQUEST,null);

        }

    }


}
