package com.example.gestortareas.domain.service;

import com.example.gestortareas.domain.User;
import org.springframework.security.core.userdetails.UserDetailsService;

import java.util.List;
import java.util.Optional;

public interface UserService {

    public List<User> getAllUsers();

    //buscar usuario por id
    public Optional<User> getUser(int userId);

    //crear usuario
    public User addUser(User user);

    //eliminar usuario

    public void delateUser( int userId);

    public User updateUser(int id,User user);



    public UserDetailsService userDetailsService();

}
