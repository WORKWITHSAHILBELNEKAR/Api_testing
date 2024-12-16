package api_testing;

import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;
import io.restassured.response.Response;
import io.restassured.RestAssured;
import static io.restassured.RestAssured.given;

import org.testng.Assert;

public class json_server {

    @BeforeClass
    public void setup() {
        RestAssured.baseURI = "http://localhost:3000"; // Set base URI globally
    }

    @Test(priority = 1)
    public void GetPostsTest() {
        Response response = given()
                .header("Content-Type", "application/json")
                .when()
                .get("/posts")
                .then()
                .extract().response();

        System.out.println("Response Body: " + response.getBody().asString());
        Assert.assertEquals(response.getStatusCode(), 200, "Status code is not 200");
        Assert.assertTrue(response.getBody().asString().contains("id"), "Response doesn't contain 'id' field");
    }

    @Test(priority = 2)
    public void CreatePostTest() {
        String requestBody = "{\n" +
                "    \"id\": \"2\",\n" +
                "    \"title\": \"Software testing\",\n" +
                "    \"author\": \"Ashwini\"\n" +
                "}";

        Response response = given()
                .header("Content-Type", "application/json")
                .body(requestBody)
                .when()
                .post("/posts")
                .then()
                .extract().response();

        System.out.println("Response Body: " + response.getBody().asString());
        Assert.assertEquals(response.getStatusCode(), 201, "Status code is not 201");
        Assert.assertTrue(response.getBody().asString().contains("Ashwini"), "Response doesn't contain 'Ashwini'");
    }

    @Test(priority = 3)
    public void UpdatePostTest() {
        String requestBody = "{\n" +
                "    \"id\": \"1\",\n" +
                "    \"title\": \"Automation testing\",\n" +
                "    \"author\": \"Aditi\"\n" +
                "}";

        Response response = given()
                .header("Content-Type", "application/json")
                .body(requestBody)
                .when()
                .put("/posts/1");

        System.out.println("Response Body: " + response.getBody().asString());
        Assert.assertEquals(response.getStatusCode(), 200, "Failed to update the post");
    }

    @Test(priority = 4)
    public void DeletePostTest() {
        Response response = given()
                .header("Content-Type", "application/json")
                .when()
                .delete("/posts/2");

        System.out.println("Response Body: " + response.getBody().asString());
        Assert.assertEquals(response.getStatusCode(), 200, "Failed to delete the post");
    }

    @Test(priority = 5)
    public void GetCommentsTest() {
        Response response = given()
                .header("Content-Type", "application/json")
                .when()
                .get("/comments")
                .then()
                .extract().response();

        System.out.println("Response Body: " + response.getBody().asString());
        Assert.assertEquals(response.getStatusCode(), 200, "Status code is not 200");
        Assert.assertTrue(response.getBody().asString().contains("id"), "Response doesn't contain 'id' field");
    }

    @Test(priority = 6)
    public void CreateCommentTest() {
        String requestBody = "{\n" +
                "    \"id\": \"4\",\n" +
                "    \"body\": \"Well work\",\n" +
                "    \"postId\": 18\n" +
                "}";

        Response response = given()
                .header("Content-Type", "application/json")
                .body(requestBody)
                .when()
                .post("/comments")
                .then()
                .extract().response();

        System.out.println("Response Body: " + response.getBody().asString());
        Assert.assertEquals(response.getStatusCode(), 201, "Status code is not 201");
    }

    @Test(priority = 7)
    public void UpdateCommentTest() {
        String requestBody = "{\n" +
                "    \"id\": \"2\",\n" +
                "    \"body\": \"Comment here\",\n" +
                "    \"postId\": 2\n" +
                "}";

        Response response = given()
                .header("Content-Type", "application/json")
                .body(requestBody)
                .when()
                .put("/comments/2");

        System.out.println("Response Body: " + response.getBody().asString());
        Assert.assertEquals(response.getStatusCode(), 200, "Failed to update the comment");
    }

    @Test(priority = 8)
    public void DeleteCommentTest() {
        Response response = given()
                .header("Content-Type", "application/json")
                .when()
                .delete("/comments/4");

        System.out.println("Response Body: " + response.getBody().asString());
        Assert.assertEquals(response.getStatusCode(), 200, "Failed to delete the comment");
    }

    @Test(priority = 9)
    public void GetProfileTest() {
        Response response = given()
                .header("Content-Type", "application/json")
                .when()
                .get("/profile");

        System.out.println("Response Body: " + response.getBody().asString());
        Assert.assertEquals(response.getStatusCode(), 200, "Failed to get profile");
    }

    @Test(priority = 10)
    public void CreateProfileTest() {
        String requestBody = "{\n" +
                "    \"id\": 1,\n" +
                "    \"name\": \"Shraddha\",\n" +
                "    \"roll no\": 10,\n" +
                "    \"branch\": \"Tech eng\"\n" +
                "}";

        Response response = given()
                .header("Content-Type", "application/json")
                .body(requestBody)
                .when()
                .post("/profile");

        System.out.println("Response Body: " + response.getBody().asString());
        Assert.assertEquals(response.getStatusCode(), 200, "Failed to create profile");
    }

    @Test(priority = 11)
    public void UpdateProfileTest() {
        String requestBody = "{\n" +
                "    \"id\": 3,\n" +
                "    \"name\": \"Shraddha\",\n" +
                "    \"roll no\": 104,\n" +
                "    \"branch\": \"IT eng\"\n" +
                "}";

        Response response = given()
                .header("Content-Type", "application/json")
                .body(requestBody)
                .when()
                .put("/profile/3");

        System.out.println("Response Body: " + response.getBody().asString());
        Assert.assertEquals(response.getStatusCode(), 200, "Failed to update profile");
    }

    @Test(priority = 12)
    public void DeleteProfileTest() {
        Response response = given()
                .header("Content-Type", "application/json")
                .when()
                .delete("/profile/3");

        System.out.println("Response Body: " + response.getBody().asString());
        Assert.assertEquals(response.getStatusCode(), 200, "Failed to delete profile");
    }

}
