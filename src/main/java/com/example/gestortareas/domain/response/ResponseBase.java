package com.example.gestortareas.domain.response;

public class ResponseBase<T> {

    private int codigo;
    private String message;
    private T data;


    public ResponseBase() {

    }

    public ResponseBase(int codigo, String message, T data) {
        this.codigo = codigo;
        this.message = message;
        this.data = data;
    }

    public int getCodigo() {
        return codigo;
    }

    public void setCodigo(int codigo) {
        this.codigo = codigo;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public T getData() {
        return data;
    }

    public void setData(T data) {
        this.data = data;
    }
}
