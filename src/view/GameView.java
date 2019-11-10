package view;

import java.util.ArrayList;
import java.util.Observable;

import javafx.application.Application;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.geometry.Insets;
import javafx.scene.Group;
import javafx.scene.Node;
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
	public Group root = new Group();
	public Pane screen = new Pane();
	ToolBar bar = new ToolBar();

	public void setObservable(GameModel gameModel) {
		this.gameModel = gameModel;
	}

	/*public static void main(String[] args) {
		launch(args);
	}*/

	public Parent getRoot() {

		//add background color
		BackgroundFill back = new BackgroundFill(Color.BLACK, new CornerRadii(1), new Insets(0.0,0.0,0.0,0.0));
<<<<<<< HEAD
		this.screen.setBackground(new Background(back));
		
		//add Lives Label
		Label lives = new Label("Lives:");
		lives.setTextFill(Color.WHITE);
		
		//add Life Images to show remaining life for user
		Image life = new Image(getClass().getResourceAsStream("oneLife.png"));
		lives.setGraphic(new ImageView(life));
		this.root.getChildren().add(lives);
		
		
		
=======
		
		Label lifeImage = new Label();
		lifeImage.setId("lives");
		
		//add Score Label to show score
		Label score = new Label("Score: ");
>>>>>>> e471511b79bcf29762361676259540b8b7aa2b11
		score.setTextFill(Color.WHITE);
		Label scoreNum = new Label("0");
		scoreNum.setTextFill(Color.WHITE);
		scoreNum.setId("score");
		
		
		Label timeNum = new Label("0");
		timeNum.setTextFill(Color.WHITE);	
		timeNum.setId("time");
		
		
		
<<<<<<< HEAD
		//add Time Label to show the on-going time of the game 
		Label time=new Label("Time");
		time.setTextFill(Color.WHITE);
		this.root.getChildren().add(time);
		
		//add Button for Reset
		Button reset = new Button("Reset");
		reset.setTextFill(Color.WHITE);
		this.root.getChildren().add(reset);
		
		
=======
		Label separator1 = new Label("            ");
		Label separator2 = new Label("            ");
		Label separator3 = new Label("            ");
		
		bar.setBackground(new Background(back));
		bar.getItems().addAll(lives, lifeImage, separator1, score, scoreNum, separator2, time, timeNum, separator3, reset);
>>>>>>> e471511b79bcf29762361676259540b8b7aa2b11
		
		// retrieving polygon from GameModel
		ArrayList<Polygon> addedPolygon = new ArrayList<Polygon>();
		addedPolygon = gameModel.getAddedPolygons();
		
		//Iterating through addedPolygon and adding them to screen 
		for (int counter = 0; counter < addedPolygon.size(); counter++) {
			screen.getChildren().add(addedPolygon.get(counter));
		}
		screen.maxHeight(GameModel.SCREEN_HEIGHT);
		screen.maxWidth(GameModel.SCREEN_WIDTH);
		screen.minHeight(GameModel.SCREEN_HEIGHT);
		screen.minWidth(GameModel.SCREEN_WIDTH);
		screen.setBackground(new Background(back));
		//add score, life, and time labels, and reset button
		//primaryStage.show();
		root.getChildren().addAll(screen, bar);
		return root;
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
			screen.getChildren().add(addedPolygon.get(counter));
		}
		
		//Iterating through removedPolygon and removing them from screen
		for (int counter = 0; counter < removedPolygon.size(); counter++) {
			screen.getChildren().remove(removedPolygon.get(counter));
		}
		
		for(Node child : bar.getItems()) {
			if(child.getId() == "score") {
				
			}
			else if(child.getId() == "lives") {
				
			}
			else if(child.getId() == "time") {
				
			}
		}

	}
	
	
	
	
	
	//

}
