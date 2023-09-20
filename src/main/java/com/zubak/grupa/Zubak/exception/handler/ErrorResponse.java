package com.zubak.grupa.Zubak.exception.handler;

import lombok.Data;

import java.time.LocalDateTime;

@Data
public class ErrorResponse {
    private String errorCode;
    private String errorMessage;
    private LocalDateTime localDateTime;

    public ErrorResponse(String errorCode, String errorMessage) {
        this.errorCode = errorCode;
        this.errorMessage = errorMessage;
        this.localDateTime = LocalDateTime.now();
    }
}
