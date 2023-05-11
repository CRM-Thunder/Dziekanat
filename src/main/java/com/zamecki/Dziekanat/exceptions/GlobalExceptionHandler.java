package com.zamecki.Dziekanat.exceptions;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

@ControllerAdvice
public class GlobalExceptionHandler {
    @ExceptionHandler({StudentNotFoundException.class})
    public final ResponseEntity<ErrorResponse> handleStudentNotFoundException(StudentNotFoundException exception){
        return new ResponseEntity<>(exception.getErrorResponse(), exception.getHttpStatus());
    }
//TODO obsluzyc wyjatek ConstraintViolationException

}
