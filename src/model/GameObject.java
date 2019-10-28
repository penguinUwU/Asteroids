package model;
import javafx.geometry.Point2D;
import javafx.scene.shape.Polygon;

/*
 * This is abstract class for the game objects (e.x. player, asteroid etc.)
 * 
 * 
 * @author Abhay and Mathieu.
 * 
 * */

public abstract class GameObject{
	
	protected double velX;
	protected double velY;
	protected Polygon body;
	protected Point2D center;
	
	/*
	 * This is the abstract class update. Implementation varies on game object.
	 * 
	 * This method increments the position of the object by its velocity*dt
	 * @param dt delta-time representing how long the player is moving forward.
	 * @return none
	 * */
	public void update(float dt) {
		this.center = this.center.add(this.velX*dt, this.velY*dt);
		this.body.setTranslateX(this.body.getTranslateX()+this.velX*dt);
		this.body.setTranslateY(this.body.getTranslateY()+this.velY*dt);
	}
		
	/*
	 * @return the shape of the object.
	 * */
	public Polygon getBody() {
		return this.body;
	}
}
