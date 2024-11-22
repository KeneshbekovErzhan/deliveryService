package com.example.deliveryservice.model;

import org.springframework.security.core.GrantedAuthority;

import java.util.List;

public enum Roles implements GrantedAuthority {
    USER,
    ADMIN,
    COURIER;

    public String getAuthority() {
        return "ROLE_" + this.name();
    }

    List<Roles> roles;

}
