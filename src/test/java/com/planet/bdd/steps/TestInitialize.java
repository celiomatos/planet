package com.planet.bdd.steps;


import com.planet.RestAssuredExtension;
import io.cucumber.java.Before;

public class TestInitialize {

    @Before
    public void testSetup() {
        var restAssuredExtension = new RestAssuredExtension();
    }
}
