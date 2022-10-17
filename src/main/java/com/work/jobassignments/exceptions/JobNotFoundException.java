package com.work.jobassignments.exceptions;

public class JobNotFoundException extends RuntimeException {
    public JobNotFoundException(Long id) {
        super("Could not find Job with id: " + id);
    }
}
