package com.saper.boxbackend.model;

import com.saper.boxbackend.dto.ClientRequestDTO;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

import jakarta.persistence.*;
import java.util.Collection;
import java.util.Set;

@Entity
public class Client implements UserDetails {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "client_id")
    Long id;

    @Column(nullable = false)
    String name;

    @Column(
        nullable = false,
        unique = true
    )
    String login;

    @Column(
        nullable = false,
        unique = true
    )
    String email;

    @Column(nullable = false)
    String password;
    @OneToOne(mappedBy = "client", cascade = CascadeType.ALL)
    @JoinColumn(name = "student_id")
    Student student;

    @ManyToMany(fetch = FetchType.EAGER)
    @JoinTable(
        name = "client_role",
        joinColumns = @JoinColumn(name = "client_id"),
        inverseJoinColumns = @JoinColumn(name = "role_id")
    )
    Set<Role> roles;

    public Client() {
    }

    public Client(ClientRequestDTO clientRequestDTO) {
        this.login = clientRequestDTO.login;
        this.password = new BCryptPasswordEncoder().encode(clientRequestDTO.password);
        this.name = clientRequestDTO.name;
        this.email = clientRequestDTO.email;
    }

    public Student getStudent() {
        return student;
    }

    public void setStudent(Student student) {
        this.student = student;
    }

    public Client(Long id, String name, String login, String email, String password) {
        this.id = id;
        this.name = name;
        this.login = login;
        this.email = email;
        this.password = password;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getLogin() {
        return login;
    }

    public void setLogin(String login) {
        this.login = login;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    @Override
    public Collection<? extends GrantedAuthority> getAuthorities() {
        return roles;
    }

    public String getPassword() {
        return password;
    }

    @Override
    public String getUsername() {
        return login;
    }

    @Override
    public boolean isAccountNonExpired() {
        return true;
    }

    @Override
    public boolean isAccountNonLocked() {
        return true;
    }

    @Override
    public boolean isCredentialsNonExpired() {
        return true;
    }

    @Override
    public boolean isEnabled() {
        return true;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public void setRoles(Set<Role> roles) {
        this.roles = roles;
    }
}
