package com.work.jobassignments.jobs;

import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
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

    @PostMapping
    public ResponseEntity<Job> create(@Valid @RequestBody JobCreateDTO data) {
        // if (data.getEndDate().before(data.getStartDate()))
        // return new ResponseEntity<>(null, HttpStatus.BAD_REQUEST);
        Job createdJob = this.service.create(data);
        return new ResponseEntity<>(createdJob, HttpStatus.CREATED);
    }
}
