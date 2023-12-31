/**
 * Interface for Books. All books have an ISBN (International Standard Book Number).
 *
 * @author 
 */
public interface Book {

    /**
     * Returns the ISBN-13 of this Book.
     *
     * @return the ISBN-13 of this Book
     */
    String getISBN();

    /**
     * Checks whether an ISBN-13 is well formed according to
     * https://en.wikipedia.org/w/index.php?title=International_Standard_Book_Number&oldid=808135079
     *
     * @param isbn  to be checked for being well formed; should consist
     *  only of digits; may be null
     * @return whether the given isbn is well formed; false if null 
     */
    static boolean checkWellFormedISBN(String isbn) {
        final int ISBN_LENGTH = 13; // constant for length of correct ISBN
        final String PREFIX_ONE = "978"; // the first "Bookland" prefix
        final String PREFIX_TWO = "979"; // the second "Bookland" prefix
        // null is /not/ a legal ISBN
        if (isbn == null) {
            return false;
        }
        // isbn must have a certain length
        if (isbn.length() != ISBN_LENGTH) {
            return false;
        }
        // all digits?
        for (int i = 0; i < ISBN_LENGTH; i++) {
            if (! Character.isDigit(isbn.charAt(i))) {
                return false;
            }
        }
        // does isbn start with some legal prefix?  
        if (! (isbn.startsWith(PREFIX_ONE) || isbn.startsWith(PREFIX_TWO))) {
            return false;
        }
        // now consider the weighted sum according to the ISBN-13 rules from
        // https://en.wikipedia.org/w/index.php?title=International_Standard_Book_Number&oldid=808135079
        int weightedSum = 0;
        for (int i = 0; i < ISBN_LENGTH; i++) {
            char c = isbn.charAt(i);

            // we need the int value parsed from c's String representation,
            // not the int value of the char itself!
            String s = c + "";
            int value = Integer.valueOf(s);
            if (i % 2 == 1) {
                value *= 3;
            }
            weightedSum += value;
        }
        return weightedSum % 10 == 0;
    }
}
