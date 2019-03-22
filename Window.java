package purple_rain;

import javax.swing.JFrame;
import javax.swing.JPanel;
import java.awt.Graphics;

public class Window extends JFrame implements Runnable {
	private Drop[] drops = new Drop[150];
	
	@Override public void run() {
		while(true) {
			for(Drop d : drops) {
				d.fall();
				try {
					Thread.sleep(6);
				} catch(InterruptedException e) {
					e.printStackTrace();
				}
			}
		}
	}
	
	public Window() {
		for(int i = 0; i < drops.length; i++)
			drops[i] = new Drop();
		setTitle("Purple Rain");
		setSize(800, 600);
		setResizable(false);
		setDefaultCloseOperation(EXIT_ON_CLOSE);
		add(new JPanel() {
			@Override public void paintComponent(Graphics g) {
				super.paintComponent(g);
				for(Drop d : drops)
					d.drawDrop(g);
				repaint();
			}
		});
		new Thread(this).start();
		setVisible(true);
	}	
	
	public static void main(String[] args) {
		new Window();
	}
}
