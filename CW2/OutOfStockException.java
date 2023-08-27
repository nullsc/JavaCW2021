/**
 * To be thrown when an Item is attempted to be sold when it is out of stock.
 *
 * @author 
 */
public class OutOfStockException extends RuntimeException {

    /** 
	 * Calls a RuntimeException. 
	 */
	public OutOfStockException() {
		super();
	}

    /** 
	 * Calls a RuntimeException with a custom message. 
	 */
	public OutOfStockException(String msg) {
		super(msg);
	}
	

}
