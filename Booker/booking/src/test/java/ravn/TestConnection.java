package ravn;

import static io.restassured.RestAssured.given;

import org.testng.annotations.Test;

public class TestConnection {
    @Test(priority = 0)
    public void getBookingResponse()
    {
        String endpoint = "https://restful-booker.herokuapp.com";
        var response =  given().
                        when().
                        get(endpoint).
                        then().
                        statusCode(200);
        response.log().body();
    }
}
