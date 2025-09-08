package com.stride.exception;


import java.time.LocalDateTime;

import java.time.LocalDateTime;

//Marks methods and tells class logic

//Represent Error Details


public class ErrorResponse {

    private String error; //Error type
    private String message; //Error details
    private LocalDateTime timestamp; //When the error happened

    //Constructor
    public ErrorResponse(String error, String message){
        this.error = error;
        this.message = message;
        this.timestamp = LocalDateTime.now();
    }

    //Getters
    public String getError(){
        return error;
    }
    public String getMessage(){
        return message;
    }
    public LocalDateTime getTimestamp(){
        return timestamp;
    }


}
