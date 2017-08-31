package Level2Game;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.Image;
import java.awt.Rectangle;
import java.awt.image.BufferedImage;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Random;
import javax.imageio.ImageIO;

public class CactusManager {

	// score will be coded here?
	ArrayList<Item> items = new ArrayList<Item>();

	boolean up = true;

	CactusManager() {

		Item cactusItem;

		try {

			BufferedImage cactus = ImageIO.read(getClass().getResource("cactus.png"));

			for (int i = 0; i < 50; i++) {

				int x = new Random().nextInt(EndlessJump.width - 80);

				int y = new Random().nextInt(EndlessJump.height - 120);

				while (!checkCactus(x, y)) {

					x++;

					// y--;
					y = new Random().nextInt(EndlessJump.height - 100);
				}

				// used to be -10!
				cactusItem = new Item(x, y, 0, 0, null, cactus);

				items.add(cactusItem);

			}
		} catch (

		Exception e) {

			System.err.println("Couldn't find this image: " + items);

		}

	}

	boolean checkCactus(int x, int y) {

		Rectangle r = new Rectangle(x, y, 35, 32);
		Rectangle playerBox = new Rectangle(22, 450, 24, 24);

		for (Item i : items) {
			if (r.intersects(i.cactusBox)) {
				return false;
			} else if (playerBox.intersects(i.cactusBox)) {
				return false;
			}
			// if gap between is too small
			else if ((Math.abs(x - i.x) < 120) && (Math.abs(y - i.y) < 120)) {

				return false;
			}

		}
		return true;
	}

	public boolean intersects(Item player) {

		for (Item cactus : items) {
			if (player.cactusBox.intersects(cactus.cactusBox)) {
				return true;
			}
		}

		return false;

	}

	public void update() {

		if (up) {
			for (Item cactus : items) {

				cactus.y -= 5;

				cactus.updateCactusBox();
			}

			up = false;
		} else {

			for (Item cactus : items) {

				cactus.y += 5;

				cactus.updateCactusBox();

			}

			up = true;
		}

	}

	public void draw(Graphics g) {

		for (Item cactus : items) {

			cactus.draw(g);

		}

	}

	public void reset() {

	}

}