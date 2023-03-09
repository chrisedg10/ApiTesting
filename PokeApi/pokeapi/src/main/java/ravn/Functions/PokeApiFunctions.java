package ravn.Functions;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;

import org.openqa.selenium.WebDriver;

import com.google.gson.*;

import ravn.Contexts.*;

public interface PokeApiFunctions extends Waits{
    default public void enterApi(WebDriver driver, String pokemon){
        System.out.println("\nPoke Api Home Page\n");

        PokeApi page = new PokeApi(driver);

        waitUntilElementIsVisible(driver, page.submitApi());

        page.apiInput().click();
        page.apiInput().clear();
        page.apiInput().sendKeys(pokemon);
        System.out.println("Entered: " + pokemon);
    }

    default public void submitApi(WebDriver driver){
        PokeApi page = new PokeApi(driver);

        page.submitApi().click();
        System.out.println("Clicked on Submit Button");
    }

    default public void displayRaw(WebDriver driver){
        System.out.println("Generating JSON");
        PokeApi page = new PokeApi(driver);
        implicitWait(driver);
        
        page.viewRaw().click();
        System.out.println("Clicked on View raw JSON");
        
        waitUntilElementIsVisible(driver, page.code());
        System.out.println("JSON Generated: \n\n" + page.code().getText());
    }

    default public void displayJson(WebDriver driver) throws IOException {
        PokeApi page = new PokeApi(driver);
        String originalWindow = driver.getWindowHandle();
        implicitWait(driver);
        page.apiLink().click();
        System.out.println("Clicked on API Link");

        //Loop through until we find a new window handle
        for (String windowHandle : driver.getWindowHandles()) {
            if(!originalWindow.contentEquals(windowHandle)) {
                driver.switchTo().window(windowHandle);
                break;
            }
        }

        waitUntilElementIsVisible(driver, page.JSONcode());
        String json = page.JSONcode().getText();

        Gson gson = new GsonBuilder().setPrettyPrinting().create();
        JsonElement je = JsonParser.parseString(json);
        String prettyJsonString = gson.toJson(je);

        System.out.println("\n*** JSON Generated from Browser *** \n\n" + prettyJsonString);

        String path = "src" + File.separator + "test" + File.separator + "java" + File.separator + "ravn" + File.separator + "JsonOutput" + File.separator + "request.json";

        FileWriter writer = new FileWriter(path);
        writer.write(prettyJsonString);
        writer.close();
    }
}
