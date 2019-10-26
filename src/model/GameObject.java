package model;
import com.sun.javafx.geom.Point2D;
import javafx.scene.shape.Polygon;

public abstract class GameObject {
	
	private float x;
	private float y;
	private float velX;
	private float velY;
	private Polygon body;
	private Point2D midPoint;
	
	public GameObject(int x, int y) {
		this.x = x;
		this.y = y;
	}
	
	public float[] getPosition() {
		float[] newPosition = new float[2];
		newPosition[0] = this.x;
		newPosition[1] = this.y;
		return newPosition;
	}
	
	
	public abstract void update(float detlaTime);
		
	
}
