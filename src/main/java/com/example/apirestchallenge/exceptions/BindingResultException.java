package com.example.apirestchallenge.exceptions;

import lombok.Getter;
import org.springframework.validation.BindingResult;
import org.springframework.validation.FieldError;

import java.util.List;

@Getter
public class BindingResultException extends Throwable {


    List<FieldError> fieldErrors;

    public BindingResultException(BindingResult bindingResult) {

        this.fieldErrors = bindingResult.getFieldErrors().stream().toList();
    }
}
