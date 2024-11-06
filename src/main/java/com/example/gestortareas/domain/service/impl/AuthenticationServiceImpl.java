package com.example.gestortareas.domain.service.impl;


import com.example.gestortareas.domain.Enum.Roles;
import com.example.gestortareas.domain.Role;
import com.example.gestortareas.domain.User;
import com.example.gestortareas.domain.repository.RoleRepository;
import com.example.gestortareas.domain.repository.UserRepository;
import com.example.gestortareas.domain.request.SingInRequest;
import com.example.gestortareas.domain.request.SingUpRequest;
import com.example.gestortareas.domain.response.AuthenticationResponse;
import com.example.gestortareas.domain.service.AuthenticationService;
import com.example.gestortareas.domain.service.JwtService;
import com.example.gestortareas.persistencia.crud.RolCrudRepository;
import com.example.gestortareas.persistencia.crud.UsuarioCrudRepository;
import com.example.gestortareas.persistencia.entity.Rol;
import com.example.gestortareas.persistencia.mapper.UserMapper;
import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

@Service
public class AuthenticationServiceImpl implements AuthenticationService {

    @Autowired
    UserMapper mapper;

    @Autowired
    RoleRepository roleRepository;


    @Autowired
    UserRepository userRepository;

    @Autowired
    AuthenticationManager authenticationManager;

    @Autowired
    JwtService jwtService;

    @Transactional
    @Override
    public User singUpUser(SingUpRequest singUpRequest) {

        User user = new User();
        user.setName(singUpRequest.getName());
        user.setLastName(singUpRequest.getLastName());
        user.setGmail(singUpRequest.getGmail());
        user.setPassword(new BCryptPasswordEncoder().encode(singUpRequest.getPassword()));

        Set<Role> assginedRoles = new HashSet<>();

        Role roles = roleRepository.findByNombreRol(Roles.USER.name()).orElseThrow(() -> new RuntimeException("Rol no econtrado"));

        assginedRoles.add(roles);

        user.setRoles(assginedRoles);

        for (Role rolF: user.getRoles()){
            System.out.println("mostrando: "+rolF.getNameRole());
        }

        return userRepository.createUser(user);
    }

    /**
     * @param singUpRequest
     * @return
     */
    @Override
    public User singUpAdmin(SingUpRequest singUpRequest) {


        return null;
    }

    /**
     * @return
     */
    @Override
    public List<User> todos() {
        return List.of();
    }

    /**
     * @param singInRequest
     * @return
     */
    @Override
    public AuthenticationResponse singnin(SingInRequest singInRequest) {
        System.out.println("si llego");
        authenticationManager.authenticate(new UsernamePasswordAuthenticationToken(singInRequest.getEmail(), singInRequest.getPassword()));

        System.out.println("user detaiols");
        var user = userRepository.getUserEmail(singInRequest.getEmail());

        var token = jwtService.generearToken(user);
        System.out.println(token);
        System.out.println("si llego");
        AuthenticationResponse authenticationResponse = new AuthenticationResponse();
        authenticationResponse.setToken(token);

        return authenticationResponse;
    }
}
