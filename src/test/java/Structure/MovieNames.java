package Structure;

/**
 * Created by spyderweiss on 7/17/17.
 */
public enum MovieNames {

    JACK_REACHER,
    JACK_REACHER_2;

    /**
     * Method to return the movie name string from the enum
     *
     * @return Movie name string
     */
    private String toMovieName()
    {
        String value;
        switch (this)
        {
            case JACK_REACHER:
                value = "Jack Reacher";
                break;
            case JACK_REACHER_2:
                value = "Jack Reacher: Never Go Back";
                break;
            default:
                throw new RuntimeException("Movie title not provided.");
        }
        return value;
    }

}
