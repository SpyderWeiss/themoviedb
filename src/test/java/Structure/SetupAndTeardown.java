package Structure;

import io.restassured.response.ValidatableResponse;
import org.apache.log4j.BasicConfigurator;
import org.testng.annotations.*;

import static Structure.SharedResources.urlBase;
import static io.restassured.RestAssured.given;

/**
 * Created by spyderweiss on 7/12/17.
 */
public class SetupAndTeardown {

    @BeforeSuite
    private void beforeSuite()
    {
        Logging.log("Beginning suite.");
    }

    @BeforeClass
    public static Validation setupURL(String url)
    {
        BasicConfigurator.configure();
        ValidatableResponse response = given().when().get(urlBase + url).then();
        return new Validation(response);
    }

    @BeforeTest
    private void beforeTest()
    {
        Logging.log("Beginning test.");
    }

    @AfterTest
    private void afterTest()
    {
        Logging.log("Ending test.");
    }

    @AfterSuite
    private void afterSuite()
    {
        Logging.log("Ending suite.");
    }


}
