package ravn.Functions;

import java.time.Duration;
import java.util.NoSuchElementException;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.FluentWait;
import org.openqa.selenium.support.ui.Wait;

public interface Waits {
    default public void implicitWait(WebDriver driver) {
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(60));
    }

    // Wait until element to be visible
    default public void waitUntilElementIsVisible(WebDriver driver, WebElement element) {
        Wait<WebDriver> wait = new FluentWait<WebDriver>(driver)
                .withTimeout(Duration.ofSeconds(60))
                .pollingEvery(Duration.ofSeconds(5))
                .ignoring(NoSuchElementException.class);
        implicitWait(driver);
        
        wait.until(ExpectedConditions.visibilityOf(element));
    }

    // Wait until element to be clickable
    default public void waitUntilElementIsClickable(WebDriver driver, WebElement element) {
        Wait<WebDriver> wait = new FluentWait<WebDriver>(driver)
                .withTimeout(Duration.ofSeconds(60))
                .pollingEvery(Duration.ofSeconds(5))
                .ignoring(NoSuchElementException.class);
        implicitWait(driver);

        wait.until(ExpectedConditions.elementToBeClickable(element));
    }
}