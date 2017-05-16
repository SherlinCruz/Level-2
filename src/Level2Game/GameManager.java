package Level2Game;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.Image;
import java.awt.image.BufferedImage;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Random;

import javax.imageio.ImageIO;

public class GameManager {

	// score will be coded here?

	Random randomNumber = new Random();

	int value = randomNumber.nextInt(100);

	int width = value;
	int height = value;
	int x = value;
	int y = value;

	GameManager() {

		ArrayList<Item> items = new ArrayList<Item>();

		Item cactusItem;

		try {

			BufferedImage cactus = ImageIO.read(getClass().getResource("cactus.png"));

			cactusItem = new Item(width, height, x, y, 0, 0, Color.white, cactus);
			items.add(cactusItem);

			cactusItem = new Item(width, height, x, y, 0, 0, Color.white, cactus);
			items.add(cactusItem);

		}

		catch (Exception e) {

			System.err.println("Couldn't find this image: " + items);

		}

	}

	public void update() {

	}

	public void draw(Graphics g) {

	}

	public void reset() {

	}

}
