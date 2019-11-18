package model;

import java.util.HashMap;

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
	
	private static final int PLAYER_ACC = 100;
	private static final double PLAYER_TURN_SPEED = 220;

	public Player() {
		super();
		this.velX = 0.0;
		this.velY = 0.0;
		this.body.getPoints().addAll(new Double[] {
				-10.0d, -10.0d,
				 10.0d, 0.0d,
				-10.0d, 10.0d});
		
		//Added border color to player
		this.body.setStroke(Color.WHITE);
		this.body.setFill(Color.TRANSPARENT);

		super.translate(GameModel.SCREEN_WIDTH/2, GameModel.SCREEN_HEIGHT/2);
	}
	
	/*
	 * This updates the position of player based on whether the player moves forward, turns 
	 * and delta time. 
	 * @param dt
	 * @param inputs
	 * @return none
	 * */
	
	public void update(double dt, HashMap<String, Boolean> inputs) {
		if (inputs.get("turnLeft")) {
			this.rotate(-dt * PLAYER_TURN_SPEED);
		} 
		if (inputs.get("turnRight")) {
			this.rotate(dt * PLAYER_TURN_SPEED);
		}
		if (inputs.get("moveForward")) {
			this.velX += PLAYER_ACC * dt * java.lang.Math.cos(this.getRotationRadians());
			this.velY += PLAYER_ACC * dt * java.lang.Math.sin(this.getRotationRadians());
		}	
		super.update(dt);
	}
	
	private void rotate(double angle) {
		this.body.setRotate(this.body.getRotate() + angle);
	}
	
	/*
	 * @return the rotation angle of the player in degrees.
	 * */
	public double getRotationDegrees() {
		return this.body.getRotate();
	}
	
	public double getRotationRadians() {
		return this.body.getRotate() / 180 * Math.PI;
	}
	
}
