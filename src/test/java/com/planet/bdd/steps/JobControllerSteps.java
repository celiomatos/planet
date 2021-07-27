package com.planet.bdd.steps;

import com.planet.RestAssuredExtension;
import com.planet.domain.Job;
import io.cucumber.datatable.DataTable;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.restassured.response.Response;
import io.restassured.response.ResponseOptions;
import org.junit.Assert;

import java.util.List;

public class JobControllerSteps {

    public static ResponseOptions<Response> response;

    @Given("Get no endpoint job")
    public void get_no_endpoint_job() {
        response = RestAssuredExtension.getOps("job");
    }

    @Then("Obtem todos os registros de jobs")
    public void obtem_todos_os_registros_de_jobs() {
        var jobs = response.getBody().jsonPath().getList("", Job.class);
        jobs.forEach(j -> System.out.println(">>>>>>> " + j.getTitle() + " <<< " + j.getId()));
        Assert.assertEquals(3, jobs.size());
    }


    @Given("Post no endpoint job")
    public void postNoEndpointJob(DataTable dataTable) {
//        var rows = dataTable.asLists(String.class);
        var rows = dataTable.asMaps(String.class, String.class);
        rows.forEach(t -> System.out.println(t.get("id") + " >> " + t.get("name")));
//        response = RestAssuredExtension.postOps("job", dataTable);
    }

    @Then("Obtenho o id do job")
    public void obtenhoOIdDoJob() {
    }
}
