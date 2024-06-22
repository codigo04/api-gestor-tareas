package com.example.gestortareas.persistencia.entity;


import jakarta.persistence.*;

import java.sql.Date;
import java.time.LocalDateTime;
import java.util.List;


@Entity
@Table(name = "Usuarios")
public class Usuario{

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_usuario")
    Integer idUsuario;
    private String nombre;
    private String apellido;
    private String correo;
    private  String contraseña;
    @Column(name = "fecha_registro")
    private LocalDateTime fechaRegistro;


    @OneToMany(mappedBy = "usuario")
    private List<Proyecto> proyectos;

    //relacion usuario comentario
    @OneToMany(mappedBy = "usuario")
    private List<Comentario> comentarios;

    //usuario tareas
    @OneToMany(mappedBy = "usuario")
    private List<Tarea> tareas;


    public Usuario(Integer idUsuario, String apellido, String correo, String contraseña, LocalDateTime fechaRegistro, String nombre) {
        this.idUsuario = idUsuario;
        this.apellido = apellido;
        this.correo = correo;
        this.contraseña = contraseña;
        this.fechaRegistro = fechaRegistro;
        this.nombre = nombre;
    }

    public Usuario() {

    }

    public Integer getIdUsuario() {
        return idUsuario;
    }

    public void setIdUsuario(Integer idUsuario) {
        this.idUsuario = idUsuario;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getApellido() {
        return apellido;
    }

    public void setApellido(String apellido) {
        this.apellido = apellido;
    }

    public String getCorreo() {
        return correo;
    }

    public void setCorreo(String correo) {
        this.correo = correo;
    }

    public String getContraseña() {
        return contraseña;
    }

    public void setContraseña(String contraseña) {
        this.contraseña = contraseña;
    }

    public LocalDateTime getFechaRegistro() {
        return fechaRegistro;
    }

    public void setFechaRegistro(LocalDateTime fechaRegistro) {
        this.fechaRegistro = fechaRegistro;
    }

    public List<Proyecto> getProyectos() {
        return proyectos;
    }

    public void setProyectos(List<Proyecto> proyectos) {
        this.proyectos = proyectos;
    }

    public List<Comentario> getComentarios() {
        return comentarios;
    }

    public void setComentarios(List<Comentario> comentarios) {
        this.comentarios = comentarios;
    }

    public List<Tarea> getTareas() {
        return tareas;
    }

    public void setTareas(List<Tarea> tareas) {
        this.tareas = tareas;
    }
}
