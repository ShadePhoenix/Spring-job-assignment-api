package com.work.jobassignments.jobs;

import java.time.LocalDate;
import java.util.List;
import java.util.Optional;
import java.util.stream.Stream;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.lang.NonNull;
import org.springframework.stereotype.Service;

import com.work.jobassignments.exceptions.JobDateNotValidException;
import com.work.jobassignments.exceptions.JobNotFoundException;
import com.work.jobassignments.exceptions.TempNotFoundException;
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

        if (data.getStartDate().isAfter(data.getEndDate()))
            throw new JobDateNotValidException();

        Temp temp = null;
        if (data.getTempId() != null) {
            temp = tempRepository.findById(data.getTempId())
                    .orElseThrow(() -> new TempNotFoundException(data.getTempId()));
            List<Job> tempJobs = this.repository.findByTempIs(temp.getId());
            boolean validDate = tempJobs.stream().allMatch((Job job) -> {
                boolean before = data.getStartDate().isBefore(job.getStartDate())
                        && data.getEndDate().isBefore(job.getStartDate());
                boolean after = data.getStartDate().isAfter(job.getEndDate())
                        && data.getEndDate().isAfter(job.getEndDate());
                return before || after;
            });
            if (!validDate)
                throw new JobDateNotValidException("Job dates conflict with the Temps currently assigned Job");
        }

        Job newJob = temp != null ? new Job(cName, data.getStartDate(), data.getEndDate(), temp)
                : new Job(cName, data.getStartDate(), data.getEndDate());
        this.repository.save(newJob);
        return newJob;
    }

    public Job update(Long id, JobUpdateDTO data) {
        Job updateJob = one(id);
        if (!data.getName().isEmpty())
            updateJob.setName(data.getName());
        if (data.getStartDate() != null)
            updateJob.setStartDate(data.getStartDate());
        if (data.getEndDate() != null)
            updateJob.setEndDate(data.getEndDate());
        if (data.getTempId() != null) {
            Temp temp = this.tempRepository.findById(data.getTempId()).orElseThrow(() -> new TempNotFoundException(id));
            List<Job> tempJobs = this.repository.findByTempIs(temp.getId());
            boolean validDate = tempJobs.stream().allMatch((Job job) -> {
                boolean before = data.getStartDate().isBefore(job.getStartDate())
                        && data.getEndDate().isBefore(job.getStartDate());
                boolean after = data.getStartDate().isAfter(job.getEndDate())
                        && data.getEndDate().isAfter(job.getEndDate());
                return before || after;
            });
            if (updateJob.getStartDate().isAfter(updateJob.getEndDate()))
                throw new JobDateNotValidException();
            if (!validDate)
                throw new JobDateNotValidException("Job dates conflict with the Temps currently assigned Job");
            updateJob.setTemp(temp);
        }
        this.repository.save(updateJob);
        return updateJob;
    }

    public List<Job> all() {
        return this.repository.findAll();
    }

    public List<Job> assignedOrNot(boolean assigned) {
        if (assigned)
            return this.repository.findByTempNotNull();
        return this.repository.findByTempNull();
    }

    public Job one(Long id) {
        return this.repository.findById(id).orElseThrow(() -> new JobNotFoundException(id));
    }
}
