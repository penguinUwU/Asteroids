package model;
import java.util.ArrayList;
import java.util.Random;

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
	private static float ASTEROID_ANGLE = 0;
	
	public Asteroid() {
		super();
	}

	@Override
	public void update(float dt, boolean moveForward, boolean turnRight, boolean turnLeft) {
		ArrayList<Float> directionOfMove = new ArrayList<Float>();
		
		// Add all the possible moves.
		Random rand = new Random(); 
		
		directionOfMove.add((float) (Math.PI/2));
		directionOfMove.add((float) (3 * Math.PI/2));
		directionOfMove.add((float) (0));
		directionOfMove.add((float)  (Math.PI/3));
		
		float dir = directionOfMove.get(rand.nextInt(directionOfMove.size()));
		
		if (moveForward) {

			float velX =  (float) (L_ASTEROID_MIN_VEL * dt * java.lang.Math.cos(dir));
			float velY =  (float) (L_ASTEROID_MIN_VEL * dt * java.lang.Math.sin(dir));
			
			((Polygon) this.body).setTranslateX(velX*dt);
			((Polygon) this.body).setTranslateY(velY*dt);
		}
		
		
	}
	
}
