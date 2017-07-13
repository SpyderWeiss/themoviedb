package Structure;

/**
 * Created by spyderweiss on 7/8/17.
 */
public class SharedResources {
    //TODO: Always remove API key before committing file.
    private static final String apiKey = "";
    public static final String urlBase = "https://api.themoviedb.org/";
    public static final String urlAuthenticate = String.format("3/authentication/token/new?api_key=%s", apiKey);
    public static final String urlSearch = String.format("3/search/movie?api_key=%s&query=Jack+Reacher", apiKey);
}
