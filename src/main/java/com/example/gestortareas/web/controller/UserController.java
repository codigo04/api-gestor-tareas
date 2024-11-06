package com.example.gestortareas.web.controller;


import com.example.gestortareas.domain.User;
import com.example.gestortareas.domain.service.impl.UserServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api/users")
public class UserController {


    @Autowired
    UserServiceImpl userServiceImpl;

    @CrossOrigin(origins = "http://localhost:5173")
    @GetMapping("/v1/users")
    public List<User> getAllUsers() {

        if (userServiceImpl.getAllUsers().isEmpty()) {
            return List.of();
        } else {
            return userServiceImpl.getAllUsers();
        }

    }

    //buscar por id
    @GetMapping("/v1/{id}")
    public ResponseEntity<Optional<User>> getUser(@PathVariable("id") int userId) {

        if (userServiceImpl.getUser(userId) == null) {

            return ResponseEntity.notFound().build();
        } else {
            return ResponseEntity.ok(userServiceImpl.getUser(userId));
        }

    }

    //crear Usuario
    @PostMapping(value = "/v1/create", consumes = MediaType.APPLICATION_JSON_VALUE)
    public User addUser(@RequestBody User user) {

        //User createdUser = userService.addUser(user);

        System.out.println("nombre: " + user.getName());
        return userServiceImpl.addUser(user);
    }

    //eliminar
    @DeleteMapping("/v1/delete/{id}")
    public void deleteUser(@PathVariable("id") int userId) {
        userServiceImpl.delateUser(userId);
    }



    //actualizar
    @PutMapping("/v1/update/{id}")
    public User updateUser(@PathVariable("id") int id, @RequestBody User user) {

        return userServiceImpl.updateUser(id, user);
    }

}
