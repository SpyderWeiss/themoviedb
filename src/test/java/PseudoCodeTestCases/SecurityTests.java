package PseudoCodeTestCases;

/**
 * Created by spyderweiss on 7/8/17.
 *
 * Note, the tests in this class are pseudocode and will not run.
 */
public class SecurityTests {

//    public void loginWithInvalidCredentials()
//    {
//        ValidatableResponse response = given().when().get(SharedResources.urlAuthenticateWithInvalidAPIKey).then();
//        response.assertThat().statusCode(401);
//        response.assertThat().contentType(ContentType.JSON);
//        response.assertThat().body("request_token", equalTo(""));
//        response.assertThat().body("success", equalTo(true));
//    }

//    public void createSession()
//    {
//        ValidatableResponse response = given().when().get(SharedResources.urlAuthenticate).then();
//        response.assertThat().statusCode(200);
//        response.assertThat().contentType(ContentType.JSON);
//        String token = response.body("request_token");
//        ValidatableResponse response2 = given().when().get(SharedResources.createSessionWithToken).then();
//        response2.assertThat().statusCode(200);
//        response2.assertThat().contentType(ContentType.JSON);
//    }

//    @Test(dependsOnMethods = createSession())
//    public void createSessionWithLogin()
//    {
//        createSession();
//        ValidatableResponse response3 = given().when().get(SharedResources.login).then();
//        response3.assertThat().statusCode(200);
//        response3.assertThat().contentType(ContentType.JSON);
//    }
}
