package com.planet.repository;

import com.planet.domain.Job;
import org.springframework.data.repository.reactive.ReactiveCrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface JobRepository extends ReactiveCrudRepository<Job, String> {
}
