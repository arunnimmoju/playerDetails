package com.cricket.playerDetails.Handler;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

@RestControllerAdvice
public class CustomExceptionHandler {

    @ExceptionHandler(PlayerNotFoundException.class)
    public ResponseEntity<ApiException> handlePlayerNotFoundException(PlayerNotFoundException ex) {
        ApiException apiException = new ApiException(404, "Not Found", ex.getMessage());
        return new ResponseEntity<>(apiException, HttpStatus.NOT_FOUND);
    }

    @ExceptionHandler(Exception.class)
    public ResponseEntity<ApiException> handleAllExceptions(Exception ex) {
        ApiException apiException = new ApiException(500, "Internal Server Error", ex.getMessage());
        return new ResponseEntity<>(apiException, HttpStatus.INTERNAL_SERVER_ERROR);
    }
}
