package com.planet.service;

import com.planet.domain.Job;
import com.planet.dto.JobDTO;
import com.planet.repository.JobRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

import java.util.zip.DataFormatException;

@Service
public class JobService {

    @Autowired
    private JobRepository repository;

    public Flux<Job> findAll() {
        return repository.findAll();
    }

    @Transactional
    public Mono<Job> save(JobDTO dto) {
        return repository.save(dToM(dto));
    }

    public Mono<Void> remove(String id) {
        return repository.deleteById(id);
    }

    public Mono<Job> findById(String id) {
        return repository.findById(id).onErrorMap(error -> new DataFormatException(""));

    }

    public Job dToM(JobDTO dto) {
        return Job.builder()
                .id(dto.getId())
                .title(dto.getTitle())
                .minSalary(dto.getMinSalary())
                .maxSalary(dto.getMaxSalary())
                .build();
    }

}
