package com.planet.bdd.steps;

import com.planet.bdd.RestAssuredExtension;
import com.planet.domain.Job;
import com.planet.dto.JobDTO;
import io.cucumber.datatable.DataTable;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.restassured.response.Response;
import io.restassured.response.ResponseOptions;
import org.junit.Assert;

public class JobControllerSteps {

    public static ResponseOptions<Response> response;

    @Given("Post no endpoint job")
    public void postNoEndpointJob(DataTable dataTable) {
//        var rows = dataTable.asLists(String.class);
        var rows = dataTable.asMaps(String.class, String.class);
        rows.forEach(t -> System.out.println("titulo " + t.get("title") + " < min > " + t.get("minSalary") + " < max > " + t.get("maxSalary")));

        var t = rows.get(0);

        var dto = JobDTO.builder()
                .id("54759eb3c090d83494e2d809")
                .title(t.get("title").toString())
                .minSalary(Integer.parseInt(t.get("minSalary").toString()))
                .maxSalary(Integer.parseInt(t.get("maxSalary").toString()))
                .build();
        response = RestAssuredExtension.postOps("job", dto);
    }

    @Then("Obtenho o id do job")
    public void obtenhoOIdDoJob() {
        Assert.assertEquals(200, response.statusCode());
    }

    @Given("Get no endpoint job")
    public void get_no_endpoint_job() {
        response = RestAssuredExtension.getOps("job");
    }

    @Then("Obtem todos os registros de jobs")
    public void obtem_todos_os_registros_de_jobs() {
        var jobs = response.getBody().jsonPath().getList("", Job.class);
        jobs.forEach(j -> System.out.println(">>>>>>> " + j.getTitle() + " <<< " + j.getId()));
        Assert.assertEquals(1, jobs.size());
    }
}
