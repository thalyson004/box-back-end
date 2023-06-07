package com.saper.boxbackend.dto;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;

public class ClientRequestDTO {

    @NotBlank(message = "Nome não pode ser em branco")
    public String name;

    @Size(min = 3, max = 10, message = "Password tem tamanho entre 3 e 10")
    public  String password;

    @NotBlank
    public  String login;

    public  String email;
}
