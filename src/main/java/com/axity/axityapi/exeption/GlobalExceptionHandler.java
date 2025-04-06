package com.axity.axityapi.exeption;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

@RestControllerAdvice
public class GlobalExceptionHandler {
    private static final Logger LOGGER = LoggerFactory.getLogger(GlobalExceptionHandler.class);

    @ExceptionHandler(GeneralException.class)
    public ResponseEntity<ProblemDetails> handleGeneralException(GeneralException e) {

        LOGGER.error("Exception type detected: {}", e.getMessage());

        ProblemDetails problemDetails = new ProblemDetails(
                e.getType(),
                e.getMessage(),
                e.getStatus(),
                e.getTimestamp(),
                e.getDetail()
        );

        return new ResponseEntity<>(problemDetails, HttpStatus.BAD_REQUEST);
    }

}
