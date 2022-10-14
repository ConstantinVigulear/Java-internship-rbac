package com.vigulear.rbac.exception_handling;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

@ControllerAdvice
public class GlobalExceptionHandler {

    @ExceptionHandler
    public ResponseEntity<IncorrectData> handleException (Exception exception) {
        IncorrectData data = new IncorrectData();
        data.setInfo(exception.getMessage());

       if (exception instanceof NoSuchException) {
           return new ResponseEntity<>(data, HttpStatus.NOT_FOUND);
       } else {
           return new ResponseEntity<>(data, HttpStatus.BAD_REQUEST);
       }
    }
}
