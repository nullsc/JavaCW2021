/**
 * Abstract superclass for our Item hierarchy. An Item has a name and a price.
 * Items can be sold, one unit at a time.
 *
 * @author 
 */
public abstract class Item {

    /** The name of the item. Must not be null. */
    private String name;

    /** The price of the item in pence. Must be >= 0. */
    private int pricePence;

    /**
     * Constructs a new Item with a name and a price in pence.
     *
     * @param name  the name of the Item; must not be null
     * @param pricePence  the price in pence; must not be less than 0
     *  (0 itself is allowed) 
     */
    public Item(String name, int pricePence) {
        if (name == null) {
            throw new IllegalArgumentException("Name must not be null!");
        }
        if (pricePence < 0) {
            throw new IllegalArgumentException("Expected pricePence >= 0; found "
                    + pricePence);
        }
        this.name = name;
        this.pricePence = pricePence;
    }

    /**
     * Sells one unit of this Item if this Item is in stock and,
     * if necessary, updates the number of units of this Item in stock;
     * throws an OutOfStockException if this Item is not in stock.
     *
     * @return the price at which the Item was sold
     */
    public final int sellOne() {
        if (! this.inStock()) {
            throw new OutOfStockException("Item out of stock!");
        }
        int result = this.computePricePence();
        this.updateStockAfterSale();
        return result;
    }

    /**
     * Updates the stock of the Item with the information that 1 unit
     * has been sold.
     *
     * The implementation in Item does nothing. The method is to be
     * overridden by subclasses where the number of present Item units
     * is limited.
     *
     * The method is protected instead of public because it is not meant
     * to be called by external users of our Item data structure. The method
     * is rather intended for internal "bookkeeping" purposes by programmers
     * who write subclasses of Item.
     */
    protected void updateStockAfterSale() {
        // nothing to do for Item; subclasses with limited supply may
        // need to override this "default implementation".
    }

    /**
     * Returns whether this Item is currently in stock.
     *
     * How this is determined depends on the subclass (some kinds
     * of Item may have infinite supply, other kinds of Item may
     * have a limited supply).
     *
     * @return whether this Item is currently in stock
     */
    public abstract boolean inStock();

    /**
     * Returns the name of this Item.
     *
     * @return the name of this Item
     */
    public String getName() {
        return this.name;
    }

    /**
     * Returns the price of this Item in pence.
     *
     * @return the price of this Item in pence
     */
    public int computePricePence() {
        return this.pricePence;
    }

    /**
     * Provides a String representation of an amount in pence.
     *
     * @param priceInPence  amount in pence
     * @return a String representation of the given amount in pence
     */
    public static String computePriceString(int priceInPence) {
        int pounds = priceInPence / 100;
        int pence = priceInPence % 100;
        return "GBP " + pounds + "." + (pence < 10 ? "0" : "") + pence;
    }

    /**
     * Provides a String representation of the price that the next unit
     * of this Item would cost.
     *
     * @return Provides a String representation of the price that the
     *  next unit of this Item would cost.
     */
    public final String computePriceString() {
        return computePriceString(this.computePricePence());
    }

    @Override
    public String toString() {
        return "*** " + this.getClass().getName()
                + " ***\nName: " + this.getName()
                + "\nPrice: " + this.computePriceString();
    }
}
