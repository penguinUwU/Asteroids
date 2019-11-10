package view;

import java.util.ArrayList;
import controller.ButtonPressEventHandler;
import controller.GameController;

import java.util.Observable;
import java.util.Observer;

import javafx.application.Application;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.geometry.Insets;
import javafx.scene.Group;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.ToolBar;
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

public class GameView implements Observer{
	public Group root = new Group();
	public Pane screen = new Pane();
	ToolBar bar = new ToolBar();

	public Parent getRoot(GameController controller) {
		//add background color
		BackgroundFill back = new BackgroundFill(Color.BLACK, new CornerRadii(1), new Insets(0.0,0.0,0.0,0.0));
		Label lives = new Label("Lives:");
		lives.setTextFill(Color.WHITE);
		Label lifeImage = new Label();
		Image life = new Image(getClass().getResourceAsStream("onelife.png"));
		lifeImage.setGraphic(new ImageView(life));
		lifeImage.setId("lives");
		
		Label score = new Label("Score: ");
		score.setTextFill(Color.WHITE);
		Label scoreNum = new Label("0");
		scoreNum.setTextFill(Color.WHITE);
		scoreNum.setId("score");
		
		Label time = new Label("Time: ");
		time.setTextFill(Color.WHITE);		
		Label timeNum = new Label("0");
		timeNum.setTextFill(Color.WHITE);	
		timeNum.setId("time");
		
		Button reset = new Button("reset");
		ButtonPressEventHandler handle = new ButtonPressEventHandler(controller);
		reset.setOnAction(handle);
		
		Label separator1 = new Label("            ");
		Label separator2 = new Label("            ");
		Label separator3 = new Label("            ");
		
		bar.setBackground(new Background(back));
		bar.getItems().addAll(lives, lifeImage, separator1, score, scoreNum, separator2, time, timeNum, separator3, reset);
				
		screen.maxHeight(GameModel.SCREEN_HEIGHT);
		screen.maxWidth(GameModel.SCREEN_WIDTH);
		screen.minHeight(GameModel.SCREEN_HEIGHT);
		screen.minWidth(GameModel.SCREEN_WIDTH);
		screen.setBackground(new Background(back));
		
		
		root.getChildren().addAll(screen, bar);
		return root;
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
		
		for(Node child : bar.getItems()) {
			if(child.getId() == "score") {
				((Label)child).setText(String.valueOf(((GameModel)o).getScore()));
			}
			else if(child.getId() == "lives") {
				int lives = ((GameModel)o).getLives();
				if(lives == 3) {
					Image life = new Image(getClass().getResourceAsStream("threelife.png"));
					((Label)child).setGraphic(new ImageView(life));
				}
				else if(lives == 2) {
					Image life = new Image(getClass().getResourceAsStream("twolife.png"));
					((Label)child).setGraphic(new ImageView(life));
				}
				else {
					Image life = new Image(getClass().getResourceAsStream("onelife.png"));
					((Label)child).setGraphic(new ImageView(life));
				}
			}
			else if(child.getId() == "time") {
				//not implemented
			}
		}

	}

}
