package com.saper.boxbackend.model;

import com.saper.boxbackend.enums.RoleNames;
import org.springframework.security.core.GrantedAuthority;

import jakarta.persistence.*;
import java.util.Set;

@Entity
public class Role implements GrantedAuthority {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    Long id;


    @Enumerated(EnumType.STRING)
    RoleNames role;

    @ManyToMany(mappedBy = "roles")
    Set<Client> clients;

    @Override
    public String getAuthority() {
        return role.toString();
    }
}
