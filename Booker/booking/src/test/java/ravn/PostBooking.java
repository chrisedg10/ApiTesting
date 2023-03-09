package ravn;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.text.ParseException;

import org.testng.Assert;
import org.testng.annotations.*;

import io.restassured.RestAssured;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;

public class PostBooking {
    @Parameters({"firstname", "lastname", "totalprice", "checkin", "checkout", "additionalneeds"})
    @Test(priority = 1)
    public void postBooking(String firstname, String lastname, String totalprice, String checkin, String checkout, String additionalneeds) throws IOException, ParseException{
        /* Declaring base URL */
        RestAssured.baseURI = "https://restful-booker.herokuapp.com";
        
        /* Declaring Serialized JSON Object */
        Bookingdates bookingdates = new Bookingdates(checkin, checkout);
        Booking booking = new Booking(firstname, lastname, totalprice, true, bookingdates, additionalneeds);

        RequestSpecification httpRequest = RestAssured.given();
        httpRequest.header("Content-Type", "application/json");

        Response response = httpRequest.body(booking).post("/booking");

        System.out.println("\n*** POST AUTOMATION ***\n");
        String responseBody = response.getBody().asPrettyString();
        System.out.println("Response: " + responseBody);

        /* Verify if response contains booking id */
        Boolean verifyTitleIsPresent=responseBody.contains("bookingid");
        Assert.assertEquals(verifyTitleIsPresent, true);
        System.out.println("\nbookingid is being displayed on screen");
        
        /* Saving booking id value */
        String [] text = responseBody.split(",|:");
        String info = text[1].replaceAll("[^a-zA-Z0-9]", "");  
        String path = "src" + File.separator + "data"  + File.separator + "bookingIds.txt";

        FileWriter writer = new FileWriter(path);
        writer.write(info);
        writer.close();

        System.out.println("Booking Id: " + info + "\n");   
    }
}
