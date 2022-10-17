package com.work.jobassignments.exceptions;

public class TempNotFoundException extends RuntimeException {
    public TempNotFoundException(Long id) {
        super("Could not find Temp with id: " + id);
    }
}