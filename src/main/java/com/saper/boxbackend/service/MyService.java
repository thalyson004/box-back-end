package com.saper.boxbackend.service;

import com.saper.boxbackend.model.Client;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Service;

@Service
public class MyService {

    public Client getLogged(){
        return (Client) SecurityContextHolder.getContext().getAuthentication().getPrincipal();
    }
}
