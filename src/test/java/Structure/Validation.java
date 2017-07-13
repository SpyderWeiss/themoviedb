package Structure;

import io.restassured.http.ContentType;
import io.restassured.response.ValidatableResponse;
import org.hamcrest.Matcher;

import static org.hamcrest.Matchers.equalTo;
import static org.hamcrest.core.IsNot.not;

/**
 * Created by spyderweiss on 7/12/17.
 */
public class Validation {

    private ValidatableResponse response;

    public Validation(ValidatableResponse validatableResponse)
    {
        response = validatableResponse;
    }

    public void validateRequestToken()
    {
        findValueIn(ValueType.BODY, "request_token", not(""));
    }

    public void checkStatusCode(int statusCode)
    {
        response.assertThat().statusCode(statusCode);
    }

    public void checkContentType(ContentType contentType)
    {
        response.assertThat().contentType(contentType);
    }

    public void validateMovieTitle(int expectedResultNumber, String title)
    {
        findValueIn(ValueType.BODY, String.format("results[%d].title", expectedResultNumber), equalTo(title));
    }

    public void validateMovieReleaseDate(int expectedResultNumber, String releaseDate)
    {
        findValueIn(ValueType.BODY, String.format("results[%d].release_date", expectedResultNumber), equalTo(releaseDate));
    }

    public void validateMovieAdultStatus(int expectedResultNumber, boolean adult)
    {
        findValueIn(ValueType.BODY, String.format("results[%d].adult", expectedResultNumber), equalTo(adult));
    }

    private void findValueIn(ValueType valueType, String path, Matcher<?> matcher, Object... additionalKeyMatcherPairs)
    {
        switch(valueType)
        {
            case BODY:
                response.assertThat().body(path, matcher, (additionalKeyMatcherPairs));
                break;
            case CONTENT:
                response.assertThat().content(path, matcher, (additionalKeyMatcherPairs));
                break;
            case HEADER:
                response.assertThat().header(path, matcher);
                break;
        }

    }

    public String retrieveJSONDataAsString()
    {
        return response.extract().response().asString();
    }

}
