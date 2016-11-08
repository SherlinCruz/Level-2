import java.awt.Rectangle;
import java.awt.Graphics;
import java.awt.Color;
import javax.swing.JFrame;
import javax.swing.JPanel;

public class Box_Collision {
	JFrame frame;
	GamePanel panel;

	public static void main(String[] args) {
		Box_Collision a = new Box_Collision();
		
	}

	Box_Collision() {
		frame = new JFrame();
		panel = new GamePanel(0, 0, 0, 0);
		Rectangle square = new Rectangle();
		setup();
	}

	void setup() {
		frame.add(panel);
		frame.setSize(500, 500);
		frame.setVisible(true);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	}

}