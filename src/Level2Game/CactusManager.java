package Level2Game;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.Image;
import java.awt.image.BufferedImage;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Random;
import javax.imageio.ImageIO;

public class CactusManager {

	// score will be coded here?
	ArrayList<Item> items = new ArrayList<Item>();

	boolean up = true;
	boolean overlap = false;

	CactusManager() {

		Item cactusItem;

		try {

			BufferedImage cactus = ImageIO.read(getClass().getResource("cactus.png"));

			cactusItem = new Item(EndlessJump.width, EndlessJump.height, 0, 0, Color.white, cactus);
			items.add(cactusItem);

			cactusItem = new Item(EndlessJump.width, EndlessJump.height, 0, 0, Color.white, cactus);
			items.add(cactusItem);

			cactusItem = new Item(EndlessJump.width, EndlessJump.height, 0, 0, Color.white, cactus);
			items.add(cactusItem);

			cactusItem = new Item(EndlessJump.width, EndlessJump.height, 0, 0, Color.white, cactus);
			items.add(cactusItem);

			cactusItem = new Item(EndlessJump.width, EndlessJump.height, 0, 0, Color.white, cactus);
			items.add(cactusItem);

			cactusItem = new Item(EndlessJump.width, EndlessJump.height, 0, 0, Color.white, cactus);
			items.add(cactusItem);

			cactusItem = new Item(EndlessJump.width, EndlessJump.height, 0, 0, Color.white, cactus);
			items.add(cactusItem);

			cactusItem = new Item(EndlessJump.width, EndlessJump.height, 0, 0, Color.white, cactus);
			items.add(cactusItem);

		} catch (Exception e) {

			System.err.println("Couldn't find this image: " + items);

		}

	}

	public boolean intersects(Item player) {

		for (Item cactus : items) {
			if (player.cactusBox.intersects(cactus.cactusBox)) {
				return true;
			}
		}

		for (Item cactusItem : items) {
			if (cactusItem.cactusBox.intersects(cactusItem.cactusBox)) {

				System.out.println("OVERLAPING");
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
		// ***************************
		if (overlap) {
			System.out.println("bump");

			overlap = true;
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