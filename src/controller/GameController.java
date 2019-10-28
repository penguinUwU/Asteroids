package controller;

import java.util.HashMap;

import javafx.application.Application;
import javafx.event.EventHandler;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.scene.input.KeyEvent;
import javafx.scene.layout.Pane;
import javafx.stage.Stage;

public class GameController extends Application {
	
	private Pane root = new Pane();
	
    private HashMap<Character, String> controls = new HashMap<>();
	private HashMap<String, Boolean> inputs = new HashMap<>();
	private float keyHoldTime;
	
	/**
	 * launches the game
	 * @param args
	 */
	public static void main(String[] args) {
		Application.launch(args);
	}
	
	/**
	 * creates the pane for the game
	 * @return the Pane object of the game
	 */
	private Parent createParent() {
		root.setPrefSize(1080, 1920);
		
		root.getChildren();
		
		return root;
	}
	
	/**
	 * starts the game
	 */
	@Override
	public void start(Stage stage) {
		// Create the Label and Scene
		Label label = new Label("Space Rocks");
		Scene scene = new Scene(createParent());
		
		// read key presses on the scene
		scene.setOnKeyTyped(new EventHandler<KeyEvent>() {
			public void handle(final KeyEvent keyEvent) {
				readEvent(keyEvent);
			}
		});
	}
	
	/**
	 * reads the keyboard event
	 * @param e
	 */
	public void readEvent(KeyEvent e) {
		// read event
		String s = e.getCharacter();

		for(int i=0; i<s.length(); i++) {
			char c = s.charAt(i);
			
			// read relevant keys only
			if (controls.containsKey(c))
				inputs.put(controls.get(c), true);
		}
		
		// consumed event if it is not already consumed
		if (!e.isConsumed())
			e.consume();
    }
	
	/**
	 * resets all game values to its default values
	 */
	public void restartGame() {
		controls.put('w', "moveForward");
		controls.put('d', "turnRight");
		controls.put('a', "turnLeft");
		controls.put(' ', "shoot");
		
		inputs.put("moveForward", false);
		inputs.put("turnRight", false);
		inputs.put("turnLeft", false);
		inputs.put("shoot", false);
		
		keyHoldTime = 0f;
	}
}
