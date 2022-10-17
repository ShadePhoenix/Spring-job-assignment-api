package com.work.jobassignments.exceptions;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.ResponseStatus;

@ControllerAdvice
public class JobDateNotValidAdvice {
    @ResponseBody
    @ExceptionHandler(JobDateNotValidException.class)
    @ResponseStatus(HttpStatus.BAD_REQUEST)
    String jobDateNotValid(JobDateNotValidException ex) {
        return ex.getMessage();
    }
}
