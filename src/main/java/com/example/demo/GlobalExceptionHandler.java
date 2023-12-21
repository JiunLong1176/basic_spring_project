package com.example.demo;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.http.converter.HttpMessageNotReadableException;
import org.springframework.web.bind.ServletRequestBindingException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

@ControllerAdvice
public class GlobalExceptionHandler {

    @ExceptionHandler(HttpMessageNotReadableException.class)
    public ResponseEntity<Object> handleMissingBody(HttpMessageNotReadableException ex) {
        String errorMessage = "Request body is missing or invalid. Please provide a valid request body.";
        return new ResponseEntity<>(errorMessage, HttpStatus.BAD_REQUEST);
    }

    @ExceptionHandler(ServletRequestBindingException.class)
    public ResponseEntity<Object> handleMissingRequestParam(ServletRequestBindingException ex) {
        String errorMessage = "Required request parameter is missing or invalid. Please provide a valid parameter.";
        return new ResponseEntity<>(errorMessage, HttpStatus.BAD_REQUEST);
    }
}