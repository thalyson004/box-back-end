package com.saper.boxbackend.dto;

public class ErrorDTO {
    public String field;
    public String error;

    public ErrorDTO(String field, String error) {
        this.field = field;
        this.error = error;
    }

    public ErrorDTO() {
    }

}
