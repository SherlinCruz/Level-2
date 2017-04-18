package Level2Game;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.Rectangle;
import java.awt.image.BufferedImage;

public class Item {

	BufferedImage i;
	boolean empty;
	boolean Alive;
	Color color;
	int width;
	int height;
	int x;
	int y;
	int speedx;
	int speedy;
	Rectangle box;

	Item(int width, int height, int x, int y, int speedx, int speedy, Color color, BufferedImage i) {

		this.width = width;
		this.height = height;
		this.x = x;
		this.y = y;
		this.speedx = speedx;
		this.speedy = speedy;
		this.color = color;
		this.Alive = true;
		this.empty = true;
		this.i = i;
		box = new Rectangle(x, y, width, height);

	}

	boolean isAlive() {
		return Alive;

	}

	void draw(Graphics g) {

		g.setColor(color);
		g.fillOval(x, y, width, height);

	}

	void boundaryCheck() {
		if (x < 0) {
			speedx = -speedx;
			System.out.println("x > 0");
		}
		if (x > 500) {
			speedx = -speedx;
			System.out.println("x < 500");
		}
		if (y < 0) {
			speedy = -speedy;
			System.out.println("y < 0");
		}
		if (y > 500) {
			speedy = -speedy;
			System.out.println("y > 500");
		}

	}

	void update() {

		x = x + speedx;
		// y = y + speedy;
		box.setBounds(x, y, width, height);
		boundaryCheck();
	}

	public int getWidth(Object object) {
		// TODO Auto-generated method stub
		return 0;
	}
}