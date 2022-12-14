package com.work.jobassignments.temps;

import javax.validation.constraints.NotBlank;

public class TempCreateDTO {
    @NotBlank
    private String firstName;

    @NotBlank
    private String lastName;

    public TempCreateDTO(@NotBlank String firstName, @NotBlank String lastName) {
        this.firstName = firstName;
        this.lastName = lastName;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }
}
