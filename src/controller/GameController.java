package controller;

import java.util.HashMap;
import java.util.concurrent.TimeUnit;

import javafx.animation.AnimationTimer;
import javafx.application.Application;
import javafx.scene.Group;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.canvas.Canvas;
import javafx.scene.input.KeyCode;
import javafx.scene.paint.Color;
import javafx.stage.Stage;
import model.GameModel;
import view.GameView;

public class GameController extends Application {
	
	private GameView gameView;
	private GameModel gameModel;
	private Scene scene;
	private Stage stage;
	
    private HashMap<KeyCode, String> controls;
	private HashMap<String, Boolean> inputs;
	private double pollTime;
	private double previousTime;
	
	/**
	 * resets all game values to its default values
	 */
	public void resetGame() {
		//NEEDS WORK, need to re-attach the scene and gameview
		// new GameView and GameModel objects
		gameView = new GameView();
		gameModel = new GameModel();
		gameModel.addObserver(gameView);
		
		// create the Label and Scene
		stage.setTitle("Space Rocks");
		Parent root = gameView.getRoot(this);
		scene = new Scene(root, GameModel.SCREEN_HEIGHT, GameModel.SCREEN_WIDTH);
		scene.setFill(Color.BLACK);
		stage.setScene(scene);
		stage.setResizable(false);
		stage.setMaxHeight(GameModel.SCREEN_HEIGHT);
		stage.setMinHeight(GameModel.SCREEN_HEIGHT);
		stage.setMaxWidth(GameModel.SCREEN_WIDTH);
		stage.setMinWidth(GameModel.SCREEN_WIDTH);
		stage.show();
		root.requestFocus();
		
		// bind keys to actions
		controls = new HashMap<>();
		controls.put(KeyCode.W, "moveForward");
		controls.put(KeyCode.D, "turnRight");
		controls.put(KeyCode.A, "turnLeft");
		controls.put(KeyCode.SPACE, "shoot");
		
		// set default action states
		inputs = new HashMap<>();
		inputs.put("moveForward", false);
		inputs.put("turnRight", false);
		inputs.put("turnLeft", false);
		inputs.put("shoot", false);
		
		// reset time variables
		pollTime = 0;
		previousTime = 0;
		
		
		// set action of key presses
		scene.setOnKeyPressed(e -> {
			KeyCode key = e.getCode();
			
			if (controls.containsKey(key)) {
				inputs.put(controls.get(key), true);
			}
		});
		
		// set action of key releases
		scene.setOnKeyReleased(e -> {
			KeyCode key = e.getCode();
			
			if (controls.containsKey(key)) {
				inputs.put(controls.get(key), false);
			}
		});
	}
	
	/**
	 * starts the game
	 */
	@Override
	public void start(Stage stage) {
		// reset all values
		this.stage = stage;
		resetGame();

		// create game loop, defaults to 60 fps
		AnimationTimer gameLoop = new AnimationTimer() {
			@Override
			public void handle(long currentTime) {
				//check if previousTime has not been set
				if (previousTime == 0) {
					previousTime = ((double)currentTime) / 1000000000;
				}
		        pollTime = ((double)currentTime) / 1000000000 - previousTime;
		        previousTime = ((double)currentTime) / 1000000000;
		        
		        gameModel.update(pollTime, inputs);
		        if (gameModel.isGameOver()) {
		        	resetGame();
		        }
			}
		};
		
		// start game loop
		gameLoop.start();
		
		// show scene
		stage.show();
	}
	
	/**
	 * launches the game
	 * @param args
	 */
	public static void main(String[] args) {
		launch(args);
	}
}
