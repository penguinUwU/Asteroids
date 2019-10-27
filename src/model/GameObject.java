package model;
import com.sun.javafx.geom.Point2D;
import javafx.scene.shape.Polygon;

public abstract class GameObject {
	
	private float velX;
	private float velY;
	protected Polygon body;
	private Point2D midPoint;
	
	public GameObject() {
		this.body = new Polygon();
	}
	
	public abstract void update(float dt, boolean moveForward, boolean turnRight, boolean turnLeft);
		
	public Polygon getBody() {
		return this.body;
	}
}
