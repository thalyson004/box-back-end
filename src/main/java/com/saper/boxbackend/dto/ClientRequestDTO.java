package com.saper.boxbackend.dto;

import jakarta.validation.constraints.NotBlank;

public class ClientRequestDTO {

    @NotBlank(message = "Nome não pode ser vazio")
    public String name;

    public  String password;

    public  String login;

    public  String email;
}
