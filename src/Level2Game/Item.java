package Level2Game;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.Rectangle;
import java.awt.image.BufferedImage;
import java.util.Random;

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

	Item(int gameWidth, int gameHeight, int speedx, int speedy, Color color, BufferedImage i) {

		Random randomNumber = new Random();

		int randomValue1 = randomNumber.nextInt(500);

		this.width = randomNumber.nextInt(20) + 20;
		this.height = randomNumber.nextInt(60) + 20;
		this.x = randomNumber.nextInt(gameWidth);
		this.y = randomNumber.nextInt(gameHeight);
		this.speedx = speedx;
		this.speedy = speedy;
		this.color = color;
		this.Alive = true;
		this.empty = true;
		this.i = i;
		box = new Rectangle(x, y, width, height);

	}

	Item(int itemWidth, int itemHeight, int x, int y, int speedx, int speedy, Color color, BufferedImage i) {

		this.width = itemWidth;
		this.height = itemHeight;
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
		if (x > EndlessJump.width) {
			speedx = -speedx;
			System.out.println("x < 500");
		}
		if (y < 0) {
			speedy = -speedy;
			System.out.println("y < 0");
		}
		if (y > EndlessJump.height - height) {
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