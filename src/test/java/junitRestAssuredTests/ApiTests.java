package junitRestAssuredTests;

import io.restassured.RestAssured;
import io.restassured.response.Response;
import org.hamcrest.Matchers;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import io.restassured.RestAssured.*;
import io.restassured.matcher.RestAssuredMatchers.*;
import org.hamcrest.Matchers.*;
import  io.restassured.module.jsv.JsonSchemaValidator.*;


public class ApiTests {
    static Response response;

    @Test
    public void checkStatusCode() {
        System.out.println("Checking status code... - " + Thread.currentThread().getName());
        response.then()
                .statusCode(200);
    }

    @Test
    public void checkTotal() {
        System.out.println("Checking total... - " + Thread.currentThread().getName());
        response.then().body("total", Matchers.equalTo(98));
    }

    @Test
    public void checkBreeds() {
        System.out.println("Checking breeds... - " + Thread.currentThread().getName());
        response.then().body("data.breed", Matchers.hasItems("Abyssinian", "Chausie", "Brazilian Shorthair"));
    }

    @BeforeAll
    public static void globalSetup() {
        System.out.println("Global setup - " + Thread.currentThread().getName());
        response = RestAssured
                .given().baseUri("https://catfact.ninja/")
                .when().get("breeds")
                .andReturn();

        response.body().prettyPrint();
    }
}
