package Level2Game;

import java.awt.Rectangle;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import javax.swing.JFrame;

public class EndlessJump implements KeyListener {

	final static int width = 500;
	final static int height = 502;
	JFrame frame;
	GamePanel gamepanel;
	int x;
	int y;
	int rectwidth;
	int rectheight;
	Rectangle rectangle = new Rectangle();

	public static void main(String[] args) {
		EndlessJump EndlessJump = new EndlessJump();

	}

	EndlessJump() {

		frame = new JFrame();
		gamepanel = new GamePanel(width, height);
		frame.addKeyListener(gamepanel);
		setup();

	}

	void setup() {
		frame.add(gamepanel);
		frame.setVisible(true);
		frame.setSize(width, height);
		gamepanel.startGame();
		gamepanel.addKeyListener(this);
		frame.setDefaultCloseOperation(frame.EXIT_ON_CLOSE);

	}

	@Override
	public void keyTyped(KeyEvent e) {
		// TODO Auto-generated method stub

	}

	@Override
	public void keyPressed(KeyEvent e) {
		// TODO Auto-generated method stub

	}

	@Override
	public void keyReleased(KeyEvent e) {
		// TODO Auto-generated method stub

	}

}
