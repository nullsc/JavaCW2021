/**
 * An electronic book with a name, a price in pence, a size in bytes, and
 * an ISBN. Since not all electronic books have a fixed number of pages,
 * this class does not implement the interface HasPages.
 *
 * @author 
 */
public class EBook extends DataItem implements Book {

	/** The ISBN of the book. Must not be null and must be a valid ISBN. */
	private String isbn;

    /**
     * Constructs a new EBook according to the parameter values.
     *
     * @param name  the name of this EBook, must not be null
     * @param pricePence  the price of this EBook in pence, must be greater
     *  than or equal to 0
     * @param sizeBytes  the size of the EBook in bytes;
     *  must be greater than 0
     * @param isbn  the ISBN-13 of the book, must consist only of digits
     *  and must be a well-formed ISBN-13
     */
    public EBook(String name, int pricePence, long sizeBytes, String isbn) {
        
		super(name, pricePence, sizeBytes);
		if(!Book.checkWellFormedISBN(isbn)) {
			throw new IllegalArgumentException("The ISBN is incorrect");
		}
		this.isbn = isbn;
    }


    /**
     * Returns the ISBN of the ebook.
     *
     * @return the ISBN of the ebook as a string
     */
	public String getISBN() {

		return isbn;
	}

    /**
     * Returns the boolean value of if an ebook is in stock. Currently always returns true as 
     * digital items do not run out of stock
     * @return if the item is in stock or not
     */
	@Override
	public boolean inStock() {

		return true; // always in stock
	}

    @Override
    public String toString() {
        return super.toString()
            + "\nBytes: " + getSizeBytes()
            + "\nISBN: " + getISBN();
    }
}
