package controller;

import java.util.HashMap;

import javafx.animation.AnimationTimer;
import javafx.application.Application;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.input.KeyCode;
import javafx.scene.paint.Color;
import javafx.stage.Stage;
import model.GameModel;
import view.GameView;

/**
 * The Controller in the MVC design pattern.
 * This has the Model object, the View object, user inputs, and the game loop.
 * This is the entry point for the users.
 * When the main function is executed, 
 * the game objects are initiated and the game loop starts.
 * 
 * @author Yichen (Evan) Cui
 *
 */
public class GameController extends Application {
	
	// Model and View objects
	private GameView gameView;
	private GameModel gameModel;
	
	// JavaFX objects
	private Scene scene;
	private Stage stage;
	
	// HashMap for keys to actions
    private HashMap<KeyCode, String> controls;
    // HashMap for actions to action states
	private HashMap<String, Boolean> inputs;
	
	// amount of time between each game loop iteration
	private double pollTime;
	// the time of when the previous game loop iteration was complete
	private double previousTime;
	
	/**
	 * resets all game objects to its default values
	 */
	public void resetGame() {
		// create new GameView and GameModel objects
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
			
			// update inputs HashMap with each key press
			if (controls.containsKey(key))
				inputs.put(controls.get(key), true);
		});
		
		// set action of key releases
		scene.setOnKeyReleased(e -> {
			KeyCode key = e.getCode();
			
			// update inputs HashMap with each key release
			if (controls.containsKey(key))
				inputs.put(controls.get(key), false);
		});
	}
	
	/**
	 * creates the game loop, and start the game
	 * @param stage 
	 */
	@Override
	public void start(Stage stage) {
		this.stage = stage;
		
		// reset all game values
		resetGame();

		// create game loop, capped at 60 iterations per second
		AnimationTimer gameLoop = new AnimationTimer() {
			@Override
			public void handle(long currentTime) {
				// in the first iteration of the game loop,
				// the previousTime should be the currentTime
				if (previousTime == 0)
					previousTime = ((double)currentTime) / 1000000000;
				
				// calculate the time difference between update iterations
		        pollTime = ((double)currentTime) / 1000000000 - previousTime;
		        previousTime = ((double)currentTime) / 1000000000;
		        
		        // update GameModel with time difference and input updates
		        gameModel.update(pollTime, inputs);
		        
		        // when the game is over, the game will restart
		        if (gameModel.isGameOver())
		        	resetGame();
			}
		};
		
		// start game loop and display the scene
		gameLoop.start();
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
