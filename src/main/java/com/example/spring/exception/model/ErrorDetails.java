package com.example.spring.exception.model;

import lombok.Data;

import java.time.LocalDateTime;

@Data
public class ErrorDetails {
    private LocalDateTime timestamp;
    private int status;
    private String error;
    private String message;
    private String path;
    private String requestId;

    public ErrorDetails(LocalDateTime timestamp, int status, String error, String message, String path, String requestId) {
        this.timestamp = timestamp;
        this.status = status;
        this.error = error;
        this.message = message;
        this.path = path;
        this.requestId = requestId;
    }

}

