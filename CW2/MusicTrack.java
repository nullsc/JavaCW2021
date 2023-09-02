/**
 * A MusicTrack has a name, a price in pence, a size in bytes, and a duration
 * in seconds.
 *
 * @author 
 */
public class MusicTrack extends DataItem {

	/** The length of the music strack in seconds. Must be > 0. */
	private int durationSeconds;

    /**
     * Constructs a MusicTrack according to the parameters.
     *
     * @param name  the name of the MusicTrack; must not be null
     * @param pricePence  the price in pence; must not be less than 0
     *  (0 itself is allowed) 
     * @param sizeBytes  the size of the MusicTrack in bytes;
     *  must be greater than 0
     * @param durationSeconds  the duration of the MusicTrack in seconds;
     *  must be greater than 0
     */
    public MusicTrack(String name, int pricePence, long sizeBytes, int durationSeconds) {
		super(name, pricePence, sizeBytes);
		if (durationSeconds <= 0) {
            throw new IllegalArgumentException("The duration of the music track must be > 0");
        }
		this.durationSeconds = durationSeconds;
		
    }


    /**
     * Returns the duration of a music track in seconds.
     *
     * @return the duration of the song
     */
	public int getDurationSeconds() {
		return durationSeconds;
	}

    /**
     * Returns the boolean value of if a music track is in stock. Currently always returns true as 
     * digital items do not run out of stock
     * @return if the item is in stock or not
     */
	@Override
	public boolean inStock() { //override
		//if(howMany > 0)
			//return true;

		return true; // always in stock
	}

    @Override
    public String toString() {
        return super.toString()
            + "\nBytes: " + getSizeBytes()
            + "\nSeconds: " + getDurationSeconds();
    }
}
