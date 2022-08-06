package SnakeGame;

import java.awt.*;
import java.awt.event.*;
import java.util.Random;
import javax.swing.*;

public class GamePanel extends JPanel implements ActionListener {

	static final int SCREEN_WIDTH = 740;
	static final int SCREEN_HEIGHT = 700;
	static final int UNIT_SIZE = 20;
	static final int TOTAL_UNITS = (SCREEN_WIDTH * SCREEN_HEIGHT) / UNIT_SIZE;
	final int x[] = new int[TOTAL_UNITS];
	final int y[] = new int[TOTAL_UNITS - UNIT_SIZE];
	int SnakeBodyParts = 4;
	int applesEaten = 0;
	int DELAY = 200;
	int appleX;
	int appleY;
	char direction = 'R';
	boolean running = false;
	Random random;
	Timer timer;
	JButton pause;
	JButton resume;
//	JButton pAgain;

	public GamePanel() {

		random = new Random();
		pause = new JButton("Pause");
		resume = new JButton("Resume");
//		pAgain = new JButton("Play Again");

		resume.setSize(65, 20);
//		resume.setOpaque(false);
		resume.setContentAreaFilled(false);
		resume.setFont(new Font("Consolas", Font.BOLD, 18));
		resume.setFocusPainted(false);
		resume.setForeground(Color.red);
		resume.setLocation(0, 0);
//		resume.setBackground(Color.black);
		resume.setBorder(BorderFactory.createEmptyBorder());
		resume.setVisible(false);
		resume.addActionListener(new ActionListener() {

			public void actionPerformed(ActionEvent e) {
				if (e.getSource() == resume) {
					resume();
					resume.setVisible(false);
					pause.setVisible(true);

				}
			}
		});

		pause.setSize(55, 20);
//		pause.setOpaque(false);
		pause.setContentAreaFilled(false);
		pause.setFont(new Font("Consolas", Font.BOLD, 18));
		pause.setFocusPainted(false);
		pause.setForeground(Color.red);
		pause.setLocation(0, 0);
//		pause.setBackground(Color.black);
		pause.setBorder(BorderFactory.createEmptyBorder());
		pause.addActionListener(new ActionListener() {

			public void actionPerformed(ActionEvent e) {
				if (e.getSource() == pause) {
					pause();
					pause.setVisible(false);
					resume.setVisible(true);
				}
			}
		});

//		pAgain.setSize(120, 25);
////		pause.setOpaque(false);
//		pAgain.setContentAreaFilled(false);
//		pAgain.setFont(new Font("Consolas", Font.BOLD, 20));
//		pAgain.setFocusPainted(false);
//		pAgain.setForeground(Color.red);
//		pAgain.setLocation(SCREEN_WIDTH / 2 - 60, SCREEN_HEIGHT / 2 + 50);
//		pAgain.setVisible(false);
////		pause.setBackground(Color.black);
//		pAgain.setBorder(BorderFactory.createEmptyBorder());
//		pAgain.addActionListener(new ActionListener() {
//
//			public void actionPerformed(ActionEvent e) {
//				if (e.getSource() == pAgain) {
//					pAgain.setVisible(false);
//				}
//			}
//		});
		this.setLayout(null);
		this.setPreferredSize(new Dimension(SCREEN_WIDTH, SCREEN_HEIGHT));
		this.add(resume);
		this.add(pause);
//		this.add(pAgain);
		this.setBackground(Color.black);
		this.setFocusable(true);
		this.addKeyListener(new MyKeyAdapter());
		this.setVisible(true);

		StartGame();
	}

	public void StartGame() {
		running = true;
		newApple();
		timer = new Timer(DELAY, this);
		timer.setInitialDelay(DELAY);
		timer.start();
	}

	public void newApple() {
		appleX = random.nextInt(SCREEN_WIDTH / UNIT_SIZE) * UNIT_SIZE;
		appleY = random.nextInt((SCREEN_HEIGHT - UNIT_SIZE) / UNIT_SIZE) * UNIT_SIZE + UNIT_SIZE;
		for (int i = SnakeBodyParts; i > 0; i--) {
			if ((appleX == x[i]) && (appleY == y[i])) {
				newApple();
			}
		}
	}

	public void paintComponent(Graphics g) {
		super.paintComponent(g);
		draw(g);
	}

	public void draw(Graphics g) {

		if (running) {
			g.setColor(Color.RED);
			g.fillOval(appleX, appleY, UNIT_SIZE, UNIT_SIZE);
			g.setFont(new Font("Consolas", Font.BOLD, 18));
			g.drawString("Score : " + applesEaten, SCREEN_WIDTH - 100, UNIT_SIZE);

			g.setColor(Color.GREEN);
			g.fillRect(x[0], y[0], UNIT_SIZE, UNIT_SIZE);

			for (int i = 1; i < SnakeBodyParts; i++) {

				g.setColor(new Color(45, 180, 0));
				g.fillRect(x[i], y[i], UNIT_SIZE, UNIT_SIZE);

			}
		} else {
			GameOver(g);
//			pAgain.setVisible(true);
		}
	}

	public void move() {
		for (int i = SnakeBodyParts; i > 0; i--) {
			x[i] = x[i - 1];
			y[i] = y[i - 1];
		}
		switch (direction) {
		case 'U':
			y[0] = y[0] - UNIT_SIZE;
			break;
		case 'D':
			y[0] = y[0] + UNIT_SIZE;
			break;
		case 'R':
			x[0] = x[0] + UNIT_SIZE;
			break;
		case 'L':
			x[0] = x[0] - UNIT_SIZE;
			break;
		}
	}

	public void checkApple() {
		if ((x[0] == appleX) && (y[0] == appleY)) {
			newApple();
			applesEaten++;
			timer.setDelay(DELAY = DELAY - 2);
			SnakeBodyParts++;
		}

	}

	public void checkCollisions() {

		for (int i = SnakeBodyParts; i > 0; i--) {
			if ((x[0] == x[i]) && (y[0] == y[i]))
				running = false;
		}
		if (x[0] >= SCREEN_WIDTH) {
			running = false;
		}
		if (x[0] < 0) {
			running = false;
		}
		if (y[0] < 0) {
			running = false;
		}
		if (y[0] >= SCREEN_HEIGHT) {
			running = false;
		}
		if (!running) {
			timer.stop();
			pause.setVisible(false);
			resume.setVisible(false);
		}
	}

	public void GameOver(Graphics g) {
		g.setFont(new Font("Consolas", Font.BOLD, 40));
		g.setColor(Color.red);
		g.drawString("Game Over", SCREEN_WIDTH / 2 - 100, SCREEN_HEIGHT / 2 - 50);
		g.setFont(new Font("Consolas", Font.PLAIN, 30));
		g.drawString("Score : " + applesEaten, SCREEN_WIDTH / 2 - 80, SCREEN_HEIGHT / 2);
	}

	public void pause() {
		timer.stop();
	}

	public void resume() {
		timer.start();
	}

	public void actionPerformed(ActionEvent e) {
		if (running) {
			move();
			checkApple();
			checkCollisions();
		}
		repaint();

	}

	public class MyKeyAdapter extends KeyAdapter {
		public void keyPressed(KeyEvent e) {
			switch (e.getKeyCode()) {
			case KeyEvent.VK_LEFT:
				if (direction != 'R') {
					direction = 'L';
				}
				break;
			case KeyEvent.VK_RIGHT:
				if (direction != 'L') {
					direction = 'R';
				}
				break;
			case KeyEvent.VK_UP:
				if (direction != 'D') {
					direction = 'U';
				}
				break;
			case KeyEvent.VK_DOWN:
				if (direction != 'U') {
					direction = 'D';
				}
				break;
			}
		}
	}
}
