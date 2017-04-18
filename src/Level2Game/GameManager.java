package Level2Game;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.Image;
import java.util.ArrayList;
import java.util.Random;

public class GameManager {

	//Item cactus;
	ArrayList<Item> objects;
	private int score = 0;

	long enemyTimer = 0;
	int enemySpawnTime = 1000;

	public GameManager() {

	//	cactus = new Item(30, 30, (int) (Math.random() * 500) + 1, (int) (Math.random() * 500) + 1, 10, 2, Color.white);

		objects = new ArrayList<Item>();

	}

	public void addObject(Item o) {
		objects.add(o);
	}

	public void update() {
		for (int i = 0; i < objects.size(); i++) {
			Item o = objects.get(i);
			o.update();
		}

		purgeObjects();
	}

	public void draw(Graphics g) {
		for (int i = 0; i < objects.size(); i++) {
			Item o = objects.get(i);
			o.draw(g);
		}
	}

	private void purgeObjects() {
		for (int i = 0; i < objects.size(); i++) {
			if (!objects.get(i).isAlive()) {
				objects.remove(i);
			}
		}
	}

	public int getScore() {
		return score;
	}

	public void setScore(int s) {
		score = s;
	}

	/*
	 * public void checkCollision() { for (int i = 0; i < objects.size(); i++) {
	 * for (int j = i + 1; j < objects.size(); j++) { GameObject o1 =
	 * objects.get(i); GameObject o2 = objects.get(j);
	 * 
	 * if (o1.collisionBox.intersects(o2.collisionBox)) { if ((o1 instanceof
	 * Alien && o2 instanceof Projectile) || (o2 instanceof Alien && o1
	 * instanceof Projectile)) { score++; System.out.println(score); o1.isAlive
	 * = false; o2.isAlive = false; } else if ((o1 instanceof Alien && o2
	 * instanceof Rocketship) || (o2 instanceof Alien && o1 instanceof
	 * Rocketship)) { o1.isAlive = false; o2.isAlive = false; }
	 * 
	 * } } } }
	 */

	public void reset() {
		objects.clear();
	}

}
