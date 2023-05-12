package com.zamecki.Dziekanat.exceptions;
import com.zamecki.Dziekanat.exceptions.errorresponses.MultipleArgumentsErrorResponse;
import com.zamecki.Dziekanat.exceptions.errorresponses.SingleArgumentErrorResponse;
import jakarta.validation.ConstraintViolationException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

import java.util.*;

@ControllerAdvice
public class GlobalExceptionHandler {
    @ExceptionHandler({StudentNotFoundException.class})
    public final ResponseEntity<SingleArgumentErrorResponse> handleStudentNotFoundException(StudentNotFoundException exception){
        return new ResponseEntity<>(exception.getErrorResponse(), exception.getHttpStatus());
    }
    @ExceptionHandler({ConstraintViolationException.class})
    public final ResponseEntity<SingleArgumentErrorResponse> handleConstraintViolationException(ConstraintViolationException exception){
        String[] errMessage=exception.getMessage().split(": ");
        return new ResponseEntity<>(SingleArgumentErrorResponse.builder().timestamp(new Date().toString()).message(errMessage[1]).status(String.valueOf(HttpStatus.BAD_REQUEST)).errorCode(HttpStatus.BAD_REQUEST.value()).build(), HttpStatus.BAD_REQUEST);
    }
    @ExceptionHandler({MethodArgumentNotValidException.class})
    public final ResponseEntity<MultipleArgumentsErrorResponse> handleMethodArgumentNotValidException(MethodArgumentNotValidException exception){
        List<String> errors=exception.getBindingResult().getFieldErrors().stream().map(FieldError::getDefaultMessage).toList();
        return new ResponseEntity<>(MultipleArgumentsErrorResponse.builder().timestamp(new Date().toString()).errorMessages(errors).status(String.valueOf(HttpStatus.BAD_REQUEST)).errorCode(HttpStatus.BAD_REQUEST.value()).build(), HttpStatus.BAD_REQUEST);
    }


}
