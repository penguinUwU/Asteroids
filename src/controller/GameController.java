package controller;

import java.util.HashMap;

import javafx.animation.AnimationTimer;
import javafx.application.Application;
import javafx.scene.Group;
import javafx.scene.Scene;
import javafx.scene.canvas.Canvas;
import javafx.stage.Stage;

public class GameController extends Application {
	
    private HashMap<String, String> controls = new HashMap<>();
	private HashMap<String, Boolean> inputs = new HashMap<>();
	private double pollTime = 0;
	private long previousTime = 0;
	
	/**
	 * starts the game
	 */
	@Override
	public void start(Stage stage) {
		// reset all values
		resetGame();
		
		// set title of stage
		stage.setTitle("Space Rocks");
		
		// create and use group for the scene and stage
		Group root = new Group();
		Scene scene = new Scene(root);
		stage.setScene(scene);
		
		// create and use canvas
		Canvas canvas = new Canvas(600, 800);
        root.getChildren().add(canvas);
		
        
		// set action of key presses
		scene.setOnKeyPressed(e -> {
			String key = e.getCharacter();
			
			if (controls.containsKey(key)) {
				inputs.put(key, true);
			}
		});
		
		// set action of key releases
		scene.setOnKeyReleased(e -> {
			String key = e.getCharacter();
			
			if (controls.containsKey(key)) {
				inputs.put(key, false);
			}
		});
		
		
		// create game loop, defaults to 60 fps
		AnimationTimer gameLoop = new AnimationTimer() {
			@Override
			public void handle(long currentTime) {
				// calculate time since last update
		        pollTime = (currentTime - previousTime); // / 1000000000.0;
		        previousTime = currentTime;
		        
		        // update objects
		        // TODO: update stuffs
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
	 * resets all game values to its default values
	 */
	public void resetGame() {
		// bind keys to actions
		controls.put("w", "moveForward");
		controls.put("d", "turnRight");
		controls.put("a", "turnLeft");
		controls.put(" ", "shoot");
		
		// set default action states
		inputs.put("moveForward", false);
		inputs.put("turnRight", false);
		inputs.put("turnLeft", false);
		inputs.put("shoot", false);
		
		// TODO: instantiate game objects
	}
	
	/**
	 * launches the game
	 * @param args
	 */
	public static void main(String[] args) {
		launch(args);
	}
}
