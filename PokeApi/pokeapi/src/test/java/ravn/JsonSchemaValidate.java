package ravn;

import org.testng.annotations.Test;

import static io.restassured.RestAssured.given;
import static io.restassured.RestAssured.baseURI;
import static io.restassured.module.jsv.JsonSchemaValidator.matchesJsonSchema;

import java.io.File;

public class JsonSchemaValidate {
    @Test(priority = 1)
    public void getBooking() {
        baseURI = "https://pokeapi.co/api/";
        
        String path = "src" + File.separator + "main"  + File.separator + "java" + File.separator + "ravn" + File.separator + "schema" + File.separator + "schema.json";
        File file = new File(path);

        System.out.println("\n\n*** GET RESPONSE ***\n");

        System.out.println(
            given().
            get("v2/berry/").
            then().
            assertThat().
            body(matchesJsonSchema(file)).
            statusCode(200).
            extract().
            asPrettyString()
        );

    }
}
