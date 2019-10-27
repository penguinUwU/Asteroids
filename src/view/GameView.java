package view;

import javafx.application.Application;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.layout.StackPane;
import javafx.stage.Stage;

//Class that creates the game window
public class GameView extends Application{
		
	    public static void main(String[] args) {
	        launch(args);
	    }
	    /*
	     * Creates a window of specified height (in this case 300, 200)
	     * and initializes all game objects as children of the root
	     * 
	     * @param primaryStage the main stage (window) where the game will execute
	     */
	    @Override
	    public void start(Stage primaryStage) {
	        primaryStage.setTitle("Space Rocks");
	        
	        StackPane root = new StackPane();
	        //root.getChildren().add();
	        //uncomment ^^^ after figuring out the adding procedure for game objects
	        primaryStage.setScene(new Scene(root, 300 , 250));
	        primaryStage.show();
	    }
	}
