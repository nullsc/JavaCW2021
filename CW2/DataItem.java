/**
 * A DataItem is a file of digital data with a certain size in bytes.
 * It has a name and a price in pence.
 *
 * @author 
 */
public abstract class DataItem extends Item {

	/** The size of the item in bytes. Must be > 0. */
	private long sizeBytes; // ebook & music 


    /**
     * Constructs a new DataItem according to the parameter values.
     *
     * @param name  the name of this DataItem, must not be null
     * @param pricePence  the price of this DataItem in pence, must be greater
     *  than or equal to 0
     * @param sizeBytes  the size of the DataItem in bytes;
     *  must be greater than 0
     */
	public DataItem(String name, int pricePence, long sizeBytes) {
		super(name, pricePence);
		if(sizeBytes < 1) {
			throw new IllegalArgumentException("The byte size must be > 0");
		}
		this.sizeBytes = sizeBytes;
	}

	/**
	 * @return the size of the data item in bytes
	 */
	public long getSizeBytes() {
		return sizeBytes;
	}

}
