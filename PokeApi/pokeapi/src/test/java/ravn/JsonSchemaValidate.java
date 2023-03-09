package ravn;

import org.testng.annotations.Test;

import static io.restassured.RestAssured.given;
import static io.restassured.RestAssured.baseURI;
import static io.restassured.module.jsv.JsonSchemaValidator.matchesJsonSchema;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;

public class JsonSchemaValidate {
    @Test(priority = 1)
    public void getBooking() throws IOException {
        baseURI = "https://pokeapi.co/api/";
        
        String path = "src" + File.separator + "main"  + File.separator + "java" + File.separator + "ravn" + File.separator + "schema" + File.separator + "schema.json";
        File file = new File(path);

        System.out.println("\n\n*** GET RESPONSE ***\n");

        String json = 
            given().
            get("v2/berry/").
            then().
            assertThat().
            body(matchesJsonSchema(file)).
            statusCode(200).
            extract().
            asPrettyString()
        ;

        System.out.println(json);

        String jsonpath = "src" + File.separator + "test" + File.separator + "java" + File.separator + "ravn" + File.separator + "JsonOutput" + File.separator + "ApiRequest.json";

        FileWriter writer = new FileWriter(jsonpath);
        writer.write(json);
        writer.close();

    }
}
