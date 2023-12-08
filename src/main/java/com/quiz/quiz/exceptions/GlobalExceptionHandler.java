package com.quiz.quiz.exceptions;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

import com.quiz.quiz.response.ResponseHandler;

@ControllerAdvice
public class GlobalExceptionHandler {
    @ExceptionHandler(Exception.class)
    public ResponseEntity<Object> genericErrorResponse(Exception exception){
        return ResponseHandler.generateResponse(exception.getCause(), HttpStatus.INTERNAL_SERVER_ERROR, "Something went wrong.", false);
    }
}
