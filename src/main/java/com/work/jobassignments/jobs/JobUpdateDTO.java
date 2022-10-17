package com.work.jobassignments.jobs;

import java.time.LocalDate;

import javax.validation.constraints.Future;
import javax.validation.constraints.FutureOrPresent;
import javax.validation.constraints.PositiveOrZero;

public class JobUpdateDTO {
    private String name;

    @FutureOrPresent
    private LocalDate startDate;

    @Future
    private LocalDate endDate;

    @PositiveOrZero
    private Long tempId;

    public JobUpdateDTO(String name, @FutureOrPresent LocalDate startDate, @Future LocalDate endDate,
            @PositiveOrZero Long tempId) {
        super();
        this.name = name;
        this.startDate = startDate;
        this.endDate = endDate;
        this.tempId = tempId;
    }

    public String getName() {
        return this.name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public LocalDate getStartDate() {
        return startDate;
    }

    public void setStartDate(LocalDate date) {
        this.startDate = date;
    }

    public LocalDate getEndDate() {
        return endDate;
    }

    public void setEndDate(LocalDate date) {
        this.endDate = date;
    }

    public Long getTempId() {
        return tempId;
    }

    public void setTempId(Long tempId) {
        this.tempId = tempId;
    }
}
