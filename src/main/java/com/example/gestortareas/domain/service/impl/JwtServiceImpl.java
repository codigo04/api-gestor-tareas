package com.example.gestortareas.domain.service.impl;

import com.example.gestortareas.domain.service.JwtService;
import io.jsonwebtoken.*;
import io.jsonwebtoken.io.Decoders;
import io.jsonwebtoken.security.Keys;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Service;

import java.security.Key;
import java.util.Date;
import java.util.function.Function;

@Service
public class JwtServiceImpl implements JwtService {



    @Value("${key-signature}")
     private String keySignature;

    @Override
    public String stractUsername(String token) {
        return extractClaims(token,Claims::getSubject);
    }

    /**
     * @param userDetails
     * @return
     */
    @Override
    public String generearToken(UserDetails userDetails) {
        return Jwts.builder()
                .setSubject(userDetails.getUsername())
                .setIssuedAt(new Date())
                .setExpiration(new Date(System.currentTimeMillis()+120000))
                .signWith(getKey(), SignatureAlgorithm.HS256)
                .compact();
    }

    /**
     * @param token
     * @param userDetails
     * @return
     */
    @Override
    public boolean validateToken(String token, UserDetails userDetails) {

        final  String username = stractUsername(token);
        return (username.equals(userDetails.getUsername()) && !isTokenExpired(token));
    }


    private Key getKey(){
         byte [] key = Decoders.BASE64.decode(keySignature);
        return Keys.hmacShaKeyFor(key);
    }


    private Claims extractAllClaims(String token){

        JwtParser parser = Jwts.parserBuilder()
                .setSigningKey(getKey())
                .build();

        return parser.parseClaimsJws(token)
                .getBody();

    }

    private  <T> T extractClaims(String token, Function<Claims,T> claimsTResults){
        final Claims claims = extractAllClaims(token);

        return claimsTResults.apply(claims);
    }

    private boolean isTokenExpired(String token){
        return  extractClaims(token,Claims::getExpiration).before(new Date());
    }
}
