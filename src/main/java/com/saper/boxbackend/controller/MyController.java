package com.saper.boxbackend.controller;

import com.saper.boxbackend.dto.ClientResponseDTO;
import com.saper.boxbackend.service.MyService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/my")
public class MyController {

    @Autowired
    MyService myService;

    @GetMapping("/client")
    public ResponseEntity<Object> getClient(){
        return ResponseEntity.status(HttpStatus.OK).body(new ClientResponseDTO(myService.getLogged()));
    }

    @GetMapping("/enrollments")
    public ResponseEntity<Object> getEnrollments(){
        return myService.getEnrollments();
    }
}
