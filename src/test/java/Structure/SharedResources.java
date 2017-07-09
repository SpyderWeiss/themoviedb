package Structure;

/**
 * Created by spyderweiss on 7/8/17.
 */
public class SharedResources {

    private static final String apiKey = "";
    public static final String urlBase = "https://api.themoviedb.org/";
    public static final String urlAuthenticate = String.format("%s3/authentication/token/new?api_key=%s", urlBase, apiKey);
    public static final String urlSearch = String.format("%s3/search/movie?api_key=%s&query=Jack+Reacher", urlBase, apiKey);
}
