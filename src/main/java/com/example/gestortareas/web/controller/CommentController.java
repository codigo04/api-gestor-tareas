package com.example.gestortareas.web.controller;

import com.example.gestortareas.domain.Comment;
import com.example.gestortareas.domain.constants.AppMessage;

import com.example.gestortareas.domain.response.ResponseBase;
import com.example.gestortareas.domain.service.CommentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;


@RestController
@RequestMapping("/api/comment")
public class CommentController {

    @Autowired
    private CommentService commentService;


    @PostMapping("/v1/create")
    public ResponseEntity<ResponseBase<Comment>> createCommentTask(@RequestBody Comment comment) {

        ResponseBase<Comment> responseBase = commentService.createCommentTask(comment);

        if (responseBase.getCodigo() == AppMessage.CODIGO_EXITO) {
            return ResponseEntity.ok(responseBase);
        } else {
            return ResponseEntity.ok(responseBase);
        }
    }

    @GetMapping("/v1/Comment/{id}")
    public ResponseEntity<ResponseBase> getComment(@PathVariable("id") int commentId) {

        ResponseBase<Optional<Comment>> responseBase = commentService.getComment(commentId);

        if (responseBase.getCodigo() == AppMessage.CODIGO_EXITO) {

            return ResponseEntity.ok(responseBase);
        } else {
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(responseBase);
        }

    }


    @GetMapping("/v1/Comment/task/{ide}")
    public ResponseEntity<ResponseBase> getComentstask(@PathVariable("ide") int taskId){
        ResponseBase<List<Comment>> responseBase =   commentService.getCommentTask(taskId);

          if(responseBase.getCodigo() == AppMessage.CODIGO_EXITO){
              return ResponseEntity.ok(responseBase);
          }else{
              return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(responseBase);
          }

    }

    @DeleteMapping("/v1/Comment/delete/{id}")
    public ResponseEntity<ResponseBase>  delete(@PathVariable("id") int commentId){
       ResponseBase<Boolean> responseBase =  commentService.deleteCommentDeTask(commentId);

       if(responseBase.getCodigo() == AppMessage.CODIGO_EXITO){
          return  ResponseEntity.ok(responseBase);
       }else {
           return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(responseBase);
       }

    }

    @PutMapping("/v1/Comment/update/{id}")
    public ResponseEntity<ResponseBase> update(@PathVariable("id") int commentId,  @RequestBody Comment comment){
        ResponseBase<Optional<Comment>> responseBase = commentService.updateCommentTask(commentId,comment);

        if (responseBase.getCodigo() == AppMessage.CODIGO_EXITO){
             return  ResponseEntity.ok(responseBase);
        }else{
            return  ResponseEntity.status(HttpStatus.BAD_REQUEST).body(responseBase);
        }

    }



}
