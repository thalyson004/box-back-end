package com.saper.boxbackend.dto;

import com.saper.boxbackend.model.Client;

public class ClientResponseDTO {
    public Long id;

    public String name;

    public  String login;

    public  String email;

    public ClientResponseDTO(Client client) {
        this.id = client.getId();
        this.name = client.getName();
        this.login = client.getLogin();
        this.email = client.getEmail();
    }
}
