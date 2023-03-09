package ravn;

import static org.junit.Assert.fail;

import java.io.File;
import java.io.IOException;

import org.testng.annotations.*;

import ravn.Constants.WebDriverBase;
import ravn.Functions.*;

public class ApiBrowser extends WebDriverBase implements PokeApiFunctions{
    @Parameters({ "browser", "URL" })
    @BeforeClass(alwaysRun = true)
    public void setUp(String browser, String URL) throws Exception {
        webDriverSetUp(browser);
        driver.get(URL);
        driver.manage().deleteAllCookies();
        System.out.println("\n***Execution Started***\n");
    }

    @Parameters({ "pokemonType" })
    @Test(priority = 0)
    public void testApi(String pokemonType) throws IOException{
        enterApi(driver, pokemonType);
        submitApi(driver);
        displayJson(driver);
    }

    @Test
    public void validateJson() throws IOException{
        String pathBrowser = "src" + File.separator + "test" + File.separator + "java" + File.separator + "ravn" + File.separator + "JsonOutput" + File.separator + "request.json";
        File file = new File(pathBrowser);

        System.out.println(file.toString());

        System.out.println("\n***Execution Finished***\n");
    }

    @AfterClass(alwaysRun = true)
    public void tearDown() throws Exception {
        driver.quit();
        String verificationErrorString = verificationErrors.toString();
        if (!"".equals(verificationErrorString)) {
            fail(verificationErrorString);
        }
    }
}
