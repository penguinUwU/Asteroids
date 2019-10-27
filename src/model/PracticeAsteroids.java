package model;

import javafx.application.Application;
import javafx.scene.Group;
import javafx.scene.Scene;
import javafx.scene.shape.Polygon;
import javafx.stage.Stage;

/* This is class to practice making shapes for the game.
 * 
 * */

public class PracticeAsteroids extends Application {

	@Override
	public void start(Stage arg0) throws Exception {
		Polygon hexagon = new Polygon();
		hexagon.getPoints().addAll(new Double[]{        
				   200.0, 50.0, 
				   400.0, 50.0, 
				   450.0, 150.0,          
				   400.0, 250.0, 
				   200.0, 250.0,                   
				   150.0, 150.0, 
		});
		
		//Creating a Group object  
	      Group root = new Group(hexagon); 
	         
	      //Creating a scene object 
	      Scene scene = new Scene(root, 600, 300);  
	      
	      //Setting title to the Stage 
	      arg0.setTitle("Drawing a Polygon"); 
	         
	      //Adding scene to the stage 
	      arg0.setScene(scene); 
	      
	      //Displaying the contents of the stage 
	      arg0.show(); 
	}   
	
	public static void main(String args[]){ 
	      launch(args); 
	   } 
	
}
