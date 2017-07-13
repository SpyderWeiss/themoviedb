package Structure;

import io.restassured.http.ContentType;
import io.restassured.response.ValidatableResponse;
import org.hamcrest.Matcher;

/**
 * Created by spyderweiss on 7/12/17.
 */
public class Validation {

    private ValidatableResponse response;

    public Validation(ValidatableResponse validatableResponse)
    {
        response = validatableResponse;
    }

    public void checkStatusCode(int statusCode)
    {
        response.assertThat().statusCode(statusCode);
    }

    public void checkContentType(ContentType contentType)
    {
        response.assertThat().contentType(contentType);
    }

    public void findValueIn(ValueType valueType, String path, Matcher<?> matcher, Object... additionalKeyMatcherPairs)
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
