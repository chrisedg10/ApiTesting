package ravn;

import static org.junit.Assert.fail;

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
    public void testApi(String pokemonType){
        enterApi(driver, pokemonType);
        submitApi(driver);
        //displayJson(driver);
        displayRaw(driver);
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
