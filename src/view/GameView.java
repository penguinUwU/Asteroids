package view;

import java.util.ArrayList;
import java.util.Observable;
import java.util.Observer;

import javafx.application.Application;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.geometry.Insets;
import javafx.scene.Group;
import javafx.scene.Parent;
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

public class GameView implements Observer{
	public Pane root = new Pane();

	public Parent getRoot() {

		//add background color
		BackgroundFill back = new BackgroundFill(Color.BLACK, new CornerRadii(1), new Insets(0.0,0.0,0.0,0.0));
		this.root.setBackground(new Background(back));
		this.root.maxHeight(GameModel.SCREEN_HEIGHT);
		this.root.maxWidth(GameModel.SCREEN_WIDTH);
		
		//primaryStage.show();
		return this.root;
	}

	public void update(Observable o, Object args) {
		ArrayList<Polygon> addedPolygon = new ArrayList<Polygon>();
		ArrayList<Polygon> removedPolygon = new ArrayList<Polygon>();
		
		addedPolygon = ((GameModel)o).getAddedPolygons();
		removedPolygon = ((GameModel)o).getRemovedPolygons();
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
