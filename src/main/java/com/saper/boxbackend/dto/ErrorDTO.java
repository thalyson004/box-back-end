package com.saper.boxbackend.dto;

import java.time.Instant;

public class ErrorDTO {
    public Instant timeStamp;

    public String status;

    public String error;

    public String message;

    public String path;

    public ErrorDTO(Instant timeStamp, String status, String error, String message, String path) {
        this.timeStamp = timeStamp;
        this.status = status;
        this.error = error;
        this.message = message;
        this.path = path;
    }

    public ErrorDTO() {
    }
}
