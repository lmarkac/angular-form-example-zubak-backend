package com.zubak.grupa.Zubak.exception.handler;

import com.zubak.grupa.Zubak.exception.FormUploadException;
import org.postgresql.util.PSQLException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

@ControllerAdvice
public class GlobalExceptionHandler {

    @ExceptionHandler(value = FormUploadException.class)
    public ResponseEntity<Object> handleCustomNotFoundException(FormUploadException e) {
        return new ResponseEntity<>(new ErrorResponse("BAD_FORM_DATA", e.getMessage()), HttpStatus.BAD_REQUEST);
    }

    @ExceptionHandler(value = PSQLException.class)
    public ResponseEntity<Object> handleCustomNotFoundException(PSQLException e) {
        return new ResponseEntity<>(new ErrorResponse("BAD_FORM_DATA", e.getMessage()), HttpStatus.BAD_REQUEST);
    }

}
