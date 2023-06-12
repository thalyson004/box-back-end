package com.saper.boxbackend.service;

import com.saper.boxbackend.dto.ClientRequestDTO;
import com.saper.boxbackend.dto.ClientResponseDTO;
import com.saper.boxbackend.dto.ErrorDTO;
import com.saper.boxbackend.model.Client;
import com.saper.boxbackend.repository.ClientRepository;
import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.time.Instant;
import java.util.Optional;

@Service
public class ClientService {

    @Autowired
    ClientRepository clientRepository;

    public Object getAllByName(String name){
        if(name.equals("")) {
            return clientRepository.findAll().stream().map((client -> new ClientResponseDTO(client)));
        }else{
            return clientRepository.findAllByNameContaining(name).stream().map((client -> new ClientResponseDTO(client)));
        }
    }

    @Transactional
    public Object save(ClientRequestDTO clientRequestDTO){
        Client client = new Client(clientRequestDTO);

        client = clientRepository.save(client);

        ClientResponseDTO clientResponseDTO = new ClientResponseDTO(client);

        return clientResponseDTO;
    }

    public ResponseEntity<Object> findById(Long id) {
        Client client = clientRepository.findById(id).orElseThrow();

        return ResponseEntity.status(HttpStatus.OK).body(new ClientResponseDTO(client));
    }

    @Transactional
    public Object update(Long id, ClientRequestDTO clientRequestDTO) {
        Client client = clientRepository.findById(id).orElseThrow();

        return ResponseEntity.status(HttpStatus.OK).body(new ClientResponseDTO(clientRepository.save(client)));
    }

    @Transactional
    public ResponseEntity<Object> delete(Long id) {
        Client client = clientRepository.findById(id).orElseThrow();

        clientRepository.delete(client);

        return ResponseEntity.status(HttpStatus.OK).build();
    }
}
