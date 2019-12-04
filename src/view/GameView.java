package view;

import java.util.ArrayList;
import controller.ButtonPressEventHandler;
import controller.GameController;

import java.util.Observable;
import java.util.Observer;

import javafx.geometry.Insets;
import javafx.scene.Group;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.ToolBar;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.Background;
import javafx.scene.layout.BackgroundFill;
import javafx.scene.layout.CornerRadii;
import javafx.scene.layout.Pane;
import javafx.scene.paint.Color;
import javafx.scene.shape.Polygon;
import model.GameModel;

/*
 * @author Michael and Lok Ian Vong
 * Class that creates the game window
 */

public class GameView implements Observer{
	private Group root = new Group();
	private Pane screen = new Pane();
	private ToolBar bar = new ToolBar();

	/**
	 * Designs the screen and gamebar elements
	 * @param controller, the instance of the controller to set up the button
	 * @return Parent, used to initialize the window by the game controller
	 */
	public Parent getRoot(GameController controller) {
		
		//create background color
		BackgroundFill back = new BackgroundFill(Color.BLACK, new CornerRadii(1), new Insets(0.0,0.0,0.0,0.0));
		
		//create lives label
		Label lives = new Label("Lives:");
		lives.setTextFill(Color.WHITE);
		Label lifeImage = new Label();
		Image life = new Image(getClass().getResourceAsStream("/view/oneLife.png"));
		lifeImage.setGraphic(new ImageView(life));
		lifeImage.setId("lives");
		
		//create score label
		Label score = new Label("Score: ");
		score.setTextFill(Color.WHITE);
		Label scoreNum = new Label("0");
		scoreNum.setTextFill(Color.WHITE);
		scoreNum.setId("score");
		
		//create time label
		Label time = new Label("Time: ");
		time.setTextFill(Color.WHITE);		
		Label timeNum = new Label("0");
		timeNum.setTextFill(Color.WHITE);	
		timeNum.setId("time");
		
		//create reset button, bind it to event handler in controller package
		Button reset = new Button("reset");
		reset.setDefaultButton(false );
		ButtonPressEventHandler handle = new ButtonPressEventHandler(controller);
		reset.setOnAction(handle);
		
		//create separators between each label
		Label separator1 = new Label("            ");
		Label separator2 = new Label("            ");
		Label separator3 = new Label("            ");
		
		//put all labels and buttons onto the gamebar
		bar.setBackground(new Background(back));
		bar.getItems().addAll(lives, lifeImage, separator1, score, scoreNum, separator2, time, timeNum, separator3, reset);
		
		//define screen parameters and set background
		screen.maxHeight(GameModel.SCREEN_HEIGHT);
		screen.maxWidth(GameModel.SCREEN_WIDTH);
		screen.minHeight(GameModel.SCREEN_HEIGHT);
		screen.minWidth(GameModel.SCREEN_WIDTH);
		screen.setBackground(new Background(back));
		
		//add both the screen and the game bar to the display window
		root.getChildren().addAll(screen, bar);
		return root;
	}

	/**
	 * Updates what the screen is showing, adding/removing polygons and updating gamebar
	 * Called by the controller in the main game loop
	 * @param Observable o, the game instance
	 */
	public void update(Observable o, Object args) {
		ArrayList<Polygon> addedPolygon = new ArrayList<Polygon>();
		ArrayList<Polygon> removedPolygon = new ArrayList<Polygon>();
		
		addedPolygon = ((GameModel)o).getAddedPolygons();
		removedPolygon = ((GameModel)o).getRemovedPolygons();
		//Iterating through addedPolygon and adding them to screen 
		for (int counter = 0; counter < addedPolygon.size(); counter++) {
			this.screen.getChildren().add(addedPolygon.get(counter));
		}
		
		//Iterating through removedPolygon and removing them from screen
		for (int counter = 0; counter < removedPolygon.size(); counter++) {
			this.screen.getChildren().remove(removedPolygon.get(counter));
		}
		
		//Updating items on the game bar, such as score, lives, and time
		for(Node child : bar.getItems()) {
			if(child.getId() == "score") {
				((Label)child).setText(String.valueOf(((GameModel)o).getScore()));
			}
			else if(child.getId() == "lives") {
				int lives = ((GameModel)o).getLives();
				if(lives == 3) {
					Image life = new Image(getClass().getResourceAsStream("/view/threeLife.png"));
					((Label)child).setGraphic(new ImageView(life));
				}
				else if(lives == 2) {
					Image life = new Image(getClass().getResourceAsStream("/view/twoLife.png"));
					((Label)child).setGraphic(new ImageView(life));
				}
				else {
					Image life = new Image(getClass().getResourceAsStream("/view/oneLife.png"));
					((Label)child).setGraphic(new ImageView(life));
				}
			}
			else if(child.getId() == "time") {
				//not implemented
			}
		}

	}

}
