import java.awt.Rectangle;

import javax.swing.JFrame;
import javax.swing.JPanel;

public class BoxCollision {
	JFrame frame;
	final static int width = 500;
	final static int height = 500;
	GamePanel panel;
	
	int x;
	int y;
	int rectwidth;
	int rectheight;
	Rectangle rectangle = new Rectangle();

	public static void main(String[] args) {
		BoxCollision box = new BoxCollision();
		box.setup();
	}

	BoxCollision() {
		frame = new JFrame();
		panel = new GamePanel();
		panel.start();
		
	//	Box box = box(int)(Math.random() * 500, ); 
		
	}

	void setup() {
		frame.add(panel);
		frame.setVisible(true);
		frame.setSize(width, height);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	}
}
