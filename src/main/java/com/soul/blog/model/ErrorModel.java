package com.soul.blog.model;

import lombok.*;
import org.springframework.data.annotation.CreatedDate;
import org.springframework.http.HttpStatus;

import java.time.LocalDateTime;

@Getter
@Setter
@ToString
public class ErrorModel {
    private HttpStatus httpStatus;
    private LocalDateTime timestamp;
    private String message;
    private String details;

    public ErrorModel(HttpStatus httpStatus, String message, String details) {
        this.httpStatus = httpStatus;
        this.message = message;
        this.details = details;
        this.timestamp = LocalDateTime.now();
    }
}
