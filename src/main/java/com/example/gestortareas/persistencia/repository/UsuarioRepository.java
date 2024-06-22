package com.example.gestortareas.persistencia.repository;

import com.example.gestortareas.domain.User;
import com.example.gestortareas.domain.repository.UserRepository;
import com.example.gestortareas.persistencia.crud.UsuarioCrudRepository;
import com.example.gestortareas.persistencia.entity.Usuario;
import com.example.gestortareas.persistencia.mapper.UserMapper;
import com.example.gestortareas.persistencia.mapper.UserMapperImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;


@Repository
public class UsuarioRepository implements UserRepository {

    @Autowired
    private UsuarioCrudRepository usuarioCrudRepository;

    @Autowired
    private UserMapper mapper;


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

        System.out.println(user.getName());

        Usuario usuario = mapper.toUsuario(user);

        return mapper.toUser(usuarioCrudRepository.save(usuario));
    }

    @Override
    public void deleteUser(int userId) {
        usuarioCrudRepository.deleteById(userId);
    }

    @Override
    public User updateUser(int userId, User user) {
        Optional<Usuario> optionalUsuario = usuarioCrudRepository.findById(userId);

        Usuario userExiste = optionalUsuario.get();

        userExiste.setCorreo(user.getGmail());

        userExiste.setContraseña(user.getPassword());

        return mapper.toUser(usuarioCrudRepository.save(userExiste));

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
