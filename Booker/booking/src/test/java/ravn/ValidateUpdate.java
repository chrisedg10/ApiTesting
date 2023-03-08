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

public class ValidateUpdate {
    @Parameters({"additionalneeds", "newneeds"})
    @Test(priority = 2)
    public void compareBooking(String additionalneeds, String newneeds) throws IOException{
        String path = "src" + File.separator + "data"  + File.separator + "bookingIds.txt";

        FileReader fileReader = new FileReader(path);
        BufferedReader bufferedReader = new BufferedReader(fileReader);
        String bookingid = bufferedReader.readLine();

        bufferedReader.close();
        fileReader.close();
        
        RestAssured.baseURI = "https://restful-booker.herokuapp.com";
        RequestSpecification httpRequest = RestAssured.given();
        Response response = httpRequest.request(Method.GET, "/booking/"+bookingid);

        System.out.println("\n\n*** VALIDATE UPDATE ***\n");
        System.out.println("\nBooking Id entered: " + bookingid + "\n");

        String text = response.getBody().asPrettyString();

        System.out.println("Current response: \n"+text+"\n");

        System.out.println("Initial Additional Needs: " + additionalneeds + "\n");

        String [] info = text.split(",|\n");
        
        for(int i=0; i<info.length; i++){
            if(info[i].contains(newneeds)){
                System.out.println("Current: " + info[i]);
            }
        }
    }
}
