/**
 * A JPod is a PhysicalItem with a name, a price, and a number of units
 * in stock. Similar to PhysicalItem, but with a rather specific way of
 * computing the price due to its popularity when only few items are left
 * in stock.
 *
 * @author 
 */
public class JPod extends PhysicalItem {


    /**
     * Constructs a new JPod according to the parameters.
     *
     * @param name  the name of this JPod
     * @param pricePence  the initial price of the item in pence;
     *  must not be negative (0 is allowed)
     * @param howMany  number of units we have of this JPod;
     *  must not be negative (0 is allowed)
     */
    public JPod(String name, int pricePence, int howMany) {
		super(name, pricePence, howMany);
	// exceptions in parent class
    }

    /**
     * Returns the price in pence for a JPod.
     *
	 * 
	 * If we have 5 or more JPod units in stock, we return the value that was
	 * passed to the constructor. If we have n <5 JPod units in stock and if p is the
	 * value for the price in pence that was passed to the constructor, the price that is
	 * charged for the next unit is determined by the expression: (6 −n)·p
	 * 
     * @return the price in pence of this Item
     */
	@Override
	public int computePricePence() {
		// throw
		if (super.getHowMany() >= 5) { //
			return super.computePricePence();//
		} else if (super.getHowMany() < 5 && super.getHowMany() > 0) {
			return ((6 - super.getHowMany()) * super.computePricePence());
		} /*else {
			throw new OutOfStockException();
		}*/
		return 0;
	}
}
