package com.planet.controller;

import com.planet.domain.Planet;
import com.planet.service.PlanetService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

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
}
