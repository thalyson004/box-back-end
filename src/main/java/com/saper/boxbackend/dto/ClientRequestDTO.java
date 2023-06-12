package com.saper.boxbackend.dto;

import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;

public class ClientRequestDTO {

    @Size(min = 5, max = 50, message = "Tamanho do nome deve ser entre 5 e 50")
    @NotBlank(message = "Nome não pode ser em branco")
    public String name;

    @Size(min = 3, max = 10, message = "Password tem tamanho entre 3 e 10")
    @NotBlank(message = "password não pode ser em branco")
    public  String password;

    @NotBlank
    public  String repeated_password;

    @Email(message = "login deve ser um email")
    @NotBlank(message = "login não pode ser em branco")
    public  String login;

    @Email
    public  String email;

    public ClientRequestDTO() {
    }

    public ClientRequestDTO(String name, String password, String repeated_password, String login, String email) {
        this.name = name;
        this.password = password;
        this.repeated_password = repeated_password;
        this.login = login;
        this.email = email;
    }
}
