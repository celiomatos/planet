package com.planet.controller;

import com.planet.domain.Job;
import com.planet.dto.JobDTO;
import com.planet.service.JobService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

import javax.validation.Valid;

@RestController
@RequestMapping("/job")
public class JobController {

    @Autowired
    private JobService service;

    @GetMapping()
    public Flux<Job> findAll() {
        return service.findAll();
    }

    @GetMapping("/{id}")
    public Mono<Job> findById(@PathVariable("id") String id) {
        return service.findById(id);
    }

    @PostMapping()
    public Mono<Job> create(@RequestBody @Valid JobDTO job) {
        return service.save(job);
    }

    @PutMapping("/{id}")
    public Mono<Job> update(@PathVariable("id") String id, @RequestBody @Valid JobDTO job) {
        job.setId(id);
        return service.save(job);
    }

    @DeleteMapping("/{id}")
    public Mono<Void> remove(@PathVariable("id") String id) {
        return service.remove(id);
    }
}
