/**
 * A Knapsack holds zero or more Items and can provide information about the
 * Items. One can add Items to a Knapsack during its lifetime, reset the
 * Knapsack, create a copy which contains Items only up to a certain weight,
 * and make various queries to the Knapsack. (Thus, the number of Items that
 * will be stored by a Knapsack object is not yet known when the new object
 * is created, and it may grow and shrink over the lifetime of a Knapsack
 * object.)
 *
 *
 */
import java.util.ArrayList;

public class Knapsack {


	/** The name of the list of items. Empty after object creation if no items are specified. */
	private ArrayList<Item> items;

	/** The total weight of the knapsack in grammes. Must be greater or equal to 0. */
	private int totalWeightInGrammes;

    /* Constructors */

    /**
     * Constructs a new Knapsack without any Items.
     */
    public Knapsack() {
 
		  this.items = new ArrayList<Item>(); // construct empty list
    }

    /**
     * Constructs a new Knapsack containing the non-null Items in items.
     * The items array may be modified by the caller afterwards without
     * affecting this Knapsack, and it will not be modified by this
     * constructor.
     *
     * @param items must not be null; non-null elements are added to the
     *  constructed Knapsack
     */
    public Knapsack(Item[] items) {
		this(); // call the first constructor to created the empty arraylist
		if(items != null) {
			for(Item x: items){
				if(x != null) { // check if the item is non-null, if so then add it and increase the weight
					this.items.add(x);
					this.totalWeightInGrammes += x.getWeightInGrammes();
				}
			}
		}
    }

    /* Modifiers */

    /**
     * Adds an Item e to this Knapsack if e is not null; does not modify this
     * Knapsack otherwise. Returns true if e is not null, false otherwise.
     *
     * @param e an item to be added to this Knapsack
     * @return true if e is not null, false otherwise
     */
    public boolean add(Item e) {
		if(e != null) {
			this.items.add(e);
			this.totalWeightInGrammes += e.getWeightInGrammes();
			return true;
		}
		
		return false; //return false by default
        
    }

    /**
     * Adds all non-null Items in items to this Knapsack.
     *
     * @param items contains the Item objects to be added to
     *  this Knapsack; must not be null (but may contain null)
     * @return true if at least one element of items is non-null;
     *  false otherwise
     */
    public boolean addAll(Item[] items) {
		int count = 0; // keep count of non-null elements
		if(items != null) {
			for(Item x: items){
				if(x != null) {// add all non null items
					this.totalWeightInGrammes += x.getWeightInGrammes();
					this.items.add(x);
					count++;
				}
			}
			if(count > 0)
				return true; // at least one element is non-null
		}
        return false;
    }

    /**
     * Resets this Knapsack to a Knapsack that contains 0 Items.
     */
    public void reset() {
		this.items.clear();
		this.totalWeightInGrammes = 0;
    }

    /**
     * Removes certain Items from this Knapsack. Exactly those Items are kept
     * whose weight in grammes is less than or equal to the specified maximum
     * weight in grammes.
     *
     * @param maxItemWeightInGrammes the maximum weight in grammes for the
     *  Items that are kept
     */
    public void keepOnlyItemsWith(int maxItemWeightInGrammes) {
		ArrayList<Item> newitems = new ArrayList<>(); // copy valid items to a new list
		int newWeight = 0; // stores the new weight

		if(items != null) {
			for(Item x: items){
				if(x != null && x.getWeightInGrammes() <= maxItemWeightInGrammes) {
					newWeight += x.getWeightInGrammes();
					newitems.add(x);
				}
			}

		this.items.clear(); // clear array
		this.items.addAll(newitems); //// replace with the new one
		this.totalWeightInGrammes = newWeight; // update the weight
		}

    }

    /* Accessors */

    /**
     * Returns the number of non-null Items in this Knapsack.
     *
     * @return the number of non-null Items in this Knapsack
     */
    public int numberOfItems() {
		int count = 0;
		if(items != null) {
			for(Item x: items){
				if(x != null) {
					count++; // only counts non-null, return 0 by default
				}
			}
		}
		return count;
    }

    /**
     * Returns the total weight of the Items in this Knapsack.
     *
     * @return the total weight of the Items in this Knapsack.
     */
    public int totalWeightInGrammes() {
        return this.totalWeightInGrammes; //return the instance variable
    }

    /**
     * Returns the average weight in grammes of the (non-null) Items
     * in this Knapsack. In case there is no Item in this Knapsack,
     * -1.0 is returned.
     *
     * For example, if this Knapsack has the contents
     *   new Item("Soda", 400)
     * and
     *   new Item("Water", 395),
     * the result is: 397.5
     *
     * @return the average length of the Items in this Knapsack,
     *  or -1.0 if there is no such Item.
     */
    public double averageWeightInGrammes() {
        /** numberOfItems() returns the total non-null items */
		if(this.numberOfItems() < 1) //avoid division by zero error
			return -1.0;

		return (totalWeightInGrammes / (double)this.numberOfItems()); //cast to double
    }

    /**
     * Returns the greatest Item in this Knapsack according to the
     * natural ordering of Item given by its compareTo method;
     * null if this Knapsack does not contain any Item objects
     *
     * @return the greatest Item in this Knapsack according to the
     *  natural ordering of Item given by its compareTo method;
     *  null if this Knapsack does not contain any Item objects
     */
    public Item greatestItem() {
		if(this.items == null || this.numberOfItems() < 1) // check if there is a non-null item
			return null;

		Item greatest; // 

		greatest = this.items.get(0); // assign the first entry
		
		if(items != null) {
			for(Item x: items){
				if(x != null) { // check the object isn't a null
					if(x.compareTo(greatest) > 0) { // if it returns 1 then obj is larger
						greatest = x; // update the greatest
					} 
				}
			}
		}
        return greatest;

    }

    /**
     * Returns a new Knapsack with exactly those Items of this Knapsack
     * whose weight is less than or equal to the specified method parameter.
     * Does not modify this Knapsack.
     *
     * @param maxItemWeightInGrammes the maximum weight in grammes for the
     *  Items in the new Knapsack
     * @return a new Knapsack with exactly those Items of this Knapsack
     *  whose weight is less than or equal to the specified method parameter
     */
    public Knapsack makeNewKnapsackWith(int maxItemWeightInGrammes) {
		Knapsack newKnapsack = new Knapsack(); // create a new Knapsack
		for(Item x: items){
			if(x != null && x.getWeightInGrammes() <= maxItemWeightInGrammes) {
				newKnapsack.add(x);
			}
		}
        return newKnapsack;
    }

    /**
     * Returns a string representation of this Knapsack. The string
     * representation consists of a list of the Knapsack's contents,
     * enclosed in square brackets ("[]"). Adjacent Items are
     * separated by the characters ", " (comma and space). Items are
     * converted to strings as by their toString() method. The
     * representation does not mention any null references.
     *
     * So for
     *
     * Item i1 = new Item("Pen", 15);
     * Item i2 = new Item("Letter", 20);
     * Item i3 = null;
     * Item[] items = { i1, i2, i3, i1 };
     * Knapsack k = new Knapsack(items);
     *
     * the call k.toString() will return one of the three following Strings:
     *
     * "[(Pen, 15), (Pen, 15), (Letter, 20)]"
     * "[(Pen, 15), (Letter, 20), (Pen, 15)]"
     * "[(Letter, 20), (Pen, 15), (Pen, 15)]"
     *
     * @return a String representation of this Knapsack
     * @see java.lang.Object#toString()
     */
    @Override
    public String toString() {

		return "" + this.items; // use the arraylist toString and cast to string
    }

    /* class methods */

    /**
     * Class method to return a Knapsack with the highest total weight from an
     * array of Knapsacks. If we have an array with a Knapsack of 3000 grammes
     * and a Knapsack with 4000 grammes, the Knapsack with 4000 grammes is
     * returned.
     *
     * Entries of the array may be null, and your method should work also in
     * the presence of such entries. So if in the above example we had an
     * additional third array entry null, the result would be exactly the same.
     *
     * If there are several Knapsacks with the same weight, it is up to the
     * method implementation to choose one of them as the result (i.e., the
     * choice is implementation-specific, and method users should not rely on
     * any particular behaviour).
     *
     * @param knapsacks must not be null, but may contain null
     * @return one of the Knapsacks with the highest total weight among all
     *  Knapsacks in the parameter array; null if there is no non-null
     *  reference in knapsacks
     */
    public static Knapsack heaviestKnapsack(Knapsack[] knapsacks) {
		
		if(knapsacks == null || knapsacks.length < 1) // if it's empty then return 1
			return null;

		int count = 0; // count non-null knapsacks
		Knapsack heaviest = new Knapsack();
		for(Knapsack k: knapsacks){
			if(k != null) {
				count++;
				if(k.totalWeightInGrammes() > heaviest.totalWeightInGrammes()) {
					heaviest = k; //update the heaviest
				}
			}
		
		}
        
		if(count > 0)
			return heaviest; // there is atleast 1 valid knapsack

		return null; // return null by default
    }
}
