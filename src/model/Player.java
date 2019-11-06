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
	
	/**
	@Override
	public void update(float dt, boolean moveForward, boolean turnRight, boolean turnLeft) {
		if (moveForward) {
			float velY;
			if (turnRight) {
				PLAYER_ANGLE += PLAYER_TURN_SPEED * dt * -1;
				velY = (float) (PLAYER_ACC * dt * java.lang.Math.sin(PLAYER_ANGLE));
				((Polygon) this.body).setRotate(PLAYER_ANGLE);
			} else if (turnLeft) {
				PLAYER_ANGLE += PLAYER_TURN_SPEED * dt;
				velY = (float) (PLAYER_ACC * dt * java.lang.Math.sin(PLAYER_TURN_SPEED)); 
				((Polygon) this.body).setRotate(PLAYER_TURN_SPEED);
			} else {
				velY = 0;
			}
			float velX = (float) (PLAYER_ACC * dt * java.lang.Math.cos(PLAYER_ANGLE));
			if (java.lang.Math.sqrt(Math.pow(velX, 2) + Math.pow(velY, 2)) > PLAYER_MAX_VEL) {
				if (velX != 0) {velX = PLAYER_MAX_VEL;}
				if (velY != 0) {velY = PLAYER_MAX_VEL;}
			}
			((Polygon) this.body).setTranslateX(velX * dt);
			((Polygon) this.body).setTranslateY(velY * dt);
		}
		
	}
	*/
	
	/*
	 * @return the rotation angle of the player in radians.
	 * */
	public double getRotation() {
		return this.rotation;
	}	
	
}
