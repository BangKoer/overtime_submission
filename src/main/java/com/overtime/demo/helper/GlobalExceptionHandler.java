package com.overtime.demo.helper;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.BadCredentialsException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

@RestControllerAdvice 
public class GlobalExceptionHandler {
    // 1. Handles wrong email or password (Maps to 401 Unauthorized)
    @ExceptionHandler(BadCredentialsException.class)
    public ResponseEntity<Object> handleBadCredentials(BadCredentialsException ex) {
        return Response.generate(ex.getMessage(), HttpStatus.UNAUTHORIZED);
    }

    // 2. Handles missing validation or broken states (Maps to 400 Bad Request)
    @ExceptionHandler(IllegalStateException.class)
    public ResponseEntity<Object> handleIllegalState(IllegalStateException ex) {
        return Response.generate(ex.getMessage(), HttpStatus.BAD_REQUEST);
    }

    // 3. Optional fallback helper to catch unexpected runtime errors (Maps to 500 Internal Error)
    @ExceptionHandler(Exception.class)
    public ResponseEntity<Object> handleGeneralException(Exception ex) {
        return Response.generate("An unexpected system error occurred: " + ex.getMessage(), HttpStatus.INTERNAL_SERVER_ERROR);
    }
}
