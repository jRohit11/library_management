package com.project.library_management_system.exception;

import com.project.library_management_system.model.ErrorMessage;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

@ControllerAdvice
public class ExceptionHandlerGlobal {

    @ExceptionHandler(value = InvalidRequestException.class)
    public ResponseEntity<Object> invalidStudentInfo(InvalidRequestException invalidRequestException) {
        ErrorMessage errorMessage = ErrorMessage.builder()
                .message("Invalid Request Info")
                .status(HttpStatus.BAD_REQUEST.toString())
                .dateTime(System.currentTimeMillis())
                .build();
        return new ResponseEntity<>(errorMessage, HttpStatus.BAD_REQUEST);
    }
}
