package com.planet.service;

import com.planet.domain.Planet;
import com.planet.repository.PlanetRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class PlanetService {

    @Autowired
    private PlanetRepository repository;

    public List<Planet> findAll() {
        return repository.findAll();
    }

    public Planet save(Planet entity) {
        return repository.save(entity);
    }

    public void remove(Integer id) {
        repository.deleteById(id);
    }
}
