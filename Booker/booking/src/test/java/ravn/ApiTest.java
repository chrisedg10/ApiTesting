package ravn;

import static io.restassured.RestAssured.given;

import org.testng.annotations.*;


/**
 * Unit test for simple App.
 */
public class ApiTest 
{
    
    /*@Test(priority = 0)
    public void getBookingResponse()
    {
        String endpoint = "https://restful-booker.herokuapp.com";
        var response =  given().
                        when().
                        get(endpoint).
                        then().
                        statusCode(200);
        response.log().body();
    }*/

    @Parameters({ "bookingid" })
    @Test(priority = 1)
    public void getBooking(String bookingid)
    {
        String endpoint = "https://restful-booker.herokuapp.com/booking/" + bookingid;
        var response = given().
                        queryParam("bookingid", bookingid).
                       when().
                        get(endpoint).
                       then();
        response.log().body();
    }
}
