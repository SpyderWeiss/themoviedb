package TestCases;

import Structure.*;
import io.restassured.http.ContentType;
import org.testng.Reporter;
import org.testng.annotations.Test;

/**
 * Created by spyderweiss on 7/8/17.
 *
 * This class provides the ability to search for a movie by name, release date, and it's adult status, and will let you
 * know if the parameters you provided match those retrieved via the API.
 */
public class SearchTests {

    private void search(String title, String releaseDate, boolean adult, int expectedResultNumber)
    {
        Validation validation = null;
        try
        {
            validation = SetupAndTeardown.beforeTest(SharedResources.urlSearch, title);
            validation.checkStatusCode(200);
            validation.checkContentType(ContentType.JSON);
            validation.validateMovieTitle(expectedResultNumber, title);
            validation.validateMovieReleaseDate(expectedResultNumber, releaseDate);
            validation.validateMovieAdultStatus(expectedResultNumber, adult);
        }
        catch (Exception ex)
        {
            if(validation != null)
            {
                Logging.log("JSON Response: \n%s\n", validation.retrieveJSONDataAsString());
            }
            Logging.log(ex.getClass().getSimpleName() + ": " + ex.getMessage());
            throw ex;
        }
        finally
        {
            Logging.attachTestNGlog(Reporter.getOutput(Reporter.getCurrentTestResult()));
        }
    }

    @Test(groups = {"TMDB"}, description = "Searches for the movie Jack Reacher")
    public void searchForJackReacher() throws Exception
    {
        search(MovieNames.JACK_REACHER.toMovieName(), "2012-12-20", false, 0);
    }

    @Test(groups = {"TMDB"}, description = "Searches for the movie Jack Reacher: Never Go Back")
    public void searchForJackReacher2()
    {
        search(MovieNames.JACK_REACHER_2.toMovieName(), "2016-10-19", false, 0);
    }

    //I've included these 3 error tests so that examples of failed tests can be shown in the Allure report.
    @Test(groups = {"INTENTIONAL_ERROR"}, description = "Searches for a movie with a non-matching name")
    public void searchForJackReacher2WithWrongName()
    {
        search(MovieNames.JACK_REACHER_2.toMovieName(), "2016-10-19", false, 0);
    }

    @Test(groups = {"INTENTIONAL_ERROR"}, description = "Searches for a movie with a non-matching date")
    public void searchForJackReacher2WithWrongDate()
    {
        search(MovieNames.JACK_REACHER_2.toMovieName(), "2016-10-31", false, 0);
    }

    @Test(groups = {"INTENTIONAL_ERROR"}, description = "Searches for a movie with a non-matching adult status")
    public void searchForJackReacher2WithWrongAdultStatus()
    {
        search(MovieNames.JACK_REACHER_2.toMovieName(), "2016-10-19", true, 0);
    }
}
