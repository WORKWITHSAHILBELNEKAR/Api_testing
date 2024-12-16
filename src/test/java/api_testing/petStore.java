package api_testing;

import io.restassured.response.Response;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.io.File;

import static io.restassured.RestAssured.given;

public class petStore {

    @Test
    public void createUser(){
       Response res =  given()
                .header("accept","application/json")
                .header("Content-Type","application/json")
                .body("{\n" +
                        "  \"id\": 1,\n" +
                        "  \"username\": \"SSB\",\n" +
                        "  \"firstName\": \"Sahil\",\n" +
                        "  \"lastName\": \"Belnekar\",\n" +
                        "  \"email\": \"sahilsbelnekar2002@gmail.com\",\n" +
                        "  \"password\": \"sahil@123456\",\n" +
                        "  \"phone\": \"9892605281\",\n" +
                        "  \"userStatus\": 0\n" +
                        "}")
                .when()
                .post("https://petstore.swagger.io/v2/user\n");
       res.prettyPrint();
//          res.then().statusCode(200);
        Assert.assertEquals(res.statusCode(),200);

    }

    @Test
    public void createWithArray(){
        Response res = given()
                .accept("application/json")
                .contentType("application/json")
                .when()
                .body("[\n" +
                        "  {\n" +
                        "    \"id\": 2,\n" +
                        "    \"username\": \"rchavan\",\n" +
                        "    \"firstName\": \"Ramesh\",\n" +
                        "    \"lastName\": \"Chavan\",\n" +
                        "    \"email\": \"rameshchavan@gmail.com\",\n" +
                        "    \"password\": \"Password2\",\n" +
                        "    \"phone\": \"1234567890\",\n" +
                        "    \"userStatus\": 0\n" +
                        "  },\n" +
                        "{\n" +
                        "    \"id\": 3,\n" +
                        "    \"username\": \"vikashjd\",\n" +
                        "    \"firstName\": \"Vikas\",\n" +
                        "    \"lastName\": \"Jadhav\",\n" +
                        "    \"email\": \"vikjadhav@gmail.com\",\n" +
                        "    \"password\": \"Password3\",\n" +
                        "    \"phone\": \"2345678901\",\n" +
                        "    \"userStatus\": 0\n" +
                        "  }\n" +
                        "]")
                .post("https://petstore.swagger.io/v2/user/createWithArray");
        res.then().assertThat().statusCode(200);
        res.prettyPrint();
    }

    @Test
    public void createWithList(){
        Response res = given()
                .accept("application/json")
                .contentType("application/json")
                .when()
                .body("[\n" +
                        "  {\n" +
                        "    \"id\": 4,\n" +
                        "    \"username\": \"gopibahu\",\n" +
                        "    \"firstName\": \"Gopi\",\n" +
                        "    \"lastName\": \"Gujju\",\n" +
                        "    \"email\": \"gopirizz@gmail.com\",\n" +
                        "    \"password\": \"Password4\",\n" +
                        "    \"phone\": \"9876543210\",\n" +
                        "    \"userStatus\": 0\n" +
                        "  },\n" +
                        "{\n" +
                        "    \"id\": 5,\n" +
                        "    \"username\": \"rakeshah\",\n" +
                        "    \"firstName\": \"Rakesh\",\n" +
                        "    \"lastName\": \"Shah\",\n" +
                        "    \"email\": \"rakeshah@gmail.com\",\n" +
                        "    \"password\": \"Password5\",\n" +
                        "    \"phone\": \"7894561230\",\n" +
                        "    \"userStatus\": 0\n" +
                        "  }\n" +
                        "]")
                .post("https://petstore.swagger.io/v2/user/createWithList");
        res.then().assertThat().statusCode(200);
        res.prettyPrint();
    }
    @Test(dependsOnMethods = "createUser")
    public void getUser(){
        Response res = given()
                .accept("application/json")
                .contentType("application/json")
                .when()
                .get("https://petstore.swagger.io/v2/user/SSB");
        res.then().assertThat().statusCode(200);
        res.prettyPrint();

    }

    @Test
    public void userLogin(){
        Response res = given()
                .accept("application/json")
                .contentType("application/json")
                .when()
                .get("https://petstore.swagger.io/v2/user/SSB");
        res.then().assertThat().statusCode(200);
        res.prettyPrint();
    }


    @Test
    public void userUpdate(){
        Response res = given()
                .accept("application/json")
                .contentType("application/json")
                .when()
                .body("{\n" +
                        "  \"id\": 0,\n" +
                        "  \"username\": \"vikashjd\",\n" +
                        "  \"firstName\": \"Vikash\",\n" +
                        "  \"lastName\": \"Jadhao\",\n" +
                        "  \"email\": \"vikashjadhao@gmail.com\",\n" +
                        "  \"password\": \"Password12\",\n" +
                        "  \"phone\": \"877855412360\",\n" +
                        "  \"userStatus\": 0\n" +
                        "}")
                .put("https://petstore.swagger.io/v2/user/vikashjd");
        res.then().assertThat().statusCode(200);
        res.prettyPrint();
    }

    @Test
    public void placeOrder(){
        Response res = given()
                .accept("application/json")
                .contentType("application/json")
                .when()
                .body("{\n" +
                        "  \"id\": 1,\n" +
                        "  \"petId\": 1,\n" +
                        "  \"quantity\": 1,\n" +
                        "  \"shipDate\": \"2024-11-26T07:59:16.500Z\",\n" +
                        "  \"status\": \"placed\",\n" +
                        "  \"complete\": true\n" +
                        "}")
                .post("https://petstore.swagger.io/v2/store/order");
        res.then().assertThat().statusCode(200);
        res.prettyPrint();
    }

    @Test
    public void getInventory(){
        Response res = given()
                .accept("application/json")
                .contentType("application/json")
                .when()
                .get("https://petstore.swagger.io/v2/store/inventory");
        res.then().assertThat().statusCode(200);
        res.prettyPrint();

    }
    @Test(dependsOnMethods = "placeOrder")
    public void orderById(){
        Response res = given()
                .accept("application/json")
                .contentType("application/json")
                .when()
                .get("https://petstore.swagger.io/v2/store/order/1");
        res.then().assertThat().statusCode(200);
        res.prettyPrint();
    }

    @Test(dependsOnMethods = "orderById")
    public void deleteOrderById(){
        Response res = given()
                .accept("application/json")
                .contentType("application/json")
                .when()
                .delete("https://petstore.swagger.io/v2/store/order/1");
        res.then().assertThat().statusCode(200);
        res.prettyPrint();
    }

    @Test
    public void addPet(){
        Response res = given()
                .accept("application/json")
                .contentType("application/json")
                .when()
                .body("{\n" +
                        "  \"id\": 2,\n" +
                        "  \"category\": {\n" +
                        "    \"id\": 2,\n" +
                        "    \"name\": \"American Eskimo Dog\"\n" +
                        "  },\n" +
                        "  \"name\": \"doggie\",\n" +
                        "  \"photoUrls\": [\n" +
                        "    \"https://s3.amazonaws.com/cdn-origin-etr.akc.org/wp-content/uploads/2017/11/12155349/American-Eskimo-Dog-illustration.jpg\"\n" +
                        "  ],\n" +
                        "  \"tags\": [\n" +
                        "    {\n" +
                        "      \"id\": 1,\n" +
                        "      \"name\": \"American\"\n" +
                        "    }\n" +
                        "  ],\n" +
                        "  \"status\": \"available\"\n" +
                        "}")
                .post("https://petstore.swagger.io/v2/pet");
        res.then().assertThat().statusCode(200);
        res.prettyPrint();
    }

    @Test
    public void uploadPetImage(){
        File file = new File("C:\\Users\\sahil\\OneDrive\\Desktop\\4882-emo-pfpsgg.gif");
        Response res = given()
                .accept("application/json")
                .contentType("multipart/form-data")
                .multiPart(file)
                .when()
                .post("https://petstore.swagger.io/v2/pet/1/uploadImage");
        res.then().assertThat().statusCode(200);
        res.prettyPrint();
    }

    @Test
    public void findPetById(){
        Response res = given()
                .accept("application/json")
                .when()
                .get("https://petstore.swagger.io/v2/pet/2");
        res.then().assertThat().statusCode(200);
        res.prettyPrint();
    }

    @Test
    public void findPetByStatus(){
        Response res = given()
                .accept("application/json")
                .when()
                .get("https://petstore.swagger.io/v2/pet/findByStatus?status=available");
        res.then().assertThat().statusCode(200);
        res.prettyPrint();
    }

    @Test
    public void updatePet(){
        Response res = given()
                .accept("application/json")
                .contentType("application/json")
                .when()
                .body("{\n" +
                        "  \"id\": 2,\n" +
                        "  \"category\": {\n" +
                        "    \"id\": 2,\n" +
                        "    \"name\": \"Hushkey\"\n" +
                        "  },\n" +
                        "  \"name\": \"doggo\",\n" +
                        "  \"photoUrls\": [\n" +
                        "    \"none\"\n" +
                        "  ],\n" +
                        "  \"tags\": [\n" +
                        "    {\n" +
                        "      \"id\": 1,\n" +
                        "      \"name\": \"Indian\"\n" +
                        "    }\n" +
                        "  ],\n" +
                        "  \"status\": \"sold\"\n" +
                        "}")
                .put("https://petstore.swagger.io/v2/pet");
        res.then().assertThat().statusCode(200);
        res.prettyPrint();
    }

    @Test(dependsOnMethods = "findPetById")
    public void deletePet(){
        Response res = given()
                .accept("application/json")
                .when()
                .delete("https://petstore.swagger.io/v2/pet/2");
        res.then().assertThat().statusCode(200);
        res.prettyPrint();

    }

    @Test
    public void userLogout(){
        Response res = given()
                .accept("application/json")
                .contentType("application/json")
                .when()
                .get("https://petstore.swagger.io/v2/user/logout");
        res.then().assertThat().statusCode(200);
        res.prettyPrint();
    }

    @Test (priority = 8)
    public void deleteUser(){
        Response res = given()
                .accept("application/json")
                .contentType("application/json")
                .when()
                .delete("https://petstore.swagger.io/v2/user/vikashjd");
        res.then().assertThat().statusCode(200);
        res.prettyPrint();
    }


}
