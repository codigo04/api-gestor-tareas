package com.example.gestortareas.domain;


import com.example.gestortareas.persistencia.entity.Rol;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

import java.time.LocalDateTime;
import java.util.Collection;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class User {

    private int userId;
    private String name;
    private String lastName;
    private String password;
    private String gmail;
    private LocalDateTime dateRegustration;
    private Set<Role> roles = new HashSet<>();
    //private List<Projects> projects;


    public User( String name) {
        this.name = name;


    }

    public User(int userId, String name, String lastName, String password, String gmail, LocalDateTime dateRegustration, Set<Role> roles) {
        this.userId = userId;
        this.name = name;
        this.lastName = lastName;
        this.password = password;
        this.gmail = gmail;
        this.dateRegustration = dateRegustration;
        this.roles = roles;
    }

    public Set<Role> getRoles() {
        return roles;
    }

    public void setRoles(Set<Role> roles) {
        this.roles = roles;
    }



    public User() {

    }

    public int getUserId() {
        return userId;
    }

    public void setUserId(int userId) {
        this.userId = userId;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }



    public String getPassword() {
        return password;
    }



    public void setPassword(String password) {
        this.password = password;
    }

    public String getGmail() {
        return gmail;
    }

    public void setGmail(String gmail) {
        this.gmail = gmail;
    }

    public LocalDateTime getDateRegustration() {
        return dateRegustration;
    }

    public void setDateRegustration(LocalDateTime dateRegustration) {
        this.dateRegustration = dateRegustration;
    }


}
