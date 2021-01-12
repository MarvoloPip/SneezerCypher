package Sneezer;

public class Shift {
	
	int value;
	int spaceVal;
	String dir;
	
	
	public Shift(int v, String s) {
		// Precondition: s is either '+' or '-'
		//				 v  >= -1
				
		this.value = v;
		this.dir = s;
		
	}
	
	public boolean isPos() {
		return dir == "+";
	}
	
	public boolean brute() {
		return this.value == -1;
	}
	

}
