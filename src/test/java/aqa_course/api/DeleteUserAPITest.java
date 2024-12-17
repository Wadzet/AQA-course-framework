package aqa_course.api;

import io.qameta.allure.Allure;
import io.qameta.allure.Attachment;
import io.restassured.RestAssured;
import io.restassured.response.Response;
import org.testng.Assert;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

public class DeleteUserAPITest {

    @BeforeClass
    public void setup() {
        RestAssured.baseURI = "http://localhost/api";
    }

    @Test(description = "Delete the created user via API")
    public void testDeleteUser() {
        int userId = CreateUserAPITest.userId;

        Allure.step("Sending DELETE request to remove user");
        Response response = RestAssured.given()
                .pathParam("id", userId)
                .log().all()
                .delete("/users/{id}");

        attachResponse(response.getBody().asString());

        Assert.assertEquals(response.statusCode(), 204, "User not deleted!");

        Allure.step("Verifying user is deleted");
        Response getResponse = RestAssured.given()
                .pathParam("id", userId)
                .get("/users/{id}");

        Assert.assertEquals(getResponse.statusCode(), 404, "User still exists!");
        Allure.step("User with ID: " + userId + " deleted successfully.");
    }

    @Attachment(value = "API Response", type = "application/json")
    public String attachResponse(String response) {
        return response;
    }
}
