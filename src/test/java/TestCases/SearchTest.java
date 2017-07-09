package TestCases;

import Structure.Logging;
import Structure.SharedResources;
import io.restassured.http.ContentType;
import io.restassured.response.ValidatableResponse;
import org.apache.log4j.BasicConfigurator;
import org.testng.Reporter;
import org.testng.annotations.Test;

import static io.restassured.RestAssured.given;
import static org.hamcrest.Matchers.*;

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
            BasicConfigurator.configure();
            ValidatableResponse response = given().when()
                    .get(SharedResources.urlSearch).then();
            response.assertThat().statusCode(200);
            response.assertThat().contentType(ContentType.JSON);
            response.assertThat().body("results[0].title", equalTo("Jack Reacher"));
            response.assertThat().body("results[0].release_date", equalTo(	"2012-12-20"));
            response.assertThat().body("results[0].adult", equalTo(false));
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
