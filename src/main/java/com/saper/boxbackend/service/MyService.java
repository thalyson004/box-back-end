package com.saper.boxbackend.service;

import com.saper.boxbackend.dto.TeamResponseDTO;
import com.saper.boxbackend.model.Client;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Service;

@Service
public class MyService {

    public Client getLogged(){
        return (Client) SecurityContextHolder.getContext().getAuthentication().getPrincipal();
    }

    public ResponseEntity<Object> getEnrollments() {
        Client client = getLogged();

        return ResponseEntity.status(HttpStatus.OK).body(client.getStudent().getTeams().stream().map(team -> new TeamResponseDTO(team)).toList());
    }
}
