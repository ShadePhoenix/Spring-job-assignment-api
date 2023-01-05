package com.work.jobassignments.users;

import javax.validation.constraints.NotBlank;

public class UserCreateDTO {
    @NotBlank
    private String username;
    @NotBlank
    private String password;
    @NotBlank
    private String role;

    public UserCreateDTO(@NotBlank String username, @NotBlank String password, @NotBlank String role) {
        this.username = username;
        this.password = password;
        this.role = role;
    }

    public String getUsername() {
        return this.username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return this.password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getRole() {
        return this.role;
    }

    public void setRole(String role) {
        this.role = role;
    }
}
