package org.example.hillelautomation;

import org.testng.annotations.Test;
import io.restassured.RestAssured;
import static io.restassured.RestAssured.*;
import static org.hamcrest.Matchers.*;

public class APITest {
    @Test
    public void testListUsers() {
        public void testListUsers () {
            RestAssured.baseURI = "https://reqres.in/api";
            given()
                    .when()
                    .get("/users")
                    .then()
                    .statusCode(200)
                    .body("data.size()", is(6));
        }

        @Test
        public void testSingleUser () {
            RestAssured.baseURI = "https://reqres.in/api";
            given()
                    .when()
                    .get("/users/2")
                    .then()
                    .statusCode(200)
                    .body("data.first_name", equalTo("Janet"))
                    .body("data.last_name", equalTo("Weaver"))
                    .body("data.email", equalTo("janet.weaver@reqres.in"));
        }

        @Test
        public void testCreateUser () {
            RestAssured.baseURI = "https://reqres.in/api";
            String requestBody = "{\"name\": \"morpheus\", \"job\": \"leader\"}";
            given()
                    .body(requestBody)
                    .when()
                    .post("/users")
                    .then()
                    .statusCode(201)
                    .body("name", equalTo("morpheus"))
                    .body("job", equalTo("leader"));
        }
    }
}
