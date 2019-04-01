package com.cgi.fic.api.exceptions;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.context.request.WebRequest;

@ControllerAdvice
public class FicApiExceptionHandler {


    @ExceptionHandler(value = { FicApiException.class })
    protected ResponseEntity<ErrorResource> convertException(FicApiException ex, WebRequest request) {
        return new ResponseEntity<ErrorResource>(ex.getErrorResource(), ex.getErrorResource().getStatus());
    }
}

