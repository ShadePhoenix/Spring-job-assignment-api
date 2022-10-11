package com.work.jobassignments.jobs;

import java.util.List;
import java.util.Optional;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.work.jobassignments.temps.Temp;
import com.work.jobassignments.temps.TempRepository;

@Service
@Transactional
public class JobService {
    @Autowired
    private JobRepository repository;

    @Autowired
    private TempRepository tempRepository;

    public Job create(JobCreateDTO data) {
        Job newJob = new Job();
        newJob.setName(data.getName().trim());

        if (data.getTempId() != null) {
            Optional<Temp> temp = tempRepository.findById(data.getTempId());
            if (temp.isEmpty()) {
                // Throw exception since a temp could not be found.
            }
        }

        // Job newJob = new Job(cName, data.getStartDate(), data.getEndDate());
        this.repository.save(newJob);
        return newJob;
    }

    public List<Job> all() {
        return this.repository.findAll();
    }

    public Optional<Job> find(Long id) {
        return this.repository.findById(id);
    }
}
