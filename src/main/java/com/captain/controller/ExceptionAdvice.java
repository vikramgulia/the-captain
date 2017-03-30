package com.captain.controller;

import com.captain.model.Status;
import com.captain.model.trip.Itinerary;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

@ControllerAdvice
@Slf4j
public class ExceptionAdvice {
    @ExceptionHandler(value = {Exception.class})
    public ResponseEntity<Itinerary> handleInvalidInput(Exception e) {
        String message = e.getMessage();
        log.error("Exception occurred while processing request: {}", message);
        return ResponseEntity
                .status(HttpStatus.INTERNAL_SERVER_ERROR)
                .body(Itinerary.builder()
                        ._status(Status.builder()
                                .code("-1")
                                .message(message)
                                .build())
                        .build());
    }
}
