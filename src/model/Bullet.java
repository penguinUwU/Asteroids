package model;

import javafx.scene.paint.Color;

public class Bullet extends GameObject {
	
	private static final int BULLET_VEL = 150;
	
	public Bullet() {
		this.body.setStroke(Color.WHITE);
	}
	
	public void update(float dt, double rotation, double positionX, double positionY) {
		
		this.velX = BULLET_VEL * java.lang.Math.cos(rotation);
		this.velY = BULLET_VEL * java.lang.Math.sin(rotation);
		
		super.update(dt);
		
	}
}
