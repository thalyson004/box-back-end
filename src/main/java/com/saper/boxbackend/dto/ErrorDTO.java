package com.saper.boxbackend.dto;

public class ErrorDTO {

    public String field;
    public String message;

    public ErrorDTO(String field, String message) {
        this.field = field;
        this.message = message;
    }

    public ErrorDTO() {
    }
}
