package com.neytor.timespannersoftware.exception;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

import java.text.ParseException;

@ControllerAdvice
public class RestExceptionHandler extends ResponseEntityExceptionHandler {

    @ExceptionHandler(EntityNotFoundException.class)
    public ResponseEntity<Object> handleEntityNotFoundException(EntityNotFoundException exception){
        return buildResponseEntity( new ApiError(HttpStatus.NOT_FOUND,exception.getMessage(),exception));
    }


    @ExceptionHandler(ParseException.class)
    public ResponseEntity<Object> handleParseException(ParseException exception){
        return buildResponseEntity( new ApiError(HttpStatus.NOT_ACCEPTABLE,exception.getMessage(),exception));
    }

    private ResponseEntity<Object> buildResponseEntity(ApiError apiError) {
        return ResponseEntity.status(apiError.getStatus()).body(apiError);

    }
}
