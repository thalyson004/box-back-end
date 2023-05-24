package com.saper.boxbackend.controller;

import com.saper.boxbackend.dto.BoxRequestDTO;
import com.saper.boxbackend.service.BoxService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/box")
public class BoxController {

    @Autowired
    BoxService boxService;

    @GetMapping
    public Object getAll(){
        return boxService.getAll();
    }

    @GetMapping("/{id}")
    public Object getOne(@PathVariable(name = "id") Long id){
        return boxService.findById(id);
    }

    @PostMapping
    public  Object save(BoxRequestDTO boxRequestDTO){
        return boxService.save(boxRequestDTO);
    }
}
