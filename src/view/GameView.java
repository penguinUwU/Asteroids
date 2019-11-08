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
		
		Label score = new Label("Test");
		score.setTextFill(Color.WHITE);
		this.root.getChildren().add(score);
		
		
		Label lives = new Label("Lives:");
		lives.setTextFill(Color.WHITE);
		Image life = new Image(getClass().getResourceAsStream("life.png"));
		lives.setGraphic(new ImageView(life));
		this.root.getChildren().add(lives);
		
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
		ArrayList<Polygon> addedPolygon = new ArrayList<Polygon>();
		ArrayList<Polygon> removedPolygon = new ArrayList<Polygon>();
		
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

}
