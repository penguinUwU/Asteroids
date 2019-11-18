package model;

import java.util.Random;

import javafx.scene.paint.Color;

/*
 * This is class for the Asteroids (i.e. all sizes for now)
 * 
 * @author Abhay and Mathieu.
 * 
 * */

public class Asteroid extends GameObject{

	private static final int L_ASTEROID_MAX_VEL = 30;
	private static final int L_ASTEROID_MIN_VEL = 10;
	private static final int M_ASTEROID_MAX_VEL = 40;
	private static final int M_ASTEROID_MIN_VEL = 30;
	private static final int S_ASTEROID_MAX_VEL = 50;
	private static final int S_ASTEROID_MIN_VEL = 40;
	
	private int size;
	
	public Asteroid(int size, double posX, double posY) {
		super();
		this.size = size;
		
		Random rand = new Random();

		double angle = rand.nextDouble()*2*Math.PI;
		double vel = 0.0d;
		
		this.body.getPoints().addAll(new Double[]{
			    8.0, -16.0,
			    16.0, -8.0,
			    14.0, 12.0,
			    8.0, 14.0,
			    -2.0, 16.0,
			    -16.0, 8.0,
			    -12.0, 2.0,
			    -16.0, -10.0});
		if (size == 2) {
			vel = L_ASTEROID_MIN_VEL + rand.nextDouble()*(L_ASTEROID_MAX_VEL-L_ASTEROID_MIN_VEL);
			this.body.setScaleX(1.5);
			this.body.setScaleY(1.5);
			this.body.setStrokeWidth(1.0d);
		} else if (size == 1) {
			vel = M_ASTEROID_MIN_VEL + rand.nextDouble()*(M_ASTEROID_MAX_VEL-M_ASTEROID_MIN_VEL);
			this.body.setStrokeWidth(1.5d);
		} else if (size == 0) {
			vel = S_ASTEROID_MIN_VEL + rand.nextDouble()*(S_ASTEROID_MAX_VEL-S_ASTEROID_MIN_VEL);
			this.body.setScaleX(0.5);
			this.body.setScaleY(0.5);
			this.body.setStrokeWidth(3.0d);
		}
		
		this.velX = vel*Math.cos(angle);
		this.velY = vel*Math.sin(angle);
		
		this.body.setStroke(Color.WHITE);
		this.body.setFill(Color.TRANSPARENT);
		
		super.translate(posX, posY);
	}
	
	public int getSize() {
		return this.size;
	}
}
