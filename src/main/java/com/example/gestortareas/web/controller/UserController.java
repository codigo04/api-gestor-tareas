package com.example.gestortareas.web.controller;


import com.example.gestortareas.domain.User;
import com.example.gestortareas.domain.service.UserService;
import com.example.gestortareas.persistencia.crud.UsuarioCrudRepository;
import com.example.gestortareas.persistencia.entity.Usuario;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/users")
public class UserController {


    @Autowired
    UserService userService;



    @GetMapping("/users")
    public List<User> getAllUsers(){

       if(userService.getAllUsers().isEmpty()){
           return List.of();
       }else{
           return userService.getAllUsers();
       }

    }

    @PostMapping(value = "/create", consumes = MediaType.APPLICATION_JSON_VALUE)
    public User addUser(@RequestBody User user){

        //User createdUser = userService.addUser(user);

        System.out.println( "nombre: "+user.getName());
        return userService.addUser(user);
    }
}
