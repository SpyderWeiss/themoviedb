package TestStepsOnlyTestCases;

/**
 * Created by spyderweiss on 7/9/17.
 *
 * Tests for the Get Details endpoint
 */
public class MoviesEndpoint {
    /**
     * If I send a valid movie Id integer
     * Then I should expect back a 200 response.
     */

    /**
     * If I send an invalid movie Id integer
     * Then I should expect back a 404 response.
     */

    /**
     * If I send a valid movie Id integer with an invalid token
     * Then I should expect back a 401 response.
     */

    /**
     * If I send a valid movie Id integer with a valid language string
     * Then I should expect back a 200 response.
     */

    /**
     * If I send a valid movie Id integer with an invalid language string
     * Then I should expect back a 404 response.
     */

    /**
     * If I send a valid movie Id integer
     * Then I should be able to retrieve a value from the adult boolean and validate it's type is correct.
     */

    /**
     * If I send a valid movie Id integer
     * Then I should be able to retrieve a value from the id integer and validate it's type is correct, and validate it matches the id I passed in.
     */

    /**
     * If I send a valid movie Id integer
     * Then I should be able to retrieve a value from the title string and validate it's type is correct, and validate the content isn't blank.
     */

    /**
     * If I send a valid movie Id integer
     * Then I should be able to retrieve a value from the vote_average number and validate it's type is correct, and validate the content contains a decimal.
     */

    /**
     * If I send a valid movie Id integer
     * Then I should be able to retrieve a value from the video boolean and validate it's type is correct, and validate if that movie should have a video.
     */

    /**
     * If I send a valid movie Id integer
     * Then I should be able to retrieve a value from the homepage string and validate it's type is correct, and validate the string is not null.
     */

    /**
     * If I send a valid movie Id integer
     * Then I should be able to retrieve 2 values from the genres array and validate it's type is correct, and validate the contained values are not null.
     */


}
