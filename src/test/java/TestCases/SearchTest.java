package TestCases;

import Structure.*;
import io.restassured.http.ContentType;
import org.testng.Reporter;
import org.testng.annotations.Test;

import static org.hamcrest.Matchers.equalTo;

/**
 * Created by spyderweiss on 7/8/17.
 *
 * This test confirms the title, release date, and adult details are correct for the movie Jack Reacher.
 */
public class SearchTest {

    @Test(groups = {"TMDB"})
    public void searchForJackReacher() throws Exception
    {
        try
        {
            Logging.log("Beginning test.");
            Validation validation = SetupAndTeardown.setupURL(SharedResources.urlSearch);
            validation.checkStatusCode(200);
            validation.checkContentType(ContentType.JSON);
            validation.findValueIn(ValueType.BODY,"results[0].title", equalTo("Jack Reacher"));
            validation.findValueIn(ValueType.BODY,"results[0].release_date", equalTo(	"2012-12-20"));
            validation.findValueIn(ValueType.BODY,"results[0].adult", equalTo(false));
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
