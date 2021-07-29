package com.planet.bdd;

import com.planet.dto.JobDTO;
import io.restassured.RestAssured;
import io.restassured.builder.RequestSpecBuilder;
import io.restassured.http.ContentType;
import io.restassured.response.Response;
import io.restassured.response.ResponseOptions;
import io.restassured.specification.RequestSpecification;

import java.net.URI;
import java.net.URISyntaxException;

import static io.restassured.RestAssured.given;

public class RestAssuredExtension {

    private static final String baseUrl = "http://127.0.0.1:8080/";
    public static RequestSpecification request;

    public RestAssuredExtension() {
        request = RestAssured.given().spec(new RequestSpecBuilder()
                .setBaseUri(baseUrl)
                .setContentType(ContentType.JSON)
                .build());
    }

    public static ResponseOptions<Response> getOps(String path) {
        try {
            return request.get(new URI(path));
        } catch (URISyntaxException e) {
            return null;
        }
    }

    public static ResponseOptions<Response> postOps(String path, JobDTO dto) {

        return given().contentType(ContentType.JSON)
                .with()
                .body(dto)
                .when()
                .post(baseUrl + path);
//                .then().statusCode(200);
//                .body("author", Is.is("ExecuteAutomation"));
    }
}
