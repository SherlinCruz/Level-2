package Level2Game;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.Image;
import java.util.ArrayList;
import java.util.Random;

public class GameManager {

	ArrayList<Item> object;
	private int score = 0;

	long enemyTimer = 0;
	int enemySpawnTime = 1000;

	public GameManager() {

		object = new ArrayList<>();

	}

	public void addObject(Item o) {
		object.add(o);
	}

	public void update() {
		for (int i = 0; i < object.size(); i++) {
			Item o = object.get(i);
			o.update();
		}

	}

	public void draw(Graphics g) {
		for (int i = 0; i < object.size(); i++) {
			Item o = object.get(i);
			o.draw(g);
		}
	}


	public void reset() {
		object.clear();
	}

}
