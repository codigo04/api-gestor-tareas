package com.example.gestortareas.domain.repository;

import com.example.gestortareas.domain.Comment;
import com.example.gestortareas.persistencia.crud.TareaCrudRespository;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;
import java.util.Optional;

public interface CommentRepository {


    public Optional<Comment> createCommentTask(Comment comment);


    public List<Comment> readCommentsTask(int taskId);


    public void deleteCommentsTask(int taskId);


    public Comment updateCommentTask(Comment comment) ;
}
