package com.example.gestortareas.web.controller;


import com.example.gestortareas.domain.Role;
import com.example.gestortareas.domain.User;
import com.example.gestortareas.domain.request.SingInRequest;
import com.example.gestortareas.domain.request.SingUpRequest;
import com.example.gestortareas.domain.response.AuthenticationResponse;
import com.example.gestortareas.domain.service.AuthenticationService;
import com.example.gestortareas.persistencia.entity.Rol;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/authentication")
public class AuthenticationController {


    @Autowired
   AuthenticationService authenticationService;


    @PostMapping("/singupadmin")
    public ResponseEntity<User>  singUpAdmin(@RequestBody SingUpRequest singUpRequest){

        return ResponseEntity.ok( authenticationService.singUpAdmin(singUpRequest));
    }

    @PostMapping("/singupuser")
    public  ResponseEntity<User> singUpUser(@RequestBody SingUpRequest singUpRequest){



        return ResponseEntity.ok(authenticationService.singUpUser(singUpRequest));
    }

    @PostMapping("/singin")
    public ResponseEntity<AuthenticationResponse> singIn(@RequestBody  SingInRequest singInRequest){
        System.out.println("si llego");

        return ResponseEntity.ok(authenticationService.singnin(singInRequest));
    }


}

