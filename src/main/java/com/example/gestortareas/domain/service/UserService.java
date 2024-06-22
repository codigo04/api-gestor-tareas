package com.example.gestortareas.domain.service;

import com.example.gestortareas.domain.User;
import com.example.gestortareas.domain.repository.UserRepository;
import com.example.gestortareas.persistencia.entity.Usuario;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UserService {

    @Autowired
    UserRepository userRepository;

    public List<User> getAllUsers() {

        if(userRepository.getUsers() == null){
            throw new RuntimeException("no se econtraron usuarios");
        }else{
            return  userRepository.getUsers();
        }


        //return  userRepository.getUsers();
    }


    public User addUser(User user) {

        return  userRepository.createUser(user);
    }


}
