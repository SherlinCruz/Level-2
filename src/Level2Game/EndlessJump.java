package Level2Game;

import java.awt.Rectangle;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import javax.swing.JFrame;

public class EndlessJump {

	final static int width = 500;
	final static int height = 500;
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
		gamepanel = new GamePanel();
		frame.addKeyListener(gamepanel);

		setup();

	}

	void setup() {
		frame.add(gamepanel);
		frame.setVisible(true);
		frame.setSize(width, height);
		gamepanel.startGame();
		frame.setDefaultCloseOperation(frame.EXIT_ON_CLOSE);

	}

}
