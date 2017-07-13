package Level2Game;

import java.awt.Rectangle;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import javax.swing.JFrame;

public class EndlessJump implements KeyListener {

	public final static int width = 700;
	public final static int height = 550;
	JFrame frame;
	GamePanel gamepanel;

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
		frame.setTitle("EndlessJump");
		setup();

	}

	void setup() {

		frame.add(gamepanel);
		frame.setVisible(true);
		frame.setSize(width, height);
		frame.setDefaultCloseOperation(frame.EXIT_ON_CLOSE);
		// gamepanel.addKeyListener(this);

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
