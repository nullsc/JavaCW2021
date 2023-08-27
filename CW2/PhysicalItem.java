/**
 * A physical object (a chair, a clock, a bicycle, a jacket, ...).
 * It has a name and a price. At any time, a certain number of
 * (presumably identical) units of this item is in stock (at least 0).
 *
 * @author 
 */
public class PhysicalItem extends Item {

	/** The physical amount of the item in pence. Must be >= 0. */
	private int howMany;

    /**
     * Constructs a new PhysicalItem according to the parameters.
     *
     * @param name  the name of this PhysicalItem; must not be null
     * @param pricePence  the price of the item in pence; must not be negative
     *  (0 is allowed)  
     * @param howMany  number of units we have of this PhysicalItem;
     *  must not be negative (0 is allowed)
     */
    public PhysicalItem(String name, int pricePence, int howMany) {
		
		super(name, pricePence); // needs to be first
		if (howMany <= 0) {
            throw new IllegalArgumentException("Physical item amount must not be null!");
        }
		this.howMany = howMany;
    }

	/**
     * Returns whether this Item is currently in stock.
     *
     * @return whether this Item is currently in stock
     */
	@Override
	public boolean inStock() {
		if(howMany > 0)
			return true;

		return false;
	}

	/**
     * Returns the amount in stock of the Item.
     *
     * @return the Item count
     */
	public int getHowMany() {
		return howMany;
	}

	/**
     * Updates the stock level of physical items once an item has been sold. It reduces the stock by 1
     *
	 * Overrides the method in the Item class
     * @return none
     */
	@Override
	public void updateStockAfterSale() {
		if(howMany > 0) {
        	howMany--;
		} else {
			throw new OutOfStockException("Error: Item is out of stock");
		}
    }

    @Override
    public String toString() {
        return super.toString() + "\nUnits left: " + getHowMany();
    }
}
