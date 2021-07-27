package com.planet;

import io.restassured.RestAssured;
import io.restassured.builder.RequestSpecBuilder;
import io.restassured.http.ContentType;
import io.restassured.response.Response;
import io.restassured.response.ResponseOptions;
import io.restassured.specification.RequestSpecification;

import java.net.URI;
import java.net.URISyntaxException;

public class RestAssuredExtension {

    public static RequestSpecification request;

    public RestAssuredExtension() {
        request = RestAssured.given().spec(new RequestSpecBuilder()
                .setBaseUri("http://127.0.0.1:8080")
                .setContentType(ContentType.JSON)
                .build());
    }

    public static ResponseOptions<Response> getOps(String url) {
        try {
            return request.get(new URI(url));
        } catch (URISyntaxException e) {
            e.printStackTrace();
        }
        return null;
    }
}
