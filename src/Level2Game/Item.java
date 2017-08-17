package Level2Game;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.Rectangle;
import java.awt.image.BufferedImage;
import java.util.Random;

public class Item {

	BufferedImage i;
	boolean timeGiven = false;
	boolean empty;
	boolean alive;
	int width;
	int height;
	int x;
	int y;
	int speedx;
	int speedy;
	Color color;
	Rectangle cactusBox;

	Item(int x, int y, int speedx, int speedy, Color color, BufferedImage i) {// cactus

		Random randomNumber = new Random();

		int randomValue1 = randomNumber.nextInt(500);
		this.width = i.getWidth();
		this.height = i.getHeight();
		this.x = x;
		this.y = y + 50;
		// 100 is subtracted from the randm value so that it draws within a
		// smaller range in order for the cactus to be
		// draw near the player
		this.speedx = speedx;
		this.speedy = speedy;
		this.color = color;
		this.alive = true;
		this.empty = true;
		this.i = i;

		cactusBox = new Rectangle(x, y, width, height);

	}

	Item(int itemWidth, int itemHeight, int x, int y, int speedx, int speedy, Color color, BufferedImage i) {// player&finish

		this.width = itemWidth;
		this.height = itemHeight;
		this.x = x;
		this.y = y + 50;
		this.speedx = speedx;
		this.speedy = speedy;
		this.color = color;
		this.alive = true;
		this.empty = true;
		this.i = i;
		cactusBox = new Rectangle(x, y, itemWidth, itemHeight);

	}

	boolean isAlive() {
		return alive;

	}

	void draw(Graphics g) {

		if (i == null) {
			g.setColor(color);// white: player

			g.fillOval(x, y, width, height);

		} else {
			g.drawImage(i, x, y, i.getWidth(), i.getHeight(), null);

			// g.drawRect(cactusBox.x, cactusBox.y, cactusBox.width,
			// cactusBox.height);

		}

	}

	void boundaryCheck() {
		if (x > EndlessJump.width - this.width) {
			speedx = -speedx;
			System.out.println("x < 500");

			timeGiven = true;

			// add time to the game if the player has not reached the finish
			// box..right

		}
		if (x < 0) {
			speedx = -speedx;
			System.out.println("x > 500");

			timeGiven = true;

			// add time to the game if the player has not reached the finish
			// box..left

		}

	}

	void update() {

		x = x + speedx;
		// allows the player to move from one side to the other side.

		// y += 1;
		updateCactusBox();
		boundaryCheck();

	}

	void updateCactusBox() {
		cactusBox.setBounds(x, y, width, height);
	}

	public int getWidth(Object object) {
		// TODO Auto-generated method stub
		return 0;
	}
}