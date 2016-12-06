import java.awt.Color;
import java.awt.Graphics;
import java.util.ArrayList;

public class Box {
	boolean empty;
	boolean Alive;
	Color color;
	int width;
	int height;
	int x;
	int y;
	int speedx;
	int speedy;

	Box(int width, int height, int x, int y, int speedx, int speedy, Color color) {
		this.width = width;
		this.height = height;
		this.x = x;
		this.y = y;
		this.speedx = speedx;
		this.speedy = speedy;
		this.color = color;
		this.Alive = true;
		this.empty = true;

	}

	boolean isAlive() {
		return Alive;

	}

	void draw(Graphics g) {
		g.setColor(color);
		g.fillRect(x, y, width, height);

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
		y = y + speedy;
		boundaryCheck();
	}

	public void add(Box box) {
		// TODO Auto-generated method stub

	}

	public Box get(int i) {
		// TODO Auto-generated method stub
		return null;
	}
}