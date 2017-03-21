package Level2Game;

import java.awt.Color;
import java.awt.Graphics;

public class GameObject {

	int x;
	int y;
	int width;
	int height;

	GameObject(int x, int y, int width, int height) {

		this.x = x;
		this.y = y;
		this.width = width;
		this.height = height;

	}

	void update() {

	}

	void draw(Graphics g) {

		g.setColor(Color.YELLOW);
		g.drawLine(x, y, width, height);
	}

}
