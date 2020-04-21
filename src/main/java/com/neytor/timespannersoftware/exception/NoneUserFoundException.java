package com.neytor.timespannersoftware.exception;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(HttpStatus.NOT_FOUND)
public class NoneUserFoundException extends RuntimeException{

    public NoneUserFoundException(String message) {
        super(message);
    }

    public NoneUserFoundException(String message, Throwable cause) {
        super(message, cause);
    }
}
