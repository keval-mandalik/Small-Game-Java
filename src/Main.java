import java.awt.*;
import java.awt.event.*;
import javax.swing.*;

import PingPong.GameFrame;
import SnakeGame.*;
import TicTacToe.*;

public class Main {
	public static void main(String[] args) {
		JFrame mainFrame = new JFrame("Small Games");

		ImageIcon top = new ImageIcon("./Icons/top.png");
		ImageIcon bot1 = new ImageIcon("./Icons/snake_200x200.png");
		ImageIcon bot2 = new ImageIcon("./Icons/new.png");
		ImageIcon bot3 = new ImageIcon("./Icons/pong (1).jpg");
		
		JLabel topLabel = new JLabel();
		topLabel.setIcon(top);

		JLabel bottomLabel1 = new JLabel(); // bottom panel 1 (snake)
		bottomLabel1.setIcon(bot1);
		bottomLabel1.setText("Snake Game");
		bottomLabel1.setFont(new Font("Consolas", Font.BOLD, 20));
		bottomLabel1.setForeground(Color.WHITE);
		bottomLabel1.setVerticalTextPosition(JLabel.BOTTOM);
		bottomLabel1.setHorizontalTextPosition(JLabel.CENTER);

		JButton b1 = new JButton("Play"); // bottom panel 1 (snake) button
		b1.setFont(new Font("Consolas", Font.BOLD, 20));
		b1.setBounds(50, 250, 150, 30);
//		b1.setBorder(BorderFactory.createEmptyBorder());
		b1.setFocusPainted(false);
		b1.setBackground(Color.GRAY);
//		b1.setContentAreaFilled(false);
		b1.addActionListener(new ActionListener() {

			public void actionPerformed(ActionEvent e) {
				if (e.getSource() == b1) {
					new SnakeFrame();

				}
			}
		});

		JLabel bottomLabel2 = new JLabel(); // bottom panel 2 (tic-tac-toe)
		bottomLabel2.setIcon(bot2);
		bottomLabel2.setText("Tic-Tac-Toe");
		bottomLabel2.setFont(new Font("Consolas", Font.BOLD, 20));
		bottomLabel2.setForeground(Color.WHITE);
		bottomLabel2.setVerticalTextPosition(JLabel.BOTTOM);
		bottomLabel2.setHorizontalTextPosition(JLabel.CENTER);

		JButton b2 = new JButton("Play"); // bottom panel 1 (snake) button
		b2.setFont(new Font("Consolas", Font.BOLD, 20));
		b2.setBounds(50, 250, 150, 30);
//		b2.setBorder(BorderFactory.createEmptyBorder());
		b2.setFocusPainted(false);
		b2.setBackground(Color.GRAY);
//		b2.setContentAreaFilled(false);
		b2.addActionListener(new ActionListener() {

			public void actionPerformed(ActionEvent e) {
				if (e.getSource() == b2) {
					new TicTacToe();

				}
			}
		});
		
		JLabel bottomLabel3 = new JLabel(); // bottom panel 2 (tic-tac-toe)
		bottomLabel3.setIcon(bot3);
		bottomLabel3.setText("Ping Pong");
		bottomLabel3.setFont(new Font("Consolas", Font.BOLD, 20));
		bottomLabel3.setForeground(Color.WHITE);
		bottomLabel3.setVerticalTextPosition(JLabel.BOTTOM);
		bottomLabel3.setHorizontalTextPosition(JLabel.CENTER);

		JButton b3 = new JButton("Play"); // bottom panel 1 (snake) button
		b3.setFont(new Font("Consolas", Font.BOLD, 20));
		b3.setBounds(50, 250, 150, 30);
//		b3.setBorder(BorderFactory.createEmptyBorder());
		b3.setFocusPainted(false);
		b3.setBackground(Color.GRAY);
//		b3.setContentAreaFilled(false);
		b3.addActionListener(new ActionListener() {

			public void actionPerformed(ActionEvent e) {
				if (e.getSource() == b3) {
					new GameFrame();
				}
			}
		});
//		
		

		JPanel topPanel = new JPanel(); // Top panel (main)
//    	topPanel.setLayout(null);
		topPanel.setBorder(BorderFactory.createBevelBorder(1, Color.white, Color.white));
		topPanel.setBounds(0, 0, 735, 380);
		topPanel.setBackground(Color.black);
		topPanel.add(topLabel);

		JPanel bottomPanel1 = new JPanel();
		bottomPanel1.setBounds(0, 380, 250, 300);
		bottomPanel1.setBackground(Color.black);
//		bottomPanel1.setBorder(BorderFactory.createBevelBorder(1, Color.white, Color.white));
		bottomPanel1.add(bottomLabel1);
		bottomPanel1.add(b1);

		JPanel bottomPanel2 = new JPanel();
		bottomPanel2.setBounds(250, 375, 250, 305);
		bottomPanel2.setBackground(Color.black);
		bottomPanel2.setBorder(BorderFactory.createBevelBorder(1, Color.white, Color.white));
		bottomPanel2.add(bottomLabel2);
		bottomPanel2.add(b2);

		JPanel bottomPanel3 = new JPanel();
		bottomPanel3.setBounds(500, 380, 250, 300);
		bottomPanel3.setBackground(Color.black);
		bottomPanel3.setBorder(BorderFactory.createBevelBorder(1, Color.white, Color.white));
		bottomPanel3.add(bottomLabel3);
		bottomPanel3.add(b3);

		
		//add to frame
		mainFrame.add(topPanel);
		mainFrame.add(bottomPanel1);
		mainFrame.add(bottomPanel2);
		mainFrame.add(bottomPanel3);

		
		//frame properties
		mainFrame.setBackground(Color.red);
		mainFrame.setLayout(new BorderLayout());
		mainFrame.setLocationRelativeTo(null);
		mainFrame.setSize(750, 700);
		mainFrame.setLocationRelativeTo(null);
		mainFrame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		mainFrame.setVisible(true);
		mainFrame.setResizable(false);
	}
}
