package com.example.gestortareas.domain.repository;


import com.example.gestortareas.domain.User;
import com.example.gestortareas.persistencia.entity.Usuario;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;


public interface UserRepository {


    //todo los user
    public List<User> getUsers();

    //buscar user
    public Optional<User> getUser(int userId);


    //crear user
    public  User createUser(User user);

    //eliminar user
    public void deleteUser(int userId);

    //actualizar user
    public  User updateUser(User user);

    public UserDetails getUserEmail(String email);

    public Optional<User> getUserEmailUser(String email);
}
