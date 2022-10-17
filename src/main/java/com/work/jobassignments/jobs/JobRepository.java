package com.work.jobassignments.jobs;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

public interface JobRepository extends JpaRepository<Job, Long> {
    List<Job> findByTempNull();

    List<Job> findByTempNotNull();

    List<Job> findByTempIs(Long id);
}
