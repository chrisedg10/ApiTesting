package ravn;

import org.testng.annotations.*;

import io.restassured.response.Response;
import static io.restassured.RestAssured.given;

/**
 * Unit test for simple App.
 */
public class GetResponse {
    @Test(priority = 1)
    public void getBooking() {
        String endpoint = "https://pokeapi.co/api/v2/berry/";

        System.out.println("\n\n*** GET RESPONSE ***\n");

        Response response = given().get(endpoint);
        String responseBody = response.getBody().asPrettyString();

        System.out.println(responseBody);
    }
}
