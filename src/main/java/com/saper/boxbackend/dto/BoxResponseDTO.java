package com.saper.boxbackend.dto;

import com.saper.boxbackend.model.Box;

import java.util.List;

public class BoxResponseDTO {

    public Long id;
    public String name;

    public String created_by;
    public Integer capacity;

    public List<Long> teams;

    public BoxResponseDTO(String name) {
        this.name = name;
    }

    public BoxResponseDTO(Box box) {
        this.id = box.getId();
        this.name = box.getName();
        this.created_by = box.getCreated_by();
        this.capacity= box.getCapacity();
        this.teams = box.getTeams().stream().map(team -> team.getId()).toList();
    }

    public BoxResponseDTO(Long id, String name, String created_by, Integer capacity) {
        this.id = id;
        this.name = name;
        this.created_by = created_by;
        this.capacity = capacity;
    }
}
