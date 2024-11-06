package com.example.gestortareas.domain.service;

import com.example.gestortareas.domain.User;
import com.example.gestortareas.domain.request.SingInRequest;
import com.example.gestortareas.domain.request.SingUpRequest;
import com.example.gestortareas.domain.response.AuthenticationResponse;

import java.util.List;

public interface AuthenticationService {
    User singUpUser(SingUpRequest singUpRequest);
    User singUpAdmin(SingUpRequest singUpRequest);

    List<User> todos();

    AuthenticationResponse singnin(SingInRequest singInRequest);
}
