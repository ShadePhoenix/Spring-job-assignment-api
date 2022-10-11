package com.work.jobassignments.jobs;

import java.time.LocalDate;

import javax.validation.constraints.Future;
import javax.validation.constraints.FutureOrPresent;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.PositiveOrZero;

import org.springframework.lang.Nullable;

public class JobCreateDTO {
    @NotBlank
    String name;

    @NotNull
    @FutureOrPresent
    LocalDate startDate;

    @NotNull
    @Future
    LocalDate endDate;

    @Nullable
    @PositiveOrZero
    Long tempId = null;

    public JobCreateDTO(@NotBlank String name, @NotNull @FutureOrPresent LocalDate startDate,
            @NotNull @Future LocalDate endDate, @Nullable @PositiveOrZero Long tempId) {
        super();
        this.name = name;
        this.startDate = startDate;
        this.endDate = endDate;
        this.tempId = tempId;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public LocalDate getStartDate() {
        return this.startDate;
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
