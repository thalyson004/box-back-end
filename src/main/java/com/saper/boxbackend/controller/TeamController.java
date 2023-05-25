package com.saper.boxbackend.controller;

import com.saper.boxbackend.dto.TeamRequestDTO;
import com.saper.boxbackend.service.TeamService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/team")
public class TeamController {
    @Autowired
    TeamService teamService;

    @PostMapping
    public Object save(@RequestBody TeamRequestDTO teamRequestDTO){
        return teamService.save(teamRequestDTO);
    }
}
