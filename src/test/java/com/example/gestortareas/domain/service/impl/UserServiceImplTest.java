package com.example.gestortareas.domain.service.impl;

import com.example.gestortareas.domain.User;
import com.example.gestortareas.domain.repository.UserRepository;
import org.aspectj.lang.annotation.Before;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Optional;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

class UserServiceImplTest {


    @Mock
    private UserRepository userRepository;

    @InjectMocks
    private UserServiceImpl userService;

    @BeforeEach
    void testUp() {
        MockitoAnnotations.openMocks(this);
    }


    @Test
    void testTodosUsuarios() {
        //arrange
        User user1 = new User("franco");
        User user2 = new User("fradd");
        User user3 = new User("fradd");
        List<User> userList = Arrays.asList(user1, user2, user3);
        when(userRepository.getUsers()).thenReturn(userList);
        //act
        List<User> result = userService.getAllUsers();
        //assert
        assertNotNull(result);
        assertEquals("franco", result.get(0).getName());
        assertEquals("fradd", result.get(1).getName());
        assertEquals("fradd", result.get(2).getName());

    }


    @Test
    void testUsuariosNoexists() {
        //arrange

        when(userRepository.getUsers()).thenReturn(null);

        //act & assert
        Exception result = assertThrows(RuntimeException.class, () -> userService.getAllUsers());

        assertEquals("no se econtraron usuarios", result.getMessage());


    }


    @Test
    void testUsuario() {
        //arrange
        int idUs =0;
        User user1 = new User("franco");

        Optional<User> user = Optional.of(user1);
        when(userRepository.getUser(idUs)).thenReturn(user);
        //act
        Optional<User> user2  = Optional.of(user1);

        //asert
        assertTrue(user2.isPresent(),"EL usuario deberia estar precente");
        assertEquals("franco",user2.get().getName(),"El nombre deberia de ser franco");


    }
}


