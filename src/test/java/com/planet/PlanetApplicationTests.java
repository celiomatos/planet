package com.planet;

import io.cucumber.junit.Cucumber;
import io.cucumber.junit.CucumberOptions;
import org.junit.runner.RunWith;

@RunWith(Cucumber.class)
@CucumberOptions(features = "classpath:features", glue = {"com.planet.steps"})
//@ActiveProfiles(value = "test")
public class PlanetApplicationTests {
}
