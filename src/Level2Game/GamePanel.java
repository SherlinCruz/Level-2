package Level2Game;

import java.awt.Color;
import java.awt.Font;
import java.awt.Frame;
import java.awt.Graphics;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.awt.image.BufferedImage;

import javax.imageio.ImageIO;
import javax.swing.Box;
import javax.swing.JPanel;
import javax.swing.Timer;

public class GamePanel extends JPanel implements ActionListener, KeyListener {
	BufferedImage image;
	BufferedImage cactus;
	int backgroudWidth = 0;
	Timer timer;
	final int MENU_STATE = 0;
	final int GAME_STATE = 1;
	final int END_STATE = 2;
	int currentState = MENU_STATE;
	int scrollSpeed = 8;
	boolean risen;
	int gravity = 5;
	int srcx1 = 0;
	int srcx2 = 0;
	int width = 0;
	int height = 0;
	int imageWidth = 0;
	Item player;
	Font titleFont;
	Font enterFont;
	Font spaceFont;
	Font Endtitle;
	GameManager manager;

	GamePanel(int w, int h) {
		width = w;
		height = h;
		timer = new Timer(1000 / 6, this);
		player = new Item(30, 30, 0, 450, 5, 30, Color.white, null);
		titleFont = new Font("time new roman", Font.PLAIN, 48);
		enterFont = new Font("time new roman", Font.PLAIN, 20);
		spaceFont = new Font("time new roman", Font.PLAIN, 20);
		Endtitle = new Font("time new roman", Font.PLAIN, 20);
		manager = new GameManager();

		try {
			Thread.sleep(5);
			image = ImageIO.read(getClass().getResource("backgroundImage.jpg"));
			backgroudWidth = image.getWidth();
			cactus = ImageIO.read(getClass().getResource("cactus.png"));

		} catch (Exception e) {
			System.err.println("Couldn't find this image: " + image);

		}

	}

	void startGame() {
		timer.start();

	}

	public void paintComponent(Graphics g) {
		if (currentState == MENU_STATE) {
			drawMenuState(g);
		} else if (currentState == GAME_STATE) {

			drawGameState(g);
		} else if (currentState == END_STATE) {
			drawEndState(g);
		}
		manager = new GameManager();
	}

	void movingBackground() {

		if (srcx1 >= (backgroudWidth - width)) {

			srcx1 = 0;
			srcx2 = width;

		} else {
			srcx1 += scrollSpeed;
			srcx2 += scrollSpeed;
			System.out.println("scroll");
		}

	}

	void updateMenuState() {

	}

	void updateGameState() {
		manager.update();
		player.update();
		if (player.y + gravity < height - player.height) {
			System.out.println("gravity works");
			player.y = player.y + gravity;
		}

		// player.draw(getGraphics());

	}

	void updateEndState() {

	}

	void drawMenuState(Graphics g) {

		g.setColor(Color.yellow);

		g.setFont(titleFont);
		g.setColor(Color.pink);
		g.drawString("EndlessJump", 65, 100);

		g.setFont(enterFont);
		g.setColor(Color.black);
		g.drawString("Press ENTER to start ", 130, 200);

		g.setFont(spaceFont);
		g.setColor(Color.black);
		g.drawString("Press SPACE for intructions", 100, 300);

	}

	void drawGameState(Graphics g) {

		g.drawImage(image, 0, 0, width, height, srcx1, 0, srcx2, height, this);

		g.drawImage(cactus, 100, 400, null, null);

		// g.drawImage(cactus, 450, 10, width, height, srcx1, 0, srcx2, height,
		// this);

		player.draw(g);

	}

	void drawEndState(Graphics g) {
		g.setColor(Color.GREEN);
		g.drawString("END GAME", 100, 280);

	}

	@Override
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub
		manager.update();
		if (currentState == MENU_STATE) {
			updateMenuState();
			// System.out.println("Menu State");
		} else if (currentState == GAME_STATE) {
			movingBackground();
			updateGameState();
			// moveBackground();
		} else if (currentState == END_STATE) {
			updateEndState();
			// System.out.println("End State");
		}

		if (player.equals(cactus)) {
			
		}

		repaint();

	}

	public void keyPressed(KeyEvent e) {

		System.out.println("Console");

		if (e.getKeyCode() == KeyEvent.VK_ENTER) {
			if (currentState == MENU_STATE) {
				currentState = GAME_STATE;

			}

		}
		if (player.y > 300) {
			if (e.getKeyCode() == KeyEvent.VK_UP) {
				System.out.println("UP");
				player.y = player.y - player.speedy;
				risen = true;

				// player.y = player.y + player.speedy;
			}
		}

		if (risen = true) {
			System.out.println("gravity works");

			player.y = player.y + gravity;

			if (player.y < -1) {
				gravity = 0;

			}

		}

		if (e.getKeyCode() == KeyEvent.VK_DOWN) {
			System.out.println("DOWN ERROR");

			// player.y = player.y + player.speedy;
		}
		/*
		 * if (e.getKeyCode() == KeyEvent.VK_LEFT) { System.out.println("LEFT");
		 * 
		 * player.x = player.x - player.speedx;
		 * 
		 * } if (e.getKeyCode() == KeyEvent.VK_RIGHT) {
		 * System.out.println("RIGHT"); player.x = player.x + player.speedx; }
		 */

	}

	public void keyReleased(KeyEvent e) {
		// TODO Auto-generated method stub

	}

	@Override
	public void keyTyped(KeyEvent e) {
		// TODO Auto-generated method stub

	}

}
