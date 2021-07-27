package com.planet.bdd;

import com.planet.PlanetApplication;
import io.cucumber.spring.CucumberContextConfiguration;
import lombok.extern.slf4j.Slf4j;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.context.SpringBootTest.WebEnvironment;

@Slf4j
@CucumberContextConfiguration
@SpringBootTest(classes = PlanetApplication.class, webEnvironment = WebEnvironment.DEFINED_PORT)
public class CucumberSpringConfiguration {
}
