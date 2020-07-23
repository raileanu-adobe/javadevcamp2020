package com.adobe.devcamp.Controller;

import com.adobe.devcamp.ResourceNotFoundException;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseStatus;

@ControllerAdvice
public class MyExceptionHandler {

    @ExceptionHandler(ResourceNotFoundException.class)
    @ResponseStatus(value = HttpStatus.NOT_FOUND, reason = "no such entity")
    public String handleResourceNotFoundException(Exception ex) {
        return ex.getMessage();

    }
}
