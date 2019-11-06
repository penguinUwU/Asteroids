package model;
import java.util.ArrayList;
import javafx.geometry.Point2D;
import java.util.Random;

import javafx.scene.paint.Color;
import javafx.scene.shape.Polygon;
/*
 * This is class for the Asteroids (i.e. all sizes for now)
 * 
 * @author Abhay and Mathieu.
 * 
 * */

public class Asteroid extends GameObject{

	private static final int L_ASTEROID_MAX_VEL = 20;
	private static final int L_ASTEROID_MIN_VEL = 10;
	private static final int M_ASTEROID_MAX_VEL = 30;
	private static final int M_ASTEROID_MIN_VEL = 20;
	private static final int S_ASTEROID_MAX_VEL = 40;
	private static final int S_ASTEROID_MIN_VEL = 30;
	
	public Asteroid(char size) {
		Random rand = new Random();
		
		double angle = rand.nextFloat()*2*Math.PI;
		float vel = 0.0f;
		if (size == 'L') {
			vel = L_ASTEROID_MIN_VEL + rand.nextFloat()*(L_ASTEROID_MAX_VEL-L_ASTEROID_MIN_VEL);
		} else if (size == 'M') {
			vel = M_ASTEROID_MIN_VEL + rand.nextFloat()*(M_ASTEROID_MAX_VEL-M_ASTEROID_MIN_VEL);
		} else if (size == 'S') {
			vel = S_ASTEROID_MIN_VEL + rand.nextFloat()*(S_ASTEROID_MAX_VEL-S_ASTEROID_MIN_VEL);
		}
		
		this.velX = vel*Math.cos(angle);
		this.velX = vel*Math.sin(angle);
		
		this.body = new Polygon();
		//set color of asteroid
		this.body.setStroke(Color.WHITE);
		this.body.getPoints().addAll(new Double[]{
			    -20.0, -20.0,
			    20.0, -20.0,
			    -20.0, 20.0,
			    20.0, 20.0});
		this.center = new Point2D(0.0, 0.0);
	}
}
