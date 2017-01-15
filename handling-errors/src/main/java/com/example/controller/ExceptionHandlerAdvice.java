package com.example.controller;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.client.HttpClientErrorException;

@ControllerAdvice
class ExceptionHandlerAdvice {

    @ExceptionHandler(value = HttpClientErrorException.class)
    ResponseEntity<?> handleHttpClientException(HttpClientErrorException exception) throws Exception {
        return new ResponseEntity(exception.getResponseBodyAsByteArray(),
                exception.getResponseHeaders(),
                exception.getStatusCode());
    }
}
