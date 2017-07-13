package TestCases;

import Structure.Logging;
import Structure.SetupAndTeardown;
import Structure.SharedResources;
import Structure.Validation;
import io.restassured.http.ContentType;
import org.testng.Reporter;
import org.testng.annotations.Test;

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
            Validation validation = SetupAndTeardown.testingEndpoint(SharedResources.urlAuthenticate);
            validation.checkStatusCode(200);
            validation.checkContentType(ContentType.JSON);
            validation.validateRequestToken();
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
