package view;

import java.util.ArrayList;

import javafx.application.Application;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.geometry.Insets;
import javafx.scene.Group;
import javafx.scene.Scene;
import javafx.scene.control.Button;
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

public class GameView extends Application {
	GameModel gameModel = new GameModel();
	public Pane root = new Pane();

	public void setObservable(GameModel gameModel) {
		this.gameModel = gameModel;
	}

	public static void main(String[] args) {
		launch(args);
	}

	/*
	 * Creates a window of specified height (in this case 300, 200) and initializes
	 * all game objects as children of the root
	 * 
	 * @param primaryStage the main stage (window) where the game will execute
	 */
	@Override
	public void start(Stage primaryStage) {
		primaryStage.setTitle("Space Rocks");

		//add background color
		BackgroundFill back = new BackgroundFill(Color.BLACK, new CornerRadii(1), new Insets(0.0,0.0,0.0,0.0));
		this.root.setBackground(new Background(back));

		// root.getChildren().add();
		// uncomment ^^^ after figuring out the adding procedure for game objects
		primaryStage.setScene(new Scene(this.root, GameModel.SCREEN_HEIGHT, GameModel.SCREEN_WIDTH));
		
		// retrieving polygon from GameModel
		ArrayList<Polygon> addedPolygon = new ArrayList<Polygon>();
		addedPolygon = gameModel.getAddedPolygons();
		
		//Iterating through addedPolygon and adding them to screen 
		for (int counter = 0; counter < addedPolygon.size(); counter++) {
			this.root.getChildren().add(addedPolygon.get(counter));
		}
		
		primaryStage.show();
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
