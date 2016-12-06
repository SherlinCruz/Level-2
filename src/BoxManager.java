import java.awt.Color;
import java.awt.Graphics;
import java.util.ArrayList;

public class BoxManager {

	Box box;

	ArrayList<Box> enemyB;

	int enemyTimer = 0;
	int spawnEnemyTimer = 20;

	BoxManager() {

		box = new Box(60, 60, 35, 35, 10, 2, Color.white);

		enemyB = new ArrayList<Box>();
	}

	void update() {
		box.update();
		for (int i = 0; i < enemyB.size(); i++) {

			Box boxTwo = enemyB.get(i);

			boxTwo.update();

		}
		manageEnemies();
	}

	void draw(Graphics g) {
		box.draw(g);
		for (int i = 0; i < enemyB.size(); i++) {
			Box boxTwo = enemyB.get(i);
			boxTwo.draw(g);
		}

	}

	void AddEnemy(Box box) {

		enemyB.add(box);

	}

	void manageEnemies() {

		enemyTimer++;

		if (enemyTimer > spawnEnemyTimer) {

			Box boxThree = new Box(30, 30, 15, 15, (int) (Math.random() * 10) + 1, (int) (Math.random() * 10) + 1, Color.pink);

			AddEnemy(boxThree);

			enemyTimer = 0;

		}

	}

	void checkBoxEaten() {

	}

}
