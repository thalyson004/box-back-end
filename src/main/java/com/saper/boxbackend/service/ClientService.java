package com.saper.boxbackend.service;

import com.saper.boxbackend.dto.ClientRequestDTO;
import com.saper.boxbackend.dto.ClientResponseDTO;
import com.saper.boxbackend.model.Client;
import com.saper.boxbackend.repository.ClientRepository;
import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ClientService {

    @Autowired
    ClientRepository clientRepository;

    public Object getAll(){
        return clientRepository.findAll().stream().map((client -> new ClientResponseDTO(client)));
    }

    @Transactional
    public Object save(ClientRequestDTO clientRequestDTO){
        Client client = new Client(clientRequestDTO);

        client = clientRepository.save(client);

        ClientResponseDTO clientResponseDTO = new ClientResponseDTO(client);

        return clientResponseDTO;
    }
}
