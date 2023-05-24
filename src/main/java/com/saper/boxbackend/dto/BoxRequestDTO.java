package com.saper.boxbackend.dto;

public class BoxRequestDTO {
    public String name;
    public Integer capacity;

    public BoxRequestDTO() {
    }

    public BoxRequestDTO(String name, Integer capacity) {
        this.name = name;
        this.capacity = capacity;
    }
}
