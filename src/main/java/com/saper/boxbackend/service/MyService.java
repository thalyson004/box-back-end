package com.saper.boxbackend.service;


import com.saper.boxbackend.model.Client;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Service;

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


}
