package Sneezer;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.regex.Matcher;
import java.util.regex.Pattern;


/**
 * The class for the cipher. Also performs the necessary operations 
 * that come with it
 *  
 */
public class Cypher {

	// instance vars
	Shift shift;
	String og;
	String update;
	int bf = 0;
	

	/**
	 * Constructor method
	 * 
	 */
	public Cypher(String t, Shift s) {
		this.shift = s;
		this.og = t;
		this.update = "";
	}
		

	/**
	 * encrypt method
	 * 
	 * @return: the ciphered string
	 * 
	 */
	public String encrypt() {
				
		char[] ch = this.og.toCharArray();
 		String newCh = "";
		
		for (int i = 0; i < ch.length; i++) {
			
			// get ascii value
			int oldVal = (int)ch[i];
			int newVal = oldVal;
				
			if (this.shift.isPos()) {
				newVal = oldVal + this.shift.value;
			}
			else 
				newVal = oldVal - this.shift.value;
			//System.out.println("og val " + newVal);
				
			while (!((32 <= newVal) && (newVal <= 126))) {
				newVal = adjust(newVal);
				//System.out.println("adjusted " + newVal);

			}
				
			newCh += Character.toString((char)newVal);
		}
	
		this.update = newCh;
		return newCh;
	}
	

	/**
	 * bruteforce method
	 * 
	 */
	public void bruteForce() {
		ArrayList<String> al = new ArrayList<String>();
		
		this.shift.dir = "-";
		for (int i = 0; i <= this.bf; i++) {
			this.shift.value = i;
			al.add(this.encrypt());
		}
		
		String out = "";
		
		for (String s: al) {
			out += s.toString();
			out += "\n";
		}
		
		try {
		      FileWriter w = new FileWriter("guesses.txt");
		      w.write(out);
		      w.close();
		    }
		catch (IOException e) {
		      e.printStackTrace();
		    }		
	}
	
	/**
	 * adjust the value if its not between 32 and 126
	 * to loop around 
	 * 
	 * @param: the old value
	 * @return: the adjusted value
	 * 
	 */
	public static int adjust(int num) {
		
		if (num > 126) {
			return (num-126)+32; 
		}
		else if (num < 32) {
			return 126 -(32-num);
		}
		else return num;
	}
	
	public void bfRange(int n) {
		this.bf = n;
	}
			
}
