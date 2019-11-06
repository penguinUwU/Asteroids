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
		this.translate(this.velX*dt, this.velY*dt);
		this.wrap();
	}
	
	private void wrap() {
		if (this.center.getX() > GameModel.SCREEN_WIDTH) {
			this.translate(-GameModel.SCREEN_WIDTH, 0);
		} else if (this.center.getX() < 0){
			this.translate(GameModel.SCREEN_WIDTH, 0);
		} else if (this.center.getY() > GameModel.SCREEN_HEIGHT) {
			this.translate(0, -GameModel.SCREEN_HEIGHT);
		} else if (this.center.getY() < 0) {
			this.translate(0, GameModel.SCREEN_HEIGHT);
		}
	}
	
	private void translate(double dx, double dy) {
		this.center = this.center.add(dx, dy);
		this.body.setTranslateX(this.body.getTranslateX()+dx);
		this.body.setTranslateY(this.body.getTranslateY()+dy);
	}
		
	/*
	 * @return the polygon representation of the object.
	 * */
	public Polygon getBody() {
		return this.body;
	}
}
