package Level2Game;

import java.awt.Color;
import java.awt.Font;
import java.awt.Frame;
import java.awt.Graphics;
import java.awt.Rectangle;
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
	int frameY = EndlessJump.height;
	int frameX = EndlessJump.width;
	BufferedImage image;
	BufferedImage cactus;
	Rectangle cactusBox;
	Rectangle finishBox;
	int cactusX = 100;
	int cactusY = 400;
	int playerWidth = 30;
	int playerHeight = 30;
	int finishX = frameX - playerWidth;
	int finishY = frameY - playerHeight;
	Timer timer;
	final int MENU_STATE = 0;
	final int GAME_STATE = 1;
	final int END_STATE = 2;
	final int WIN_STATE = 3;
	int currentState = MENU_STATE;
	int scrollSpeed = 8;
	boolean risen;
	int gravity = 5;
	int srcx1 = 0;
	int srcx2 = 0;
	int imageWidth = 0;

	Item player;
	Item finish;
	Font titleFont;
	Font enterFont;
	Font spaceFont;
	Font Endtitle;
	GameManager manager;

	GamePanel() {

		timer = new Timer(1000 / 6, this);
		player = new Item(playerWidth, playerHeight, playerWidth, frameY - playerHeight, 5, 30, Color.white, null);
		finish = new Item(playerWidth, playerHeight, finishX, finishY, 0, 0, Color.red, null);
		titleFont = new Font("time new roman", Font.PLAIN, 48);
		enterFont = new Font("time new roman", Font.PLAIN, 20);
		spaceFont = new Font("time new roman", Font.PLAIN, 20);
		Endtitle = new Font("time new roman", Font.PLAIN, 20);

		try {
			Thread.sleep(5);

			image = ImageIO.read(getClass().getResource("backgroundImage.jpg"));

			imageWidth = image.getWidth();

			cactus = ImageIO.read(getClass().getResource("cactus.png"));

			cactusBox = new Rectangle(cactusX, cactusY, cactus.getWidth(), cactus.getHeight());

			finishBox = new Rectangle(finishX, finishY, 30, 30);

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
		} else if (currentState == WIN_STATE) {
			drawWinState(g);
		}

	}

	void movingBackground() {

		if (srcx1 >= (imageWidth - frameX)) {

			srcx1 = 0;

			srcx2 = frameX;

		} else {

			srcx1 += scrollSpeed;

			srcx2 += scrollSpeed;

			System.out.println("scroll");
		}

	}

	void updateMenuState() {

	}

	void updateGameState() {
		// manager.update();
		player.update();
		finish.update();
		if (player.y + gravity <= frameY - player.height) {
			System.out.println("gravity works");
			player.y = player.y + gravity;
		}

	}

	void updateEndState() {

	}

	void updateWinState() {

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

		g.drawImage(image, 0, 0, frameX, frameY, srcx1, 0, srcx2, frameY, this);
		g.drawImage(cactus, cactusX, cactusY, null, null);
		player.draw(g);
		g.drawRect(cactusBox.x, cactusBox.y, cactusBox.width, cactusBox.height);
		finish.draw(g);
		g.drawRect(finish.x, finish.y, finish.width, finish.height);

	}

	void drawEndState(Graphics g) {

		g.setColor(Color.BLACK);
		g.setFont(titleFont);
		g.drawString("END GAME", 250, 240);

	}

	void drawWinState(Graphics g) {

		g.setColor(Color.BLACK);
		g.setFont(titleFont);
		g.drawString("You Won ! ", 250, 240);

	}

	@Override
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub

		if (currentState == MENU_STATE) {
			updateMenuState();

		} else if (currentState == GAME_STATE) {
			movingBackground();
			updateGameState();

		} else if (currentState == END_STATE) {
			updateEndState();

		}
		if (player.box.intersects(cactusBox)) {
			System.out.println("CACTUS");

			currentState = END_STATE;

		}
		if (player.box.intersects(finishBox)) {

			currentState = WIN_STATE;
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
		// NEED TO FIX
		if (player.y > 355) {
			if (e.getKeyCode() == KeyEvent.VK_UP) {
				System.out.println("UP");
				player.y = player.y - player.speedy;
				risen = true;

			}
		}

	}

	public void keyReleased(KeyEvent e) {
		// TODO Auto-generated method stub

	}

	@Override
	public void keyTyped(KeyEvent e) {
		// TODO Auto-generated method stub

	}

}
