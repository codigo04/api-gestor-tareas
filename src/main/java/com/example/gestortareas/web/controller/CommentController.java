package com.example.gestortareas.web.controller;

import com.example.gestortareas.domain.Comment;
import com.example.gestortareas.domain.constants.AppMessage;

import com.example.gestortareas.domain.response.ResponseBase;
import com.example.gestortareas.domain.service.CommentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;


@RestController
@RequestMapping("/v1/comment")
public class CommentController {

    @Autowired
    private CommentService commentService;


    @PostMapping("/create")
    public ResponseEntity<ResponseBase<Comment>> createCommentTask(@RequestBody Comment comment){


        ResponseBase<Comment>  responseBase = commentService.createCommentTask(comment);

          if (responseBase.getCodigo() == AppMessage.CODIGO_EXITO){
              return  ResponseEntity.ok(responseBase);
          }else{
              return   ResponseEntity.ok(responseBase);
          }

    }
}
