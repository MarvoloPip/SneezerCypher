package Sneezer;


import java.util.ArrayList;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Cypher {

	Shift shift;
	String og;
	String update;
	int bf = 0;
	
	public Cypher(String t, Shift s) {
		this.shift = s;
		this.og = t;
		this.update = "";
	}
		
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
	
	public ArrayList<String> bruteForce(int v) {
		
		
		ArrayList<String> al = new ArrayList<String>();
		
		this.shift.dir = "+";
		for (int i = 0; i < v; i++) {
			this.shift.value = i;
			al.add(this.encrypt());
		}
				
		return al;
		
	}
	
	// fucked
	
	public static int adjust(int num) {
		
		if (num > 126) {
			return (num-126)+32; 
		}
		else if (num < 32) {
			//System.out.println("MAth " + (126-(int)Math.abs(32-num)));
			return 126 -(32-num);
		}
		else return num;
	}
	
	public void bfRange(int n) {
		this.bf = n;
	}
	
	public static void main(String[] args) {
		
		int key = 234;
		
		Cypher test = new Cypher("niger", new Shift(key, "+"));
		
		String bruh = test.encrypt();
		
		System.out.println(bruh);
		
		Cypher test2 = new Cypher(bruh, new Shift(key, "-"));
		
		System.out.println(test2.encrypt());

//		ArrayList<String> l = test2.bruteForce();
//		for (String s: l) {
//			System.out.println(s);
//		}
		
//		Pattern keyPattern = Pattern.compile("[+-]{1}\\d+");
//		Matcher m = keyPattern.matcher("+20");
//		System.out.println(m.matches());
//		
//		System.out.println("20");
		
		

		
	}
	
	
	
}
