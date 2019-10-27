package model;
import javafx.scene.shape.Polygon;

public class Player extends GameObject {
	
	private static final int PLAYER_MAX_VEL = 100;
	private static final int PLAYER_ACC = 20;
	private static final float PLAYER_TURN_SPEED = (float) (2*Math.PI);
	private static float PLAYER_ANGLE = 0;

	public Player() {
		super();
		this.body.getPoints().addAll(new Double[] {
				(double) (GameModel.SCREEN_HEIGHT/2), (double) (GameModel.SCREEN_WIDTH/2),
				(double) (GameModel.SCREEN_HEIGHT/2 + 20), (double) (GameModel.SCREEN_WIDTH/2 + 10),
				(double) (GameModel.SCREEN_HEIGHT/2 + 10), (double) (GameModel.SCREEN_WIDTH/2 + 20),
		});
	}

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
	
	public float getRotation() {
		return PLAYER_ANGLE;
	}	
	
}
