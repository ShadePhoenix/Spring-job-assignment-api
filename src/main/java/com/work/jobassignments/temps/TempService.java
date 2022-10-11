package com.work.jobassignments.temps;

import java.util.List;
import java.util.Optional;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
@Transactional
public class TempService {
    @Autowired
    private TempRepository repository;

    public Temp create(TempCreateDTO data) {
        String cFirst = data.getFirstName().trim();
        String cLast = data.getLastName().trim();
        Temp newTemp = new Temp(cFirst, cLast);
        this.repository.save(newTemp);
        return newTemp;
    }

    public List<Temp> all() {
        return this.repository.findAll();
    }

    public Optional<Temp> find(Long id) {
        return this.repository.findById(id);
    }
}
