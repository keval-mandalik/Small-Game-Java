package SnakeGame;
import java.awt.*;

//import java.awt.*;
import javax.swing.*;


public class SnakeFrame{
	ImageIcon icon = new ImageIcon("src/Icons/snake_200x200.png");
			
	public SnakeFrame()  {
		JFrame sFrame = new JFrame("Snake Game");
		sFrame.setResizable(false);
		sFrame.add(new GamePanel());
		sFrame.pack();
		sFrame.setIconImage(icon.getImage());
		sFrame.setLocationRelativeTo(null);
		sFrame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		sFrame.setVisible(true);
		
	}
}
