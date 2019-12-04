package model;
import javafx.geometry.Point2D;
import javafx.scene.shape.Polygon;

/**
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
	
	/**
	 * The constructor initializes the game object.
	 * 
	 * */
	
	public GameObject() {
		this.body = new Polygon();
		this.body.setTranslateX(0.0d);
		this.body.setTranslateY(0.0d);
		this.center = new Point2D(0.0d, 0.0d);
	}
	
	/**
	 * This is the abstract class update. Implementation varies on game object.
	 * 
	 * This method increments the position of the object by its velocity*dt
	 * @param dt delta-time representing how long the player is moving forward.
	 * @return none
	 * */
	public void update(double dt) {
		this.translate(this.velX*dt, this.velY*dt);
		this.wrap();
	}
	
	/**
	 * This method moves the game object according to dx and dy,.
	 * 
	 * @param dx is the translation in respect to x.
	 * @param dy is the translation in respect to y.	 
	 * */
	protected void translate(double dx, double dy) {
		this.center = this.center.add(dx, dy);
		this.body.setTranslateX(this.body.getTranslateX()+dx);
		this.body.setTranslateY(this.body.getTranslateY()+dy);
	}
	
	/**
	 * This method checks to see if the game object has exited the bounds of the 
	 * game. If so, then the object appears on the opposite side of the game.
	 * 	  
	 * */
	private void wrap() {
		//added toolbar modifier
		if (this.center.getX() > GameModel.SCREEN_WIDTH) {
			this.translate(-GameModel.SCREEN_WIDTH, 0);
		} else if (this.center.getX() < 0){
			this.translate(GameModel.SCREEN_WIDTH, 0);
		} else if (this.center.getY() > GameModel.SCREEN_HEIGHT) {
			this.translate(0, -GameModel.SCREEN_HEIGHT+45);
		} else if (this.center.getY() < 45) {
			this.translate(0, GameModel.SCREEN_HEIGHT-45);
		}
	}
	
	/**
	 * @return the shape of the object.
	 * */
	public Polygon getBody() {
		return this.body;
	}
	
	/**
	 * @return the center of the object.
	 * */
	
	public Point2D getCenter() {
		return this.center;
	}
}

