package ravn;

import static org.junit.Assert.fail;

import java.io.File;
import java.io.IOException;

import org.apache.commons.io.FileUtils;
import org.hamcrest.MatcherAssert;
import org.testng.annotations.*;

import io.restassured.module.jsv.JsonSchemaValidator;

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
        String path = "src" + File.separator + "main"  + File.separator + "java" + File.separator + "ravn" + File.separator + "schema" + File.separator + "schema.json";
        File file = new File(path);

        String jsonpath = "src" + File.separator + "test" + File.separator + "java" + File.separator + "ravn" + File.separator + "JsonOutput" + File.separator + "Apirequest.json";
        File jfile = new File(jsonpath);

        String str = FileUtils.readFileToString(jfile, "utf-8");

        MatcherAssert.assertThat(str, JsonSchemaValidator.matchesJsonSchema(file));

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
