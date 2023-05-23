package com.saper.boxbackend.controller;

import com.saper.boxbackend.dto.ClientRequestDTO;
import com.saper.boxbackend.model.Client;
import com.saper.boxbackend.repository.ClientRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/client")
public class ClientController {

    @Autowired
    ClientRepository clientRepository;

    @GetMapping
    public Object getAll(){
        return clientRepository.findAll();
    }

    @PostMapping
    public Object save(@RequestBody ClientRequestDTO clientRequestDTO){

        Client client = new Client();
        client.setLogin(clientRequestDTO.login);
        client.setPassword(clientRequestDTO.password);
        client.setName(clientRequestDTO.name);
        client.setEmail(clientRequestDTO.email);

        return clientRepository.save(client);
    }
}
