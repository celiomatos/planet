package com.planet.bdd.steps;

import com.planet.RestAssuredExtension;
import com.planet.domain.Job;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.restassured.response.Response;
import io.restassured.response.ResponseOptions;
import org.junit.Assert;

public class JobControllerSteps {

    public static ResponseOptions<Response> response;

    @Given("Get no endpoint job")
    public void get_no_endpoint_job() {
        response = RestAssuredExtension.getOps("/job");
    }

    @Then("Obtem todos os registros de jobs")
    public void obtem_todos_os_registros_de_jobs() {
        var jobs = response.getBody().jsonPath().getList("", Job.class);
        jobs.forEach(j -> System.out.println(">>>>>>> " + j.getTitle() + " <<< " + j.getId()));
        Assert.assertEquals(3, jobs.size());
    }
}
