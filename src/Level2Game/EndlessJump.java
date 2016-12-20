package Level2Game;
import java.awt.event.KeyListener;
import javax.swing.JFrame;

public class EndlessJump {
	
	public static int width = 500;
	public static int height = 500;
	JFrame frame;
	GamePanel gamepanel;

	public static void main(String[] args) {
		EndlessJump EndlessJump = new EndlessJump(); 
	}

	EndlessJump() {
		frame = new JFrame();
		gamepanel = new GamePanel();
	
		setup();

	}

	void setup() {
		
		frame.setVisible(true);
		frame.setSize(width, height);
		gamepanel.startGame();
		frame.setDefaultCloseOperation(frame.EXIT_ON_CLOSE);

	}

}
