package ravn;

import org.testng.annotations.*;

import io.restassured.RestAssured;
import io.restassured.http.Method;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;

public class ValidateResponse {
    @Parameters({"firstname", "lastname", "totalprice", "checkin", "checkout", "additionalneeds"})
    @Test(priority = 2)
    public void compareBooking(String firstname, String lastname, String totalprice, String checkin, String checkout, String additionalneeds) throws IOException{
        String path = "src" + File.separator + "data"  + File.separator + "bookingIds.txt";
        int n=0;

        FileReader fileReader = new FileReader(path);
        BufferedReader bufferedReader = new BufferedReader(fileReader);
        String bookingid = bufferedReader.readLine();

        bufferedReader.close();
        fileReader.close();
        
        RestAssured.baseURI = "https://restful-booker.herokuapp.com";
        RequestSpecification httpRequest = RestAssured.given();
        Response response = httpRequest.request(Method.GET, "/booking/"+bookingid);

        System.out.println("\n\n*** VALIDATE TESTNG PARAMETERS AND GET RESPONSE ***\n");
        System.out.println("Parameters defined in Test Case\n");

        String [] parameters = {firstname, lastname, totalprice, checkin, checkout, additionalneeds};

        for(int i=0; i<parameters.length; i++){
            System.out.println(parameters[i]);
        }

        System.out.println("\nBooking Id entered: " + bookingid + "\n");

        String text = response.getBody().asPrettyString();

        System.out.println("Current response: \n"+text+"\n");

        for(int i=0; i<parameters.length; i++){
            if(text.contains(parameters[i])){
                System.out.println("Request contains parameter: " + parameters[i]);
                n++;   
            }
            if(n==parameters.length){
                System.out.println("\nAll response data matches with Test case parameters");
            }
        }
    }
}
