package aqa_course.api;

import io.qameta.allure.Allure;
import io.qameta.allure.Attachment;
import io.restassured.RestAssured;
import io.restassured.http.ContentType;
import io.restassured.response.Response;
import org.testng.Assert;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

public class CreateUserAPITest {

    public static int userId;

    @BeforeClass
    public void setup() {
        RestAssured.baseURI = "http://localhost/api";
    }

    @Test(description = "Create a new user via API")
    public void testCreateUser() {
        String requestBody = "{ \"username\": \"newUser\", \"password\": \"password123\" }";

        Allure.step("Sending POST request to create a new user");
        Response response = RestAssured.given()
                .contentType(ContentType.JSON)
                .body(requestBody)
                .log().all()
                .post("/users");

        attachResponse(response.getBody().asString());

        Assert.assertEquals(response.statusCode(), 201, "User not created successfully!");
        userId = response.jsonPath().getInt("id");

        Allure.step("User created with ID: " + userId);
    }

    @Attachment(value = "API Response", type = "application/json")
    public String attachResponse(String response) {
        return response;
    }
}
