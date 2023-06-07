package com.saper.boxbackend.service;


import com.saper.boxbackend.dto.TeamResponseDTO;
import com.saper.boxbackend.model.Client;
import com.saper.boxbackend.model.Student;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class MyService {

    public Client getClient(){
        Object logged = SecurityContextHolder.getContext().getAuthentication().getPrincipal();

        String username;

        if (logged instanceof Client) {
            return  (Client) logged;
        }else{
            return null;
        }
    }


    public ResponseEntity<Object> getTeams() {

        Client client = getClient();
        List<TeamResponseDTO> teamResponseDTOList = client.getStudent().getTeams().stream().map(team -> new TeamResponseDTO(team)).toList();
        return ResponseEntity.status(HttpStatus.OK).body(teamResponseDTOList);
    }
}
