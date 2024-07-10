package com.example.gestortareas.domain.response;

import com.example.gestortareas.domain.Comment;

public class CreateCommentResponse extends ResponseBase<Comment> {
    public CreateCommentResponse(int codigo, String message, Comment data) {
        super(codigo, message, data);
    }

}
