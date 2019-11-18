package model;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Observable;

import javafx.scene.shape.Polygon;

public class GameModel extends Observable{
	public static final int SCREEN_HEIGHT = 500;
	public static final int SCREEN_WIDTH = 500;
	
	private static final int NUM_ASTEROIDS = 10;
	
	private static final double TOTAL_SHOOT_COOLDOWN = 0.5;
	
	//private ArrayList<Bullet> bullets;
	private ArrayList<Asteroid> asteroids;
	private ArrayList<Bullet> bullets;
	private Player player;
	
	private ArrayList<Asteroid> asteroidsToAdd;
	private ArrayList<Bullet> bulletsToAdd;
	private ArrayList<Asteroid> asteroidsToRemove;
	private ArrayList<Bullet> bulletsToRemove;
	
	private ArrayList<Polygon> addedPolygons;
	private ArrayList<Polygon> removedPolygons;
	
	private int score;
	private int lives;
	private double shootCooldown;
	private boolean gameOver;
	
	public GameModel() {
		this.asteroids = new ArrayList<Asteroid>(); 
		this.bullets = new ArrayList<Bullet>();
		this.addedPolygons = new ArrayList<Polygon>(); 
		this.removedPolygons = new ArrayList<Polygon>();
		this.asteroidsToAdd = new ArrayList<Asteroid>();
		this.bulletsToAdd = new ArrayList<Bullet>();
		this.asteroidsToRemove = new ArrayList<Asteroid>();
		this.bulletsToRemove = new ArrayList<Bullet>();
		
		for (int i=0; i<NUM_ASTEROIDS; i++) {
			this.asteroidsToAdd.add(new Asteroid(2, 0.0d, 0.0d));
		}
		
		this.player = new Player();
		this.addedPolygons.add(this.player.getBody());
		
		this.score = 0;
		this.lives = 3;
		this.shootCooldown = 0.0d;
		this.gameOver = false;
		
		this.removeDestroyedGameObjects();
		this.addNewGameObjects();
	}
	
	/**
	 * Update all game objects according to the parameters. Create a new bullet if the space bar is being
	 * pressed and add its body to addedPolygons. Call bulletVSAsteroid() and playerVSAsteroid() to check
	 * for collisions.
	 * 
	 * @param dt
	 * @param moveForward true if 'w' key is being pressed
	 * @param turnRight true if 'd' key is being pressed
	 * @param turnLeft true if 'a' key is being pressed
	 * @param shoot true if the space bar is being pressed
	 */
	public void update(double dt, HashMap<String, Boolean> inputs) {
		for (Asteroid asteroid: this.asteroids) {
			asteroid.update(dt);
		}
		
		for (Bullet bullet: this.bullets) {
			bullet.update(dt);
			if (bullet.lifetimeDepleted()) {
				this.bulletsToRemove.add(bullet);
			}
		}
		
		this.player.update(dt, inputs);
		
		if (this.shootCooldown > 0.0d) {
			this.shootCooldown -= dt;
		}
		
		if (inputs.get("shoot") && this.shootCooldown <= 0.0d) {
			double rotation = this.player.getRotationRadians();
			double posX = this.player.body.getTranslateX();
			double posY = this.player.body.getTranslateY();
			this.bulletsToAdd.add(new Bullet(posX, posY, rotation));
			this.shootCooldown = GameModel.TOTAL_SHOOT_COOLDOWN;
		}
		
		
		this.bulletVSAsteroid();
		this.playerVSAsteroid();
		this.removeDestroyedGameObjects();
		this.addNewGameObjects();
		this.setChanged();
		this.notifyObservers();
	}
	
	private void bulletVSAsteroid(){
		for (Asteroid asteroid: this.asteroids) {
			for (Bullet bullet: this.bullets) {
				if (asteroid.getBody().getBoundsInParent().intersects(bullet.getBody().getBoundsInParent())) {
					if (asteroid.getSize() > 0) {
						this.asteroidsToAdd.add(new Asteroid(asteroid.getSize() - 1, 
								asteroid.getBody().getTranslateX(), asteroid.getBody().getTranslateY()));
						this.asteroidsToAdd.add(new Asteroid(asteroid.getSize() - 1, 
								asteroid.getBody().getTranslateX(), asteroid.getBody().getTranslateY()));
					}
					this.score += 10;
					this.asteroidsToRemove.add(asteroid);
					this.bulletsToRemove.add(bullet);
				}
			}
		}
	}
	
	private void playerVSAsteroid(){
		for (Asteroid asteroid: this.asteroids) {
			if (asteroid.getBody().getBoundsInParent().intersects(this.player.getBody().getBoundsInParent())) {
				this.lives -= 1;
				this.removedPolygons.add(this.player.body);
				this.player = new Player();
				this.addedPolygons.add(this.player.body);
				if (this.lives <= 0) {
					this.gameOver = true;
				}
			}
		}
	}

	private void addNewGameObjects() {
		for (Asteroid asteroid: this.asteroidsToAdd) {
			this.addedPolygons.add(asteroid.getBody());
			this.asteroids.add(asteroid);
		}
		for (Bullet bullet: this.bulletsToAdd) {
			this.addedPolygons.add(bullet.getBody());
			this.bullets.add(bullet);
		}
		this.asteroidsToAdd.clear();
		this.bulletsToAdd.clear();
	}
	
	private void removeDestroyedGameObjects() {
		for (Asteroid asteroid: this.asteroidsToRemove) {
			this.removedPolygons.add(asteroid.getBody());
			this.asteroids.remove(asteroid);
		}
		for (Bullet bullet: this.bulletsToRemove) {
			this.removedPolygons.add(bullet.getBody());
			this.bullets.remove(bullet);
		}
		this.asteroidsToRemove.clear();
		this.bulletsToRemove.clear();
	}
	
	/**
	 * 
	 * @return lives
	 */
	public int getLives() {
		return this.lives;
	}
	
	/**
	 * 
	 * @return score
	 */
	public int getScore() {
		return this.score;
	}
	
	public boolean isGameOver() {
		return this.gameOver;
	}
	
	/**
	 * Returns a shallow copy of the ArrayList of polygons that have been added to the game. A side effect of this
	 * method is that this.addedPolygons is emptied. 
	 * 
	 * @return ArrayList of added polygons
	 */
	public ArrayList<Polygon> getAddedPolygons() {
		ArrayList<Polygon> added = new ArrayList<>();
		
		//create shallow copy (object references copied) of addedPolygons
		for (Polygon p : this.addedPolygons)
			added.add(p);
		
		//empty the copied ArrayList
		this.addedPolygons.clear();
		return added;
	}
	
	/**
	 * Returns a shallow copy of the ArrayList of polygons that have been removed from the game. A side effect of this
	 * method is that this.removedPolygons is emptied. 
	 * 
	 * @return ArrayList of removed polygons
	 */
	public ArrayList<Polygon> getRemovedPolygons(){
		ArrayList<Polygon> removed = new ArrayList<>();
		
		//create shallow copy (object references copied) of removedPolygons
		for (Polygon p : this.removedPolygons)
			removed.add(p);
		
		//empty the copied ArrayList
		this.removedPolygons.clear();
		return removed;
	}

}
