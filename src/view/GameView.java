package view;

import java.util.ArrayList;

import javafx.application.Application;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.geometry.Insets;
import javafx.scene.Group;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.Background;
import javafx.scene.layout.BackgroundFill;
import javafx.scene.layout.CornerRadii;
import javafx.scene.layout.Pane;
import javafx.scene.layout.StackPane;
import javafx.scene.paint.Color;
import javafx.scene.shape.Polygon;
import javafx.stage.Stage;
import model.GameModel;

/*
 * @author Michael and Lok Ian Vong
 * Class that creates the game window
 */

public class GameView {
	GameModel gameModel = new GameModel();
	public Pane root = new Pane();

	public void setObservable(GameModel gameModel) {
		this.gameModel = gameModel;
	}

	/*public static void main(String[] args) {
		launch(args);
	}*/

	public Parent getRoot() {

		//add background color
		BackgroundFill back = new BackgroundFill(Color.BLACK, new CornerRadii(1), new Insets(0.0,0.0,0.0,0.0));
		this.root.setBackground(new Background(back));
		
		//add Lives Label
		Label lives = new Label("Lives:");
		lives.setTextFill(Color.WHITE);
		
		//add Life Images to show remaining life for user
		Image life = new Image(getClass().getResourceAsStream("oneLife.png"));
		lives.setGraphic(new ImageView(life));
		this.root.getChildren().add(lives);
		
		//add Score Label to show score
		Label score = new Label("Test");
		score.setTextFill(Color.WHITE);
		this.root.getChildren().add(score);
		
		//add Time Label to show the on-going time of the game 
		Label time=new Label("Time");
		time.setTextFill(Color.WHITE);
		this.root.getChildren().add(time);
		
		//add Button for Reset
		Button reset = new Button("Reset");
		reset.setTextFill(Color.WHITE);
		this.root.getChildren().add(reset);
		
		
		
		// retrieving polygon from GameModel
		ArrayList<Polygon> addedPolygon = new ArrayList<Polygon>();
		addedPolygon = gameModel.getAddedPolygons();
		
		//Iterating through addedPolygon and adding them to screen 
		for (int counter = 0; counter < addedPolygon.size(); counter++) {
			this.root.getChildren().add(addedPolygon.get(counter));
		}
		this.root.maxHeight(GameModel.SCREEN_HEIGHT);
		this.root.maxWidth(GameModel.SCREEN_WIDTH);
		//add score, life, and time labels, and reset button
		//primaryStage.show();
		return this.root;
	}

	public void update() {
		
		//addedPolygon and removedPolygon keep tracks of the asteroid that are added by the Model
		//or removed by user's action during the game
		ArrayList<Polygon> addedPolygon = new ArrayList<Polygon>();
		ArrayList<Polygon> removedPolygon = new ArrayList<Polygon>();
		
		//pass reference of the ArrayList from Model to local variable
		addedPolygon = gameModel.getAddedPolygons();
		removedPolygon = gameModel.getRemovedPolygons();
		
		//Iterating through addedPolygon and adding them to screen 
		for (int counter = 0; counter < addedPolygon.size(); counter++) {
			this.root.getChildren().add(addedPolygon.get(counter));
		}
		
		//Iterating through removedPolygon and removing them from screen
		for (int counter = 0; counter < removedPolygon.size(); counter++) {
			this.root.getChildren().remove(removedPolygon.get(counter));
		}

	}
	
	
	
	
	
	//

}
