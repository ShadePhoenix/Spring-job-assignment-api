package com.work.jobassignments.temps;

import java.util.Set;

import javax.persistence.*;

import com.fasterxml.jackson.annotation.JsonManagedReference;
import com.work.jobassignments.jobs.Job;

@Entity
@Table(name = "temps")
public class Temp {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    Long id;

    @Column
    String firstName;

    @Column
    String lastName;

    @OneToMany(mappedBy = "temp", fetch = FetchType.LAZY, cascade = CascadeType.ALL)
    @Column(nullable = true)
    @JsonManagedReference
    Set<Job> jobs;

    Temp() {
    }

    public Temp(String firstName, String lastName) {
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
