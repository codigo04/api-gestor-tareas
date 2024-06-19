package com.example.gestortareas.persistencia.entity;

import jakarta.persistence.*;

import java.util.Date;

@Entity
@Table(name = "Comentarios")
public class Comentario {
     @Id
     @GeneratedValue(strategy = GenerationType.IDENTITY)
     @Column(name = "id_comentario")
     Integer idComentario;


     String comentario;

     @Column(name = "fecha_comentario")
     Date fechaComentario;

     @Column(name = "id_tarea")
     Integer idTarea;

    @Column(name = "id_usuario")
    Integer idUsuario;

   @ManyToOne
   @JoinColumn(name ="id_comentario",insertable = false, updatable = false)
   private Tarea tareaC;   //relacion tareas comentarios

    @ManyToOne
    @JoinColumn(name = "id_usuario",insertable = false, updatable = false)
    private Usuario usuario;  //relacion usuario comentario


    public Integer getIdComentario() {
        return idComentario;
    }

    public void setIdComentario(Integer idComentario) {
        this.idComentario = idComentario;
    }

    public String getComentario() {
        return comentario;
    }

    public void setComentario(String comentario) {
        this.comentario = comentario;
    }

    public Date getFechaComentario() {
        return fechaComentario;
    }

    public void setFechaComentario(Date fechaComentario) {
        this.fechaComentario = fechaComentario;
    }

    public Integer getIdTarea() {
        return idTarea;
    }

    public void setIdTarea(Integer idTarea) {
        this.idTarea = idTarea;
    }

    public Integer getIdUsuario() {
        return idUsuario;
    }

    public void setIdUsuario(Integer idUsuario) {
        this.idUsuario = idUsuario;
    }

    
}
