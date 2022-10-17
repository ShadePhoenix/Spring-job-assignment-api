package com.work.jobassignments.exceptions;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.ResponseStatus;

@ControllerAdvice
public class TempNotFoundAdvice {
    @ResponseBody
    @ExceptionHandler(TempNotFoundException.class)
    @ResponseStatus(HttpStatus.NOT_FOUND)
    String tempNotFoundHandler(TempNotFoundException ex) {
        return ex.getMessage();
    }
}
