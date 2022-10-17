package com.work.jobassignments.exceptions;

public class JobDateNotValidException extends RuntimeException {
    public JobDateNotValidException() {
        super("Start Date and End Date are not valid.");
    }

    public JobDateNotValidException(String reason) {
        super("Start Date and End Date are not valid.\nReason: " + reason);
    }
}
