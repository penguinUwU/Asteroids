package model;

import javafx.geometry.Point2D;
import javafx.scene.paint.Color;
import javafx.scene.shape.Polygon;

public class Bullet extends GameObject {
	
	private static final int BULLET_VEL = 150;
	private static final double BULLET_LIFETIME = 3.0d;
	private double lifetime;
	
	public Bullet(double posX, double posY, double rotation) {
		super();
		
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
	
	public boolean lifetimeDepleted() {
		return this.lifetime <= 0.0d;
	}
}
