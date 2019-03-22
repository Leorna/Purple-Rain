package purple_rain;

import java.awt.Color;
import java.awt.Graphics;
import java.util.Random;

public class Drop extends Random {
	private int x = nextInt(800);
	private int y = -nextInt(100);
	private int speed = nextInt(80);
	private int len = nextInt(75);
	
	public void fall() {
		y += speed;
		if(y > 600) {
			y = -nextInt(100);
			speed = nextInt(90);
		}
	}
	
	public void drawDrop(Graphics g) {
		g.setColor(new Color(255, 0, 255));
		g.drawLine(x, y, x, y + len);
	}
}
