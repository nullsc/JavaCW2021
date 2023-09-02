/**
 * A printed book with a name, a price, a number of units in stock,
 * an ISBN, and a number of pages.
 *
 * @author 
 */
public class PrintBook extends PhysicalItem implements HasPages, Book {

	/** The ISBN number of the e/book. Must be a valid ISBN number. */
	private String isbn;

	/** The number of pages in the book. Must be > 0. */
	private int pages;

    /**
     * Constructs a new PrintBook according to the parameter values.
     *
     * @param name  the name of this PrintBook, must not be null
     * @param pence  the price of this PrintBook in pence, must be greater
     *  than or equal to 0
     * @param howMany  the number of units we have of this PrintBook,
     *  must be greater than or equal to 0
     * @param isbn  the ISBN-13 of the book, must consist only of digits
     *  and must be a well-formed ISBN-13
     * @param pages  the number of pages of the book, must be greater than 0
     */
    public PrintBook(String name, int pence, int howMany, String isbn, int pages) {
        //
		super(name, pence, howMany);
		if (pages <= 0) {
            throw new IllegalArgumentException("Pages must be above 0 and not be null!");
        }
		if (!Book.checkWellFormedISBN(isbn)) {
            throw new IllegalArgumentException("ISBN is malformed");
        }
		this.isbn = isbn;
		this.pages = pages;
		
    }

    /**
     * Returns the ISBN of this book as a string.
     *
     * @return the ISBN of this book
     */
	public String getISBN() {
		return isbn;
	}

    /**
     * Returns the number of pages in the book.
     *
     * @return the number of pages in the book
     */
	public int getPages() { //interface
		return pages;
	}

    @Override
    public String toString() {
        return super.toString() + "\nISBN: " + getISBN()
            + "\nPages: " + getPages();
    }
}
