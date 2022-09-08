package com.example.apirestchallenge.controllers;

import com.example.apirestchallenge.exceptions.BindingResultException;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

import java.util.HashMap;
import java.util.Map;
import java.util.stream.Collectors;

import static org.springframework.http.HttpStatus.BAD_REQUEST;

@RestControllerAdvice
public class CustomExceptionHandler extends ResponseEntityExceptionHandler {

    @ExceptionHandler(BindingResultException.class)
    protected ResponseEntity<?> handleBindingResultException(BindingResultException ex) {

        Map<String, Object> tokens = new HashMap<>();
        var token2 = ex.getFieldErrors().stream().map(vale -> {
            Map<String, Object> tokens2 = new HashMap<>();
            tokens2.put("message", vale.getDefaultMessage());
            tokens2.put("code", vale.getCode());
            tokens2.put("field", vale.getField());
            return tokens2;
        }).collect( Collectors.toList());

        tokens.put("errorMessage", "Hay errores en lo enviado");
        tokens.put("errorFields", token2);
        tokens.put("errorCode", BAD_REQUEST);
        return new ResponseEntity<>(tokens, BAD_REQUEST);
    }

}
