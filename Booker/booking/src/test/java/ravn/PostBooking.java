package ravn;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;

import org.testng.Assert;
import org.testng.annotations.*;

import io.restassured.RestAssured;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;

public class PostBooking {
    @Parameters({"firstname", "lastname", "totalprice", "checkin", "checkout", "additionalneeds"})
    @Test(priority = 1)
    public void postBooking(String firstname, String lastname, String totalprice, String checkin, String checkout, String additionalneeds) throws IOException{
        RestAssured.baseURI = "https://restful-booker.herokuapp.com";

        String body = "{\n"+
            "\"firstname\":\""+firstname+"\",\n"+
            "\"lastname\":\""+lastname+"\",\n"+
            "\"totalprice\":\""+totalprice+"\",\n"+
            "\"depositpaid\":true,\n"+
            "\"bookingdates\":{\n"+
                "\"checkin\":\""+checkin+"\",\n"+
                "\"checkout\":\""+checkout+"\"},\n"+
            "\"additionalneeds\":\""+additionalneeds+"\"}\n";

        RequestSpecification httpRequest = RestAssured.given();
        httpRequest.header("Content-Type", "application/json");

        Response response = httpRequest.body(body).post("/booking");

        System.out.println("\n*** POST AUTOMATION ***\n");
        String responseBody = response.getBody().asPrettyString();
        System.out.println("Response: " + responseBody);

        Boolean verifyTitleIsPresent=responseBody.contains("bookingid");
        Assert.assertEquals(verifyTitleIsPresent, true);
        System.out.println("\nbookingid is being displayed on screen");
        
        String [] text = responseBody.split(",|:");
        String info = text[1].replaceAll("[^a-zA-Z0-9]", "");
        
        String path = "src" + File.separator + "data"  + File.separator + "bookingIds.txt";

        FileWriter writer = new FileWriter(path);
        writer.write(info);
        writer.close();

        System.out.println("Booking Id: " + info + "\n");        
    }
}
