package com.zamecki.Dziekanat.exceptions;

import lombok.Getter;
import org.springframework.http.HttpStatus;

import java.util.Date;

public class StudentNotFoundException extends RuntimeException{
   @Getter
    private final HttpStatus httpStatus;
    public StudentNotFoundException(String message, HttpStatus httpStatus){
        super(message);
        this.httpStatus=httpStatus;
    }

    public ErrorResponse getErrorResponse(){
        return ErrorResponse.builder().timestamp(new Date().toString()).message(this.getMessage()).errorCode(httpStatus.value()).status(String.valueOf(httpStatus)).build();
    }
}
