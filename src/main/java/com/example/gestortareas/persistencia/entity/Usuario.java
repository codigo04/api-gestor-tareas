package com.example.gestortareas.persistencia.entity;


import jakarta.persistence.*;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

import java.time.LocalDateTime;
import java.util.Collection;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;


@Entity
@Table(name = "Usuarios")
public class Usuario implements UserDetails {

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

    @ManyToMany(fetch = FetchType.EAGER)
    @JoinTable(name = "usuario_rol",
            joinColumns = @JoinColumn(name = "id_usuario"),
            inverseJoinColumns = @JoinColumn(name = "id_rol"))
    private Set<Rol> rolesUsuario = new HashSet<>();


    public Usuario(Integer idUsuario, String nombre, String apellido, String correo, String contraseña, LocalDateTime fechaRegistro, List<Proyecto> proyectos, List<Comentario> comentarios, List<Tarea> tareas, Set<Rol> rolesUsuario) {
        this.idUsuario = idUsuario;
        this.nombre = nombre;
        this.apellido = apellido;
        this.correo = correo;
        this.contraseña = contraseña;
        this.fechaRegistro = fechaRegistro;
        this.proyectos = proyectos;
        this.comentarios = comentarios;
        this.tareas = tareas;
        this.rolesUsuario = rolesUsuario;
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

    public Set<Rol> getRolesUsuario() {
        return rolesUsuario;
    }

    public void setRolesUsuario(Set<Rol> roles) {
        this.rolesUsuario = roles;
    }

    /**
     * @return
     */
    @Override
    public Collection<? extends GrantedAuthority> getAuthorities() {
        return rolesUsuario.stream()
                .map(rol -> new SimpleGrantedAuthority(rol.getNombreRol()))
                .collect(Collectors.toList());
    }

    /**
     * @return
     */
    @Override
    public String getPassword() {
        return contraseña;
    }

    /**
     * @return
     */
    @Override
    public String getUsername() {
        return correo;
    }

    /**
     * @return
     */
    @Override
    public boolean isAccountNonExpired() {
        return true;
    }

    /**
     * @return
     */
    @Override
    public boolean isAccountNonLocked() {
        return true;
    }

    /**
     * @return
     */
    @Override
    public boolean isCredentialsNonExpired() {
        return true;
    }

    /**
     * @return
     */
    @Override
    public boolean isEnabled() {
        return true;
    }
}
