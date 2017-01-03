package Level2Game;

import java.awt.Color;
import java.awt.Graphics;

public class Object{
	boolean Alive;
	Color color;
	int height;
	int width;
	int x;
	int y;
	int speed;

	Object(int width, int height, int x, int y, int speed, Color color) {
		this.width = width;
		this.height = height;
		this.x = x;
		this.y = y;
		this.speed = speed;
		this.color = color;
		this.Alive = true;

	}

	boolean isAlive() {
		return Alive;

	}

	void draw(Graphics g) {
		g.setColor(color);
		g.fillRect(x, y, width, height);

	}

	void update() {

	}

}
