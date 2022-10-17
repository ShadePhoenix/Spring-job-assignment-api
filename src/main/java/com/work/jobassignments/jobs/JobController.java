package com.work.jobassignments.jobs;

import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PatchMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/jobs")
public class JobController {
    @Autowired
    private JobService service;

    @GetMapping
    public ResponseEntity<List<Job>> all() {
        List<Job> allJobs = this.service.all();
        return new ResponseEntity<>(allJobs, HttpStatus.OK);
    }

    @GetMapping(params = { "assigned" })
    public ResponseEntity<List<Job>> findAssigned(@RequestParam boolean assigned) {
        List<Job> JobsAssignedOrNot = this.service.assignedOrNot(assigned);
        return new ResponseEntity<>(JobsAssignedOrNot, HttpStatus.FOUND);
    }

    @PostMapping
    public ResponseEntity<Job> create(@Valid @RequestBody JobCreateDTO data) {
        Job createdJob = this.service.create(data);
        return new ResponseEntity<>(createdJob, HttpStatus.CREATED);
    }

    @PatchMapping("/{id}")
    public ResponseEntity<Job> update(@PathVariable Long id, @Valid @RequestBody JobUpdateDTO data) {
        Job updatedJob = this.service.update(id, data);
        return new ResponseEntity<Job>(updatedJob, HttpStatus.ACCEPTED);
    }

    @GetMapping("/{id}")
    public ResponseEntity<Job> findId(@PathVariable Long id) {
        Job job = this.service.one(id);
        return new ResponseEntity<>(job, HttpStatus.FOUND);
    }

}
