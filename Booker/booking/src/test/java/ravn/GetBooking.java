package ravn;

import org.testng.annotations.*;

import static io.restassured.RestAssured.given;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;

public class GetBooking {
    @Test(priority = 2)
    public void getBooking() throws IOException{
        String path = "src" + File.separator + "data"  + File.separator + "bookingIds.txt";

        FileReader fileReader = new FileReader(path);
        BufferedReader bufferedReader = new BufferedReader(fileReader);
        String bookingid = bufferedReader.readLine();

        bufferedReader.close();
        fileReader.close();
        
        String endpoint = "https://restful-booker.herokuapp.com/booking/" + bookingid;

        System.out.println("\n\n*** GET AUTOMATION ***\n");
        System.out.println("Booking Id entered: " + bookingid);

        var response = given().
                        queryParam("bookingid", bookingid).
                       when().
                        get(endpoint).
                       then();
        response.log().body();
    }
}
