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
        String cName = data.getName().trim();
        Optional<Temp> temp = tempRepository.findById(data.getTempId());

        Job newJob = temp.isPresent() ? new Job(cName, data.getStartDate(), data.getEndDate(), temp.get())
                : new Job(cName, data.getStartDate(), data.getEndDate());
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
