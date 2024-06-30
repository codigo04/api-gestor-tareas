package com.example.gestortareas.domain.service;

import com.example.gestortareas.domain.User;
import com.example.gestortareas.domain.repository.UserRepository;
import com.example.gestortareas.persistencia.entity.Usuario;
import jakarta.persistence.EntityNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.PathVariable;

import java.util.List;
import java.util.Optional;

@Service
public class UserService {

    @Autowired
    UserRepository userRepository;


    //buscar usuarios
    public List<User> getAllUsers() {

        if(userRepository.getUsers() == null){
            throw new RuntimeException("no se econtraron usuarios");
        }else{
            return  userRepository.getUsers();
        }


        //return  userRepository.getUsers();
    }

    //buscar usuario por id
    public Optional<User> getUser(int userId){


        return userRepository.getUser(userId);

    }

    //crear usuario
    public User addUser(User user) {

        return  userRepository.createUser(user);
    }

    //eliminar usuario

    public void delateUser( int userId){

        userRepository.deleteUser(userId);
    }

    public User updateUser(int id,User user){

        Optional<User> userExist = userRepository.getUser(id);

        if (userExist.isPresent()){
            User usuarioExistente = userExist.get();

            usuarioExistente.setGmail(user.getGmail());
            usuarioExistente.setPassword(user.getPassword());


           return userRepository.updateUser(usuarioExistente);
        }else{
            throw new EntityNotFoundException("Usuario con ID " + id + " no encontrado");
        }

    }

}
