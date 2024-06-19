package com.example.gestortareas.persistencia.entity;


import jakarta.persistence.*;

import java.sql.Date;
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
    private Date fechaRegistro;

    @OneToMany(mappedBy = "usuario")
    private List<Proyecto> proyectos;


    @OneToMany(mappedBy = "usuario")
    private List<Comentario> comentarios;  //relacion usuario comentario

    @OneToMany(mappedBy = "usuario")
    private List<Tarea> tareas;


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

    public Date getFechaRegistro() {
        return fechaRegistro;
    }

    public void setFechaRegistro(Date fechaRegistro) {
        this.fechaRegistro = fechaRegistro;
    }
}
