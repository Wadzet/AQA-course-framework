package aqa_course.api;

import io.qameta.allure.Allure;
import io.qameta.allure.Attachment;
import io.restassured.RestAssured;
import io.restassured.response.Response;
import org.testng.Assert;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

public class GetUserAPITest {

    @BeforeClass
    public void setup() {
        RestAssured.baseURI = "http://localhost/api";
    }

    @Test(description = "Validate the created user via API")
    public void testGetUser() {
        int userId = CreateUserAPITest.userId;

        Allure.step("Sending GET request to validate created user");
        Response response = RestAssured.given()
                .pathParam("id", userId)
                .log().all()
                .get("/users/{id}");

        attachResponse(response.getBody().asString());

        Assert.assertEquals(response.statusCode(), 200, "User not found!");
        Assert.assertEquals(response.jsonPath().getString("username"), "newUser", "Username mismatch!");

        Allure.step("User with ID: " + userId + " validated successfully.");
    }

    @Attachment(value = "API Response", type = "application/json")
    public String attachResponse(String response) {
        return response;
    }
}
