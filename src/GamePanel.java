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
	final int speed = 6;

	GamePanel() {
		time = new Timer(1000 / 60, this);
		box = new Box(60, 60, 35, 35, 10, 2, Color.pink);
	}

	public void paintComponent(Graphics g) {
		g.fillRect(235, 210, 50, 50);
		box.draw(g);
	}

	public void start() {
		time.start();

	}

	@Override
	public void actionPerformed(ActionEvent e) {
		box.update();
		repaint();

	}
}
