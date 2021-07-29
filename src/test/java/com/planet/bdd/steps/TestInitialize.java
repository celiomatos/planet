package com.planet.bdd.steps;


import com.planet.bdd.RestAssuredExtension;
import io.cucumber.java.Before;

public class TestInitialize {

    @Before
    public void testSetup() {
        new RestAssuredExtension();
    }
}
