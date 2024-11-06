package com.example.gestortareas.persistencia.repositorio;

import com.example.gestortareas.domain.Role;
import com.example.gestortareas.domain.User;
import com.example.gestortareas.domain.repository.UserRepository;
import com.example.gestortareas.persistencia.crud.RolCrudRepository;
import com.example.gestortareas.persistencia.crud.UsuarioCrudRepository;
import com.example.gestortareas.persistencia.entity.Rol;
import com.example.gestortareas.persistencia.entity.Usuario;
import com.example.gestortareas.persistencia.mapper.RoleMapper;
import com.example.gestortareas.persistencia.mapper.UserMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Repository;

import java.util.HashSet;
import java.util.List;
import java.util.Optional;
import java.util.Set;


@Repository
public class UsuarioRepository implements UserRepository {

    @Autowired
    private UsuarioCrudRepository usuarioCrudRepository;

    @Autowired
    private UserMapper mapper;

    @Autowired
   RoleMapper roleMapper;

    @Autowired
    RolCrudRepository rolCrudRepository;

    //todo users
    @Override
    public List<User> getUsers() {

        List<User> users = mapper.toUsers((List<Usuario>) usuarioCrudRepository.findAll());

        return users;
    }

    @Override
    public Optional<User> getUser(int userId) {

        return usuarioCrudRepository.findById(userId).map(usuario -> mapper.toUser(usuario));
    }

    @Override
    public User createUser(User user) {

        Usuario us = new Usuario();

        us.setNombre(user.getName());
        us.setApellido(user.getLastName());
        us.setCorreo(user.getGmail());
        us.setContraseña(user.getPassword());

        Set<Rol> assginedRoles = new HashSet<>();

        for (Role rolF: user.getRoles()){
            Rol rol = rolCrudRepository.findByNombreRol(rolF.getNameRole()).orElseThrow(()-> new RuntimeException("EL ROL NO EXISTE REVISA TU BD"));
            assginedRoles.add(rol);
        }
        us.setRolesUsuario(assginedRoles);



        return mapper.toUser(usuarioCrudRepository.save(us));
    }

    @Override
    public void deleteUser(int userId) {
        usuarioCrudRepository.deleteById(userId);
    }

    @Override
    public User updateUser( User user) {

        Usuario userExiste = mapper.toUsuario(user);

        return mapper.toUser(usuarioCrudRepository.save(userExiste));

    }



    /**
     * @param email
     * @return
     */
    @Override
    public UserDetails getUserEmail(String email) {
        Optional<Usuario>  usuario =   usuarioCrudRepository.findByCorreo(email);

        return usuario.get();
    }

    @Override
    public Optional<User> getUserEmailUser(String email) {
        Optional<Usuario>  usuario =   usuarioCrudRepository.findByCorreo(email);

        return usuario.map(user->mapper.toUser(user));
    }


    public UserDetails getUserEmailss(String email) {
        Optional<Usuario>  usuario =   usuarioCrudRepository.findByCorreo(email);
        return usuario.get();
    }
/*
    actualizar usuario
    public Usuario actualizarUsuario(int idUsuario, Usuario usuarioActualizado) {
        Optional<Usuario> usuario = buscarUsuario(idUsuario);

        if (usuario.isPresent()) {
            Usuario userExistente = usuario.get();
            userExistente.setCorreo(usuarioActualizado.getCorreo());
            userExistente.setContraseña(usuarioActualizado.getContraseña());

            return usuarioCrudRepository.save(userExistente);

        } else {
            throw new RuntimeException("Usuario no econtrado");
        }
    }




    //todo los usuarios
    public List<Usuario> buscarTodos() {

        List<Usuario> usuarios = (List<Usuario>) usuarioCrudRepository.findAll();

        return usuarios;
    }


    //buscar usuario
    public Optional<Usuario> buscarUsuario(int idUsuario) {

        return usuarioCrudRepository.findById(idUsuario);
    }

    //crea usuario
    public Usuario crearUsuario(Usuario usuario) {
        return usuarioCrudRepository.save(usuario);
    }

    //eliminar usuario
    public void eliminarUsuario(int idUsuario) {


        usuarioCrudRepository.deleteById(idUsuario);
    }

   */
}
