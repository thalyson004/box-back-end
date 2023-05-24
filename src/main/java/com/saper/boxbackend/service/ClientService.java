package com.saper.boxbackend.service;

import com.saper.boxbackend.dto.ClientRequestDTO;
import com.saper.boxbackend.dto.ClientResponseDTO;
import com.saper.boxbackend.model.Client;
import com.saper.boxbackend.repository.ClientRepository;
import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.Optional;

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

    public ResponseEntity<Object> findById(Long id) {
        Optional<Client> clientOptional = clientRepository.findById(id);

        if(clientOptional.isEmpty()){
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body("Cliente não encontrado");
        }else{
            return ResponseEntity.status(HttpStatus.OK).body(clientOptional.get());
        }
    }

    @Transactional
    public Object update(Long id, ClientRequestDTO clientRequestDTO) {
        Optional<Client> clientOptional = clientRepository.findById(id);

        if(clientOptional.isEmpty()){
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body("Cliente não encontrado");
        }else{
            Client client = clientOptional.get();

            if(clientRequestDTO.password!=null) {
                client.setPassword(clientRequestDTO.password);
            }

            if(clientRequestDTO.name!=null) {
                client.setName(clientRequestDTO.name);
            }

            return ResponseEntity.status(HttpStatus.OK).body(new ClientResponseDTO(clientRepository.save(client)));
        }
    }

    @Transactional
    public ResponseEntity<Object> delete(Long id) {
        Optional<Client> clientOptional = clientRepository.findById(id);

        if(clientOptional.isEmpty()){
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body("Cliente não encontrado");
        }else{
            clientRepository.delete(clientOptional.get());
            return ResponseEntity.status(HttpStatus.OK).build();
        }
    }
}
