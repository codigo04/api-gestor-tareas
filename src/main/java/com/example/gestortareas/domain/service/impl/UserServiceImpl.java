package com.example.gestortareas.domain.service.impl;

import com.example.gestortareas.domain.Enum.Roles;
import com.example.gestortareas.domain.User;
import com.example.gestortareas.domain.repository.UserRepository;
import com.example.gestortareas.domain.service.UserService;
import jakarta.persistence.EntityNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class UserServiceImpl implements UserService {

    @Autowired
    UserRepository userRepository;


    //buscar usuarios
    @Override
    public List<User> getAllUsers() {

        if (userRepository.getUsers() == null) {
            throw new RuntimeException("no se econtraron usuarios");
        } else {
            return userRepository.getUsers();
        }


        //return  userRepository.getUsers();
    }

    //buscar usuario por id
    @Override
    public Optional<User> getUser(int userId) {


        return userRepository.getUser(userId);

    }

    //crear usuario
    @Override
    public User addUser(User user) {

        return userRepository.createUser(user);
    }

    //eliminar usuario
    @Override
    public void delateUser(int userId) {

        userRepository.deleteUser(userId);
    }

    @Override
    public User updateUser(int id, User user) {

        Optional<User> userExist = userRepository.getUser(id);

        if (userExist.isPresent()) {
            User usuarioExistente = userExist.get();
            usuarioExistente.setGmail(user.getGmail());
            usuarioExistente.setPassword(user.getPassword());


            return userRepository.updateUser(usuarioExistente);
        } else {
            throw new EntityNotFoundException("Usuario con ID " + id + " no encontrado");
        }

    }


    @Override
    public UserDetailsService userDetailsService() {
        return new UserDetailsService() {
            @Override
            public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
                return userRepository.getUserEmail(username);
            }
        };
    }


}
