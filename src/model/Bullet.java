package model;

import javafx.scene.paint.Color;

/**
 * This is the class which represents a bullet which the user can shoot
 * 
 * */

public class Bullet extends GameObject {
	
	private static final int BULLET_VEL = 150;
	private static final double BULLET_LIFETIME = 3.0d;
	private double lifetime;
	
	/**
	 * Creates a Bullet object. The constructor takes in a starting (x, y) position on 
	 * the board. The constructor also takes in the rotational angle of which the bullet was shot 
	 * from.
	 * 
	 * @param posX represents the abscissa of the initial position of the bullet
	 * @param posY represents the ordinate of the initial position of the bullet
	 * @param rotation represents the rotational angle of which the bullet is shot from
	 * */
	
	public Bullet(double posX, double posY, double rotation) {
		this.velX = BULLET_VEL * java.lang.Math.cos(rotation);
		this.velY = BULLET_VEL * java.lang.Math.sin(rotation);
		this.lifetime = BULLET_LIFETIME;
		
		this.body.getPoints().addAll(new Double[]{
			    -2.0, -2.0,
			    2.0, -2.0,
			    2.0, 2.0,
			    -2.0, 2.0});
		this.body.setStroke(Color.WHITE);
		this.body.setFill(Color.WHITE);
		
		super.translate(posX, posY);
	}
	
	@Override
	public void update(double dt) {
		super.update(dt);
		this.lifetime -= dt;
	}
	
	/**
	 * @return if bullet's lifetime has been used up.
	 * */
	public boolean lifetimeDepleted() {
		return this.lifetime <= 0.0d;
	}
}
