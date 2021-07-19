package com.planet.controller;

import com.planet.domain.Planet;
import com.planet.service.PlanetService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/planet")
public class PlanetController {

    @Autowired
    private PlanetService service;

    @GetMapping()
    public List<Planet> findAll() {
        return service.findAll();
    }

    @PostMapping()
    public Planet create(@RequestBody Planet planet) {
        return service.save(planet);
    }

    @PutMapping("/{id}")
    public Planet update(@PathVariable("id") Integer id, @RequestBody Planet planet) {
        planet.setId(id);
        return service.save(planet);
    }

    @DeleteMapping("/{id}")
    public void remove(@PathVariable("id") Integer id) {
        service.remove(id);
    }
}
