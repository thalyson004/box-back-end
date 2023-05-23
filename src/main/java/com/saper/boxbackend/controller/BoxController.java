package com.saper.boxbackend.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/box")
public class BoxController {

    @GetMapping
    public String getAll(){
        return "Get boxes";
    }
}
