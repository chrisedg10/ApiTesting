package ravn;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;

import org.testng.annotations.*;

import io.restassured.RestAssured;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;

public class UpdateBooking {
    @Parameters({"firstname", "lastname", "totalprice", "checkin", "checkout", "newneeds"})
    @Test(priority = 1)
    public void postBooking(String firstname, String lastname, String totalprice, String checkin, String checkout, String newneeds) throws IOException{
        String path = "src" + File.separator + "data"  + File.separator + "bookingIds.txt";

        FileReader fileReader = new FileReader(path);
        BufferedReader bufferedReader = new BufferedReader(fileReader);
        String bookingid = bufferedReader.readLine();

        bufferedReader.close();
        fileReader.close();

        String body = "{\n"+
            "\"firstname\":\""+firstname+"\",\n"+
            "\"lastname\":\""+lastname+"\",\n"+
            "\"totalprice\":\""+totalprice+"\",\n"+
            "\"depositpaid\":true,\n"+
            "\"bookingdates\":{\n"+
                "\"checkin\":\""+checkin+"\",\n"+
                "\"checkout\":\""+checkout+"\"},\n"+
            "\"additionalneeds\":\""+newneeds+"\"}\n";

        RestAssured.baseURI = "https://restful-booker.herokuapp.com";
        RequestSpecification httpRequest = RestAssured.given();

        httpRequest.header("Content-Type", "application/json")
                   .header("Authorization", "Basic YWRtaW46cGFzc3dvcmQxMjM=")
                   .header("Cookie", "token=abc123");

        Response response = httpRequest.body(body).put("/booking/" + bookingid);

        System.out.println("\n*** PUT AUTOMATION ***\n");
        String responseBody = response.getBody().asPrettyString();
        System.out.println("Response: " + responseBody);     
    }
}
