package Level2Game;

import java.awt.Color;

import java.awt.Font;
import java.awt.Graphics;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

import javax.swing.JPanel;
import javax.swing.Timer;

public class GamePanel extends JPanel implements ActionListener {

	Timer timer;
	final int MENU_STATE = 0;
	final int GAME_STATE = 1;
	final int END_STATE = 2;
	int currentState = MENU_STATE;
	Font titleFont;
	Font enterFont;
	Font spaceFont;
	Font Endtitle;

	GamePanel() {
		timer = new Timer(1000 / 6, this);
		titleFont = new Font("time new roman", Font.PLAIN, 48);
		enterFont = new Font("time new roman", Font.PLAIN, 20);
		spaceFont = new Font("time new roman", Font.PLAIN, 20);
		Endtitle = new Font("time new roman", Font.PLAIN, 20);
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

	}

	void updateMenuState() {

	}

	void updateGameState() {

	}

	void updateEndState() {

	}

	void drawMenuState(Graphics g) {

		g.setColor(Color.BLACK);

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
		g.setColor(Color.black);
		g.fillRect(0, 0, EndlessJump.width, EndlessJump.height);

	}

	void drawEndState(Graphics g) {
		g.setColor(Color.red);
		g.fillRect(0, 0, 500, 500);
		g.setFont(Endtitle);
		g.drawString("You lost ! To bad ", 100, 100);
		g.setColor(Color.pink);

	}

	@Override
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub

		if (currentState == MENU_STATE) {
			updateMenuState();
		} else if (currentState == GAME_STATE) {
			updateGameState();
		} else if (currentState == END_STATE) {
			updateEndState();
		}
		repaint();

	}

	public void keyTyped(KeyEvent e) {
		// TODO Auto-generated method stub

	}

	public void keyPressed(KeyEvent e) {

		System.out.println("Console");

		if (e.getKeyCode() == KeyEvent.VK_ENTER) {
			if (currentState == MENU_STATE) {
				currentState = GAME_STATE;

			}
		}

	}

	public void keyReleased(KeyEvent e) {
		// TODO Auto-generated method stub

		// System.out.println("Console");

	}

}