package com.planet.service;

import com.planet.domain.Job;
import com.planet.dto.JobDTO;
import com.planet.repository.JobRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class JobService {

    @Autowired
    private JobRepository repository;

    public List<JobDTO> findAll() {
        return repository.findAll().stream().map(this::mToD).collect(Collectors.toList());
    }

    public JobDTO save(JobDTO entity) {
        return mToD(repository.save(dToM(entity)));
    }

    public void remove(String id) {
        repository.deleteById(id);
    }


    public Job dToM(JobDTO dto) {
        return Job.builder()
                .id(dto.getId())
                .title(dto.getTitle())
                .minSalary(dto.getMinSalary())
                .maxSalary(dto.getMaxSalary())
                .build();
    }

    public JobDTO mToD(Job entity) {
        return JobDTO.builder()
                .id(entity.getId())
                .title(entity.getTitle())
                .minSalary(entity.getMinSalary())
                .maxSalary(entity.getMaxSalary())
                .build();
    }
}
