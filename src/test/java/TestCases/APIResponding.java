package TestCases;

import Structure.Logging;
import Structure.SharedResources;
import io.restassured.http.ContentType;
import io.restassured.response.ValidatableResponse;
import org.apache.log4j.BasicConfigurator;
import org.testng.Reporter;
import org.testng.annotations.Test;

import static io.restassured.RestAssured.given;
import static org.hamcrest.Matchers.not;

/**
 * Created by spyderweiss on 7/8/17.
 *
 * Simple test to confirm The Movie DB API is returning a request_token for your provided API key.
 */
public class APIResponding {

    @Test(groups = {"TMDB"})
    public void apiResponding() throws Exception
    {
        try
        {
            Logging.log("Beginning test.");
            BasicConfigurator.configure();
            ValidatableResponse response = given().when().get(SharedResources.urlAuthenticate).then();
            response.assertThat().statusCode(200);
            response.assertThat().contentType(ContentType.JSON);
            response.assertThat().body("request_token", not(""));
            Logging.log("Ending test.");
        }
        catch (Exception ex)
        {
            Logging.log(ex.getClass().getSimpleName() + ": " + ex.getMessage());
            throw ex;
        }
        finally
        {
            Logging.attachTestNGlog(Reporter.getOutput(Reporter.getCurrentTestResult()));
        }
    }
}
