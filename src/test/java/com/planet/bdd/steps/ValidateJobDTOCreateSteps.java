package com.planet.bdd.steps;

import com.planet.bdd.CucumberSpringConfiguration;
import io.cucumber.java.Before;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.junit.Assert;

import java.util.LinkedList;
import java.util.List;


public class ValidateJobDTOCreateSteps extends CucumberSpringConfiguration {

    private List<Integer> list;

    @Before
    public void setup() {
        list = new LinkedList<>();
    }

    @Given("um lance valido")
    public void dado_lance_valido() {
        list.add(1);
    }

    @When("propoe ao leilao")
    public void the_client_calls_job() {
        list.add(2);
    }

    @Then("o lance eh aceito")
    public void the_client_receives_status_code_of_200() {
        Assert.assertEquals(2, list.size());
    }

}
