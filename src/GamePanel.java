import java.awt.Color;
import java.awt.Graphics;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JPanel;
import javax.swing.Timer;

public class GamePanel extends JPanel implements ActionListener {
	Timer time;
	int x;
	int y;
	Box box;
	boolean up = false;
	boolean down = false;
	final int speed = 7;
	BoxManager manager;

	GamePanel() {
		time = new Timer(1000 / 60, this);
		box = new Box(60, 60, 35, 35, 10, 2, Color.pink);

		manager = new BoxManager();
	}

	public void paintComponent(Graphics g) {
		manager.draw(g);
	}

	public void start() {
		time.start();

	}

	@Override
	public void actionPerformed(ActionEvent e) {
		manager.update();
		repaint();

	}
}
