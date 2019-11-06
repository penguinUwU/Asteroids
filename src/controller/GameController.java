package controller;

import java.util.HashMap;

import javafx.animation.AnimationTimer;
import javafx.application.Application;
import javafx.scene.Group;
import javafx.scene.Scene;
import javafx.scene.canvas.Canvas;
import javafx.scene.input.KeyCode;
import javafx.stage.Stage;
import model.GameModel;
import view.GameView;

public class GameController extends Application {
	
	private GameView gameView;
	private GameModel gameModel;
	
    private HashMap<KeyCode, String> controls;
	private HashMap<String, Boolean> inputs;
	private double pollTime = 0;
	private long previousTime = 0;
	
	/**
	 * resets all game values to its default values
	 */
	public void resetGame() {
		// new GameView and GameModel objects
		gameView = new GameView();
		gameModel = new GameModel();
		
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
	}
	
	/**
	 * starts the game
	 */
	@Override
	public void start(Stage stage) {
		// reset all values
		resetGame();
		
		// create the Label and Scene
		stage.setTitle("Space Rocks");
		Scene scene = new Scene(this.gameView.getRoot(), GameModel.SCREEN_HEIGHT, GameModel.SCREEN_WIDTH);
		stage.setScene(scene);
		stage.setMaxHeight(GameModel.SCREEN_HEIGHT);
		stage.setMinHeight(GameModel.SCREEN_HEIGHT);
		stage.setMaxWidth(GameModel.SCREEN_WIDTH);
		stage.setMinWidth(GameModel.SCREEN_WIDTH);
		stage.show();

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
		
		
		// create game loop, defaults to 60 fps
		AnimationTimer gameLoop = new AnimationTimer() {
			@Override
			public void handle(long currentTime) {
				// calculate time since last update
		        pollTime = (currentTime - previousTime);
		        previousTime = currentTime;
		        
		        // updates game model, then game view
		        //gameModel.update(pollTime, inputs);
		        gameView.update();
			}
		};
		
		// set up timers
		final long startTime = System.nanoTime();
		previousTime = startTime;
		
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
