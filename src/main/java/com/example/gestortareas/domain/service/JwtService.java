package com.example.gestortareas.domain.service;

import org.antlr.v4.runtime.Token;
import org.springframework.security.core.userdetails.UserDetails;

public interface JwtService {

    //extrae el nombre
    String stractUsername(String token);

    //genera el toquen
    String generearToken(UserDetails userDetails);

    //validamos el toquen
    boolean validateToken(String token, UserDetails userDetails);

}
