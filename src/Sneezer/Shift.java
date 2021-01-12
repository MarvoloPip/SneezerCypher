package Sneezer;


/**
 * Class that defines a shift and holds its properties
 * 
 */
public class Shift {
	
	// insstance vars
	int value;
	String dir;

	/**
	 * Constructor
	 * 	 * 
	 */
	public Shift(int v, String s) {
		// Precondition: s is either '+' or '-'
		//				 v  >= -1
	
		this.value = v;
		this.dir = s;
	}
	

	/**
	 * Method to check weather the direction of the shift is forward
	 * 
	 * @return: true if teh direction is positive
	 * 
	 */
	public boolean isPos() {
		return dir == "+";
	}

}
