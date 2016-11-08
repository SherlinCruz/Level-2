import java.awt.Color;
import java.awt.Graphics;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JPanel;
import javax.swing.Timer;

public class GamePanel extends JPanel implements ActionListener {
	Timer timer;
	int x = 10;
	int y = 10;
	int width = 10;
	int height = 10;

	GamePanel(int x, int y, int width, int height) {
		timer = new Timer(1000 / 60, this);
		this.x = x;

		this.y = y;

		this.width = width;

		this.height = height;
	}

	public void paintComponent(Graphics g) {
		g.fillRect(220, 200, 50, 50);
		g.setColor(Color.BLACK);
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub

	}

}
