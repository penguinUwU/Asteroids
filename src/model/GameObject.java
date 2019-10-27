package model;
import javafx.scene.shape.Polygon;

/*
 * This is abstract class for the game objects (e.x. player, asteroid etc.)
 * 
 * 
 * @author Abhay and Mathieu.
 * 
 * */

public abstract class GameObject {
	
	private float velX;
	private float velY;
	protected Polygon body;
	
	public GameObject() {
		this.body = new Polygon();
	}
	
	/*
	 * This is the abstract class update. Implementation varies on game object.
	 * 
	 * This updates the position of object based on whether the object wants to
	 * move forward, and checks if they turn in delta time. 
	 * @param dt delta-time representing how long the player is moving forward.
	 * @param moveForward is a boolean which states if the user is moving forward.
	 * @param turnRight is a boolean which states if the user is turning right. 
	 * @param turnLeft is a boolean which states if the user is turning left. 
	 * @return none
	 * */
	public abstract void update(float dt, boolean moveForward, boolean turnRight, boolean turnLeft);
		
	/*
	 * @return the shape of the object.
	 * */
	public Polygon getBody() {
		return this.body;
	}
}
