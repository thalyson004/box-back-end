package com.saper.boxbackend.controller;

import com.saper.boxbackend.dto.BoxRequestDTO;
import com.saper.boxbackend.service.BoxService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/box")
public class BoxController {

    @Autowired
    BoxService boxService;

    @GetMapping
    public Object getAll(){
        return boxService.getAll();
    }

    @PostMapping
    public  Object save(BoxRequestDTO boxRequestDTO){
        return boxService.save(boxRequestDTO);
    }
}
