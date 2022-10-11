package com.work.jobassignments.jobs;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.work.jobassignments.temps.Temp;

public interface JobRepository extends JpaRepository<Job, Long> {
    List<Job> findByTemp(Temp temp);

    List<Job> findByAssigned(boolean assigned);
}
