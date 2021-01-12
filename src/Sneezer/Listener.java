package Sneezer;

// imports
import javafx.event.ActionEvent; 
import javafx.event.EventHandler;
import java.util.HashMap;
import javafx.scene.Node;
import javafx.scene.control.Button;
import java.io.IOException;
import java.util.regex.*;

public class Listener implements EventHandler<ActionEvent> {
	
	@Override
	public void handle(ActionEvent e) {
		// TODO Auto-generated method stub

		// key regex
		Pattern keyPattern = Pattern.compile("\\d+\\s*");

		HashMap<Button, Node> hmap = new HashMap();
		// set up the buttons to their corresponding pagess
		hmap.put(Interface.home, Interface.instrL);
		hmap.put(Interface.enc, Interface.encBox);
		hmap.put(Interface.dec, Interface.decBox);
		
		Button evn = (Button) e.getSource();

		if (hmap.containsKey(evn)) {
			if (!(Interface.sp.getItems().contains(evn))) {
        		Interface.sp.getItems().clear();
        		Interface.sp.getItems().add(Interface.left);
        		Interface.sp.getItems().add((Node)hmap.get(evn));
        		Interface.sp.setDividerPositions(0.23f);
        	}
		}
		
		else if (evn == Interface.go) {

			String k = Interface.key.getText();
			k.replaceAll(" ", "");
			
			if (keyPattern.matcher(k).matches()) {
								
				Cypher text = new Cypher(Interface.input.getText(), 
						new Shift(Integer.parseInt(k), "+"));
				
				Interface.output.setText(text.encrypt());
			}
		}
		else if (evn == Interface.go2) {

			String k = Interface.key2.getText();	
			k.replaceAll(" ", "");

			if (keyPattern.matcher(k).matches()) {
				 				
				Cypher text = new Cypher(Interface.input2.getText(), 
						new Shift(Integer.parseInt(k), "-"));
				
				Interface.output2.setText(text.encrypt());
			}
			
		}
		else if (evn == Interface.bf) {
			
			String r = Interface.bfb.getText();
			r.replaceAll(" ","");
			if (keyPattern.matcher(r).matches()) {
				Cypher text = new Cypher(Interface.input2.getText(), 
						new Shift(-1, "-"));
				
				text.bfRange(Integer.parseInt(r));
				text.bruteForce();
				
			}

			
			
		}

	}

}
