package com.planet.controller;

import com.planet.dto.JobDTO;
import com.planet.service.JobService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/job")
public class JobController {

    @Autowired
    private JobService service;

    @GetMapping()
    public List<JobDTO> findAll() {
        return service.findAll();
    }

    @PostMapping()
    public JobDTO create(@RequestBody JobDTO job) {
        return service.save(job);
    }

    @PutMapping("/{id}")
    public JobDTO update(@PathVariable("id") String id, @RequestBody JobDTO job) {
        job.setId(id);
        return service.save(job);
    }

    @DeleteMapping("/{id}")
    public void remove(@PathVariable("id") String id) {
        service.remove(id);
    }
}
