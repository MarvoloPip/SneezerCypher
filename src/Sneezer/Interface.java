package Sneezer;

import java.io.File;
import java.io.IOException;

// imports
import javafx.application.Application;  
import javafx.geometry.Insets;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.SplitPane;
import javafx.scene.control.TextField;
import javafx.stage.Stage;
import javafx.scene.layout.*;

public class Interface extends Application{
	
	// vars 
	protected static SplitPane sp;
	protected static Button home, enc, dec, bf, go, go2;
	protected static Scene mainScene;
	protected static TextField input, output,input2, output2, key, key2, bfb; 
	protected static VBox encBox, decBox, left, instrL;
	//protected static Label instrL;
	
	// global listener
	Listener lol = new Listener();
	
	// Main method
	public static void main(String[] args) {
		launch(args);
	}
	

	@Override
	// Start method for application
	public void start(Stage stage) throws Exception {
		// TODO Auto-generated method stub
						
		sp = new SplitPane();
				
		encBox = this.encPage();
		decBox = this.decPage();
		instrL = this.homePage();
		
		left = new VBox();
		left.setCenterShape(true);
		left.setPadding(new Insets(75));
		left.setSpacing(70);
	
		home = new Button("Home");
		home.setOnAction(lol);
		enc = new Button("Encrpytion");
		enc.setOnAction(lol);
		dec = new Button("Decryption");		
		dec.setOnAction(lol);

		
		left.getChildren().addAll(home, enc, dec);
		
		sp.getItems().add(left);
		//sp.getItems().add(this.decPage());
		sp.setDividerPositions(0.23f);
		
		mainScene = new Scene(sp, 1100, 400);
		
		stage.setTitle("SneezerCypher");
		stage.setScene(mainScene);
		stage.show();
		
	}
	
	public VBox encPage() {
		
		go = new Button("go");
		go.setOnAction(lol);
		
		HBox h1 = new HBox();
		h1.setSpacing(10);
		h1.setPadding(new Insets(20));

		HBox h2 = new HBox();
		h2.setSpacing(20);
		h2.setPadding(new Insets(20));
		
		HBox h3 = new HBox();
		h3.setSpacing(20);
		h3.setPadding(new Insets(20));
		
		HBox h4 = new HBox();
		h4.setSpacing(20);
		h4.setPadding(new Insets(20));		
		
		input = new TextField();
		input.setMinWidth(275);
		input.setPromptText("input");
		output = new TextField();
		output.setMinWidth(275);
		output.setEditable(false);
		output.setPromptText("output");
		
		key = new TextField();
		key.setMaxWidth(95);
		
		Label arrow = new Label("->");
		
		Label l2 = new Label("\t\t\t\t\t\t Shift key:");
				
		h1.getChildren().addAll(input, arrow, output, go);
		h3.getChildren().addAll(l2, key);
		
		VBox gp = new VBox();
		gp.setSpacing(50);
		gp.setPadding(new Insets(80));
		
		gp.getChildren().addAll(h1, h3);
		
		return gp;
		
	}
	
	public VBox decPage() {
		
		go2 = new Button("go");
		go2.setOnAction(lol);
		
		bf = new Button("BRUTEFORCE");
		bf.setOnAction(lol);
		
		HBox h1 = new HBox();
		h1.setSpacing(10);
		h1.setPadding(new Insets(20));

		HBox h2 = new HBox();
		h2.setSpacing(20);
		h2.setPadding(new Insets(20));
		
		HBox h3 = new HBox();
		h3.setSpacing(20);
		h3.setPadding(new Insets(20));
		
		HBox h4 = new HBox();
		h4.setSpacing(20);
		h4.setPadding(new Insets(20));		
		
		input2 = new TextField();
		input2.setMinWidth(275);
		input2.setPromptText("input");
		output2 = new TextField();
		output2.setMinWidth(275);
		output2.setEditable(false);
		output2.setPromptText("output");
		
		key2 = new TextField();
		key2.setMaxWidth(95);
		
		bfb = new TextField();
		bfb.setMaxWidth(95);
		
		Label arrow = new Label("->");
		
		Label l2 = new Label("\t\t\t Shift key (leave empty if bruteforce):");
		Label l3 = new Label("\t\t\t\t\t");
				
		h1.getChildren().addAll(input2, arrow, output2, go2);
		h3.getChildren().addAll(l2, key2);
		h4.getChildren().addAll(l3, bf, bfb);
		
		VBox gp = new VBox();
		gp.setSpacing(50);
		gp.setPadding(new Insets(80));
		
		gp.getChildren().addAll(h1, h3, h4);
		
		return gp;
		
	}
	
	public VBox homePage() {
		
		VBox v = new VBox();
		v.setPadding(new Insets(80));
				
		Label inst = new Label();
		inst.setText("Welcome to the SneezerCypher! \n" + 
				"\n" + 
				"This is a variation of the Caesar Cipher using ASCII where you will be able to shift characters\n"
				+ "in the forward direction"
				+ 
				"For example, the character ‘A’ has an ASCII value of 65. Using a shift of \n"
				+ "+3, it will become the "
				+ "character "
				+ "with the ASCII value of 65+3=68 which is ‘D’ \n" + 
				"\n" +  
				"There isn’t a limit of how big your shift value can be since if it exceeds the range of symbols, it \n"
				+ "will just loop"
				+ " around back to the first symbol it recognizes. I.e if the range of symbols\n"
				+ " is “abc”, a shift of +2 and +5 on "
				+ "“a” will each result in “c” \n" + 
				"\n" + 
				"You also have an option to decipher encrypted texts as long as you know the shift key. If you\n"
				+ "are unsure, "
				+ "you will need to input a value (v) and it output results of using shift keys from 0 - v\n"
				+ 
				"\n" + 
				"Have fun! \n" + 
				"");
		
		v.getChildren().add(inst);
		
		return v;
	}

}
