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
import java.awt.image.ImageObserver;

import javax.imageio.ImageIO;
import javax.swing.Box;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.Timer;

public class GamePanel extends JPanel implements ActionListener, KeyListener {

	BufferedImage backgroundImage;
	Rectangle finishBox;
	Timer timer;

	final int MENU_STATE = 0;
	final int GAME_STATE = 1;
	final int END_STATE = 2;
	final int WIN_STATE = 3;
	int frameY = EndlessJump.height;
	int frameX = EndlessJump.width;
	int playerWidth = 25;
	int playerHeight = 25;
	int finishX = 655;
	int finishY = 505;
	int gravity = 3;
	int srcx1 = 0;
	int srcx2 = 0;
	int imageWidth = 0;
	int scrollSpeed = 8;
	int currentState = MENU_STATE;
	int timeLimit = 35000;
	boolean Upwards;
	Item player;
	Item finish;
	Font titleFont;
	Font enterFont;
	Font spaceFont;
	Font Endtitle;

	CactusManager cactusManager = new CactusManager();
	JLabel timeLabel = new JLabel();

	GamePanel() {

		timer = new Timer(1000 / 6, this);
		player = new Item(playerWidth, playerHeight, 45, 505, 5, 30, Color.white, null);
		finish = new Item(playerWidth, playerHeight, finishX, finishY, 0, 0, Color.red, null);
		titleFont = new Font("time new roman", Font.PLAIN, 60);
		enterFont = new Font("time new roman", Font.PLAIN, 30);
		spaceFont = new Font("time new roman", Font.PLAIN, 30);
		Endtitle = new Font("time new roman", Font.PLAIN, 30);

		try {

			backgroundImage = ImageIO.read(getClass().getResource("backgroundImage.jpg"));

			imageWidth = backgroundImage.getWidth();

		} catch (Exception e) {

			System.err.println("Couldn't find this image: " + backgroundImage);

		}
		timer.start();
	}

	void startEndGameTimer(long delay) {
		new java.util.Timer().schedule(new java.util.TimerTask() {
			@Override
			public void run() {
				System.out.println("Yo");
			}
		}, delay * 1000);
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

		timeLimit -= 1000 / 6;
		if (timeLimit <= 0) {

			currentState = END_STATE;
			System.out.println("time");

		}

		player.update();

		if (player.timeGiven) {

			timeLimit += 35000;

			player.timeGiven = false;

		}

		finish.update();
		cactusManager.update();
		if (player.y <= frameY - player.height) {
			System.out.println("gravity works");
			player.y = player.y + gravity;
			// drags the player down
			System.out.println("first" + player.y);
			if (player.y > 506) {
				player.y = 506;
				System.out.println("second" + player.y);
			}
		}

		if (cactusManager.intersects(player)) {
			System.out.println("CACTUS");
			currentState = END_STATE;
		}

		if (player.cactusBox.intersects(finish.cactusBox)) {

			currentState = WIN_STATE;
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
		g.drawString("EndlessJump", 200, 400);

		g.setFont(enterFont);
		g.setColor(Color.black);
		g.drawString("Press ENTER to start ", 180, 300);

		g.setFont(spaceFont);
		g.setColor(Color.black);
		g.drawString("Press SPACE for intructions", 180, 340);

	}

	void drawGameState(Graphics g) {
		g.drawImage(backgroundImage, 0, 0, frameX, frameY, srcx1, 0, srcx2, frameY, this);
		// background
		player.draw(g);// white dot
		g.drawRect(finish.x, finish.y, finish.width, finish.height);
		finish.draw(g);// red dot

		cactusManager.draw(g);

		g.setFont(enterFont);
		g.setColor(Color.black);
		g.drawString("Time Left: " + timeLimit / 1000, EndlessJump.width - 200, 50);

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

		repaint();

	}

	public void keyPressed(KeyEvent e) {

		System.out.println("Console");

		if (e.getKeyCode() == KeyEvent.VK_ENTER) {
			if (currentState == MENU_STATE) {
				currentState = GAME_STATE;

			}

		}
		// FIXED Maybe...
		if (player.y > 0) {
			if (e.getKeyCode() == KeyEvent.VK_UP) {
				System.out.println("UP");
				player.y = player.y - player.speedy;
				Upwards = true;
// focus on the amount of height the player is able to go up
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

	public void addKeyListener(EndlessJump l) {
		// TODO Auto-generated method stub

	}

}
