package ravn.Functions;

import org.openqa.selenium.WebDriver;

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
        PokeApi page = new PokeApi(driver);
        implicitWait(driver);
        
        page.viewRaw().click();
        System.out.println("Clicked on View raw JSON");
        
        waitUntilElementIsVisible(driver, page.code());
        System.out.println("JSON Generated: \n\n" + page.code().getText());
    }

    default public void displayJson(WebDriver driver) {
        PokeApi page = new PokeApi(driver);
        implicitWait(driver);
        page.apiLink().click();
        System.out.println("Clicked on API Link");
    }
}
