package TestCases;

import Structure.*;
import io.restassured.http.ContentType;
import org.testng.Reporter;
import org.testng.annotations.Test;

import static org.hamcrest.core.IsNot.not;

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
            Validation validation = SetupAndTeardown.setupURL(SharedResources.urlAuthenticate);
            validation.checkStatusCode(200);
            validation.checkContentType(ContentType.JSON);
            validation.findValueIn(ValueType.BODY, "request_token", not(""));
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
