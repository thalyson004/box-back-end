package com.saper.boxbackend.dto;

import jakarta.validation.constraints.Max;
import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;

public class BoxRequestDTO {

    @Size(min = 5)
    @NotNull
    public String name;

    @Min(3)
    @Max(99)
    @NotNull
    public Integer capacity;

    public BoxRequestDTO() {
    }

    public BoxRequestDTO(String name, Integer capacity) {
        this.name = name;
        this.capacity = capacity;
    }
}
