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
import java.util.Random;
import javax.imageio.ImageIO;
import javax.swing.Box;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.Timer;

public class GamePanel extends JPanel implements ActionListener, KeyListener {

	BufferedImage backgroundImage;
	Rectangle finishBox;
	Timer timer;
	Item item;

	final int MENU_STATE = 0;
	final int GAME_STATE = 1;
	final int END_STATE = 2;
	final int WIN_STATE = 3;
	final int INSTRUCTIONS_STATE = 4;
	Random randomNumber = new Random();
	int frameY = EndlessJump.height;
	int frameX = EndlessJump.width;
	int playerWidth = 23;
	int playerHeight = 23;
	int finishX = randomNumber.nextInt(600);
	// 675
	int finishY = randomNumber.nextInt(500);
	// 525
	int gravity = 3;
	int srcx1 = 0;
	int srcx2 = 0;
	int imageWidth = 0;
	int scrollSpeed = 8;
	int currentState = MENU_STATE;
	int timeLimit = 35000;
	boolean Upwards;
	Item player;
	static Item finish;
	Font titleFont;
	Font enterFont;
	Font spaceFont;
	Font Endtitle;

	CactusManager cactusManager = new CactusManager();

	JLabel timeLabel = new JLabel();

	GamePanel() {

		timer = new Timer(1000 / 6, this);
		player = new Item(playerWidth, playerHeight, 22, 450, 5, 25, Color.white, null);

		// +++++++
		finish = new Item(playerWidth, playerHeight, finishX, finishY - 50, 0, 0, Color.pink, null);

		// ++++++
		while (cactusManager.checkCactus(finishX, finishY)) {
			finishX = new Random().nextInt(675);
			finishY = new Random().nextInt(374);
			// finishX = randomNumber.nextInt(675);
			// finishY = randomNumber.nextInt(374);

		}

		if (finishY < 80) {
			finishY = new Random().nextInt(374);
			System.out.println("finishY is less");
		}

		titleFont = new Font("time new roman", Font.PLAIN, 60);
		enterFont = new Font("time new roman", Font.PLAIN, 20);
		spaceFont = new Font("time new roman", Font.PLAIN, 20);
		Endtitle = new Font("time new roman", Font.PLAIN, 20);

		try {

			backgroundImage = ImageIO.read(getClass().getResource("backgroundImage.jpg"));

			imageWidth = backgroundImage.getWidth();

		} catch (Exception e) {

			System.err.println("Couldn't find this image: " + backgroundImage);

		}

		while (finish.cactusBox.intersects(player.cactusBox)) {
			finishX = randomNumber.nextInt(675);
			finishY = randomNumber.nextInt(374);

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
		}
		if (currentState == INSTRUCTIONS_STATE) {
			drawInstructionsState(g);
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

		}

	}

	void updateMenuState() {

	}

	void updateGameState() {

		timeLimit -= 1000 / 6;
		if (timeLimit <= 0) {

			System.out.println("time out");
			currentState = END_STATE;

		}

		player.update();

		if (player.timeGiven) {

			timeLimit += 35000;

			player.timeGiven = false;

		}

		finish.update();
		cactusManager.update();
		if (player.y <= frameY - player.height) {
			// drags the player down
			player.y = player.y + gravity;

			if (player.y > 506) {

				player.y = 506;

			}
		}

		if (cactusManager.intersects(player)) {

			currentState = END_STATE;

			System.out.println("intersect");
		}

		if (player.cactusBox.intersects(finish.cactusBox)) {

			currentState = WIN_STATE;

		}

	}

	void updateEndState() {

	}

	void updateWinState() {

	}

	void upddateInstructionState() {

	}

	void drawMenuState(Graphics g) {

		g.setFont(titleFont);
		g.setColor(Color.black);
		g.drawString("EndlessJump", 150, 160);

		g.setFont(enterFont);
		g.setColor(Color.black);
		g.drawString("Press ENTER to start ", 160, 210);

		g.setFont(spaceFont);
		g.setColor(Color.black);
		g.drawString("Press SPACE for intructions", 160, 250);

	}

	void drawInstructionsState(Graphics g) {

		g.setColor(Color.black);
		g.setFont(titleFont);
		g.drawString("Instructions ", 130, 160);
		g.setFont(spaceFont);
		g.drawString("Get the player(white dot) to the finish ", 120, 210);
		g.drawString("(pink dot) without coming near a cactus.", 130, 240);
		g.drawString("The player will move right until it reaches ", 120, 270);
		g.drawString("the end of the right screen it will then move ", 130, 300);
		g.drawString("left until it reaches the end of the left wall. ", 120, 330);
		g.drawString("Figure out a way to get to the finish line before the ", 130, 360);
		g.drawString("time is up. Time will be added when player reaches either  ", 120, 390);
		g.drawString("side of the wall without yet getting to the finish.", 130, 420);

	}

	void drawGameState(Graphics g) {

		g.drawImage(backgroundImage, 0, 0, frameX, frameY, srcx1, 0, srcx2, frameY, this);

		//// g.drawRect(finish.x, finish.y, finish.width, finish.height);

		finish.draw(g);

		player.draw(g);

		cactusManager.draw(g);

		g.setFont(enterFont);
		g.setColor(Color.black);
		g.drawString("Time Left: " + timeLimit / 1000, EndlessJump.width - 200, 50);

	}

	void drawEndState(Graphics g) {

		g.setColor(Color.BLACK);
		g.setFont(titleFont);
		g.drawString("END GAME", 160, 240);

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

		if (e.getKeyCode() == KeyEvent.VK_ENTER) {
			if (currentState == MENU_STATE) {

				currentState = GAME_STATE;

			}
		}

		if (e.getKeyCode() == KeyEvent.VK_SPACE) {

			currentState = INSTRUCTIONS_STATE;
		}

		if (e.getKeyCode() == KeyEvent.VK_ENTER) {

			currentState = GAME_STATE;

			if (currentState == GAME_STATE) {

				System.out.println("done ");

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
