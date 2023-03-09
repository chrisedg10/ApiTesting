package ravn.Constants;

import java.time.Duration;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.ui.WebDriverWait;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.testng.annotations.Parameters;

public class WebDriverBase {

    public static WebDriver driver;
    protected boolean acceptNextAlert = true;
    protected StringBuffer verificationErrors = new StringBuffer();
    protected WebDriverWait wait;

    @Parameters({ "browser" })
    public void webDriverSetUp(String browser) throws Exception {
        if (browser.equals("Firefox")) {
            WebDriverManager.firefoxdriver().setup();
            driver = new FirefoxDriver();

        } else if (browser.equals("Chrome")) {
            WebDriverManager.chromedriver().setup();
            driver = new ChromeDriver();

        } else if (browser.equals("Edge")) {

            WebDriverManager.edgedriver().setup();
            driver = new EdgeDriver();

        }

        wait = new WebDriverWait(driver, Duration.ofSeconds(15));
        driver.manage().window().maximize();
    }
}