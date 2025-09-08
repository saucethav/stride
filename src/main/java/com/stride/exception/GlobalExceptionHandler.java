package com.stride.exception;

import org.springframework.dao.DataIntegrityViolationException; //Database constraint violation
import org.springframework.http.HttpStatus; //HTTP codes
import org.springframework.http.ResponseEntity; //Full HTTP responses
import org.springframework.web.bind.MethodArgumentNotValidException; //Exception when @Valid fails
import org.springframework.web.bind.annotation.ControllerAdvice; //Global Error handler
import org.springframework.web.bind.annotation.ExceptionHandler; //Specific Exception Handler marker

import java.util.stream.Collectors; //Stream API

@ControllerAdvice

public class GlobalExceptionHandler {
    //Handles Database constraints (ex. duplicate emails)
    @ExceptionHandler(DataIntegrityViolationException.class)
    public ResponseEntity<ErrorResponse> handleDataIntegrityViolation(DataIntegrityViolationException ex){

        //Get the root cause
        String message = ex.getRootCause() != null ? ex.getRootCause().getMessage() : ex.getMessage();

        ErrorResponse error = new ErrorResponse("Database constraint violation", message);

        //Return Error 400
        return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(error);
    }


    //Validation Error Handler
    @ExceptionHandler(MethodArgumentNotValidException.class)
    public ResponseEntity<ErrorResponse> handleValidationErrors(MethodArgumentNotValidException ex){
        String message = ex.getBindingResult().getFieldErrors().stream().map(error -> error.getField() + ": " + error.getDefaultMessage()).collect(Collectors.joining(", "));

        ErrorResponse error = new ErrorResponse("Validation Failed", message);
        return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(error);

    }

    //Fallback for other error types
    @ExceptionHandler(Exception.class)
    public ResponseEntity<ErrorResponse> handleGenericException(Exception ex){
        ErrorResponse error = new ErrorResponse("Internal Server Error", ex.getMessage());
        return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(error);
    }

}
