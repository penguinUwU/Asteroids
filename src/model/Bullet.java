package model;

import javafx.scene.paint.Color;

public class Bullet extends GameObject {
	
	private static final int BULLET_VEL = 150;
	private static final float BULLET_LIFETIME = 3.0f;
	private float lifetime;
	
	public Bullet() {
		super();
		this.lifetime = BULLET_LIFETIME;
		this.body.setStroke(Color.WHITE);
	}
	
	public void update(float dt, double rotation, double positionX, double positionY) {
		
		this.velX = BULLET_VEL * java.lang.Math.cos(rotation);
		this.velY = BULLET_VEL * java.lang.Math.sin(rotation);
		
		if (this.lifetime < dt) {
			super.update(this.lifetime); // If the bullet exceeds its time limit
			this.lifetime = 0;
		} else {
			super.update(dt);
			this.lifetime -= dt;
		}
		
	}
}
