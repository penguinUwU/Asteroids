package model;
import javafx.geometry.Point2D;
import javafx.scene.shape.Polygon;
import javafx.scene.paint.Color;

/*
 * This is class for the User (i.e. the rocket ship)
 * 
 * The player class goes covers updating the user's position the user moves. 
 * This is a child class of the GameObject abstract class. 
 * 
 * @author Abhay
 * 
 * */

public class Player extends GameObject {
	
	private static final int PLAYER_MAX_VEL = 100;
	private static final int PLAYER_ACC = 20;
	private static final float PLAYER_TURN_SPEED = (float) (2*Math.PI);
	
	private double rotation;

	public Player() {
		this.velX = 0.0;
		this.velY = 0.0;
		this.body = new Polygon();
		this.body.getPoints().addAll(new Double[] {
				(double) (GameModel.SCREEN_HEIGHT/2), (double) (GameModel.SCREEN_WIDTH/2),
				(double) (GameModel.SCREEN_HEIGHT/2 + 20), (double) (GameModel.SCREEN_WIDTH/2 + 10),
				(double) (GameModel.SCREEN_HEIGHT/2 + 10), (double) (GameModel.SCREEN_WIDTH/2 + 20),
			}
		);
		
		//Added border color to player
		this.body.setStroke(Color.WHITE);
		
		this.center = new Point2D(GameModel.SCREEN_HEIGHT/2, GameModel.SCREEN_HEIGHT/2);
		this.rotation = 0.0;
	}
	
	/*
	 * This is the implementation of the abstract class update from parent class GameObject.
	 * 
	 * This updates the position of player based on whether the player moves forward, turns 
	 * and delta time. 
	 * @param dt delta-time representing how long the player is moving forward.
	 * @param moveForward is a boolean which states if the user is moving forward.
	 * @param turnRight is a boolean which states if the user is turning right. 
	 * @param turnLeft is a boolean which states if the user is turning left. 
	 * @return none
	 * */
	
	public void update(float dt, boolean moveForward, boolean turnRight, boolean turnLeft) {
		if (turnRight) {
			this.rotation -= dt * PLAYER_TURN_SPEED;
		} 
		if (turnLeft) {
			this.rotation += dt * PLAYER_TURN_SPEED;
		}
		if (moveForward) {
			this.velX += PLAYER_ACC * dt * java.lang.Math.cos(this.rotation);
			this.velY += PLAYER_ACC * dt * java.lang.Math.sin(this.rotation);
			
			if (java.lang.Math.sqrt(this.velX*this.velX + this.velY*this.velY)>PLAYER_MAX_VEL) {
				this.velX = PLAYER_MAX_VEL * java.lang.Math.cos(this.rotation);
				this.velY = PLAYER_MAX_VEL;
			}
			
			this.center = this.center.add(this.velX*dt, this.velY*dt);
			this.body.setTranslateX(this.body.getTranslateX()+this.velX*dt);
			this.body.setTranslateY(this.body.getTranslateY()+this.velY*dt);
		}
	}
	
	/*
	 * @return the rotation angle of the player in radians.
	 * */
	public double getRotation() {
		return this.rotation;
	}	
	
}
