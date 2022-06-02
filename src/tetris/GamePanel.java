package tetris;

import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import java.util.Random;

public class GamePanel extends JPanel implements ActionListener{

	static final int SCREEN_WIDTH = 250;
	static final int SCREEN_HEIGHT = 500;
	static final int UNIT_SIZE = 25;
	static final int GAME_UNITS = (SCREEN_WIDTH * SCREEN_HEIGHT) / UNIT_SIZE;
	static final int DELAY = 60;
	int timerCount = 0;
	int gravity = 5;
	int[] x =  new int[GAME_UNITS];
	int[] y = new int[GAME_UNITS];
	char direction = 'D';
	boolean running = false;
	Timer timer;
	Random random;
	
	GamePanel() {
		random = new Random();
		this.setPreferredSize(new Dimension(SCREEN_WIDTH, SCREEN_HEIGHT));
		this.setBackground(Color.black);
		this.setFocusable(true);
		this.addKeyListener(new MyKeyAdapter());
		startGame();
	}
	
	public void startGame() {
		x[0] = 100;
		running = true;
		timer = new Timer(DELAY, this);
		timer.start();
	}
	
	public void paintComponent(Graphics g) {
		super.paintComponent(g);
		draw(g);
	}
	
	public void draw(Graphics g) {
		if (running ) {
			// create grid to help with visualization
			for(int i = 0; i < SCREEN_HEIGHT/UNIT_SIZE; i++) {
				g.drawLine(i*UNIT_SIZE, 0, i*UNIT_SIZE, SCREEN_HEIGHT);
				g.drawLine(0, i*UNIT_SIZE, SCREEN_WIDTH, i*UNIT_SIZE);
			}
			
			// draw pixel
			g.setColor(Color.green);
			g.fillRect(x[0], y[0], UNIT_SIZE, UNIT_SIZE);
		} else {
			gameOver(g);
		}
	}
		
	public void moveDown() {
		// move pixel down one square
		y[0] = y[0] + UNIT_SIZE;
	}
	
	public void move() {
		// check for left or right input
		if (direction == 'R') {
			if (x[0] < SCREEN_WIDTH - 25) {
				x[0] = x[0] + UNIT_SIZE;
				direction = 'D';
			} else {
				direction = 'D';
			}
		}
		if (direction == 'L') {
			if (x[0] > 0) {				
				x[0] = x[0] - UNIT_SIZE;
				direction = 'D';
			} else {
				direction = 'D';
			}
		}
	}
	
	public void checkCollisions() {
		// check if snake head runs into wall
		if (y[0] < 0) {
			running = false;
		}
		if (y[0] > SCREEN_HEIGHT - 25) {
			running = false;
		}
		
		if (!running) {
			timer.stop();
		}
	}
	
	public void gameOver(Graphics g) {
		// game over message
		g.setColor(Color.gray);
		g.setFont(new Font("Monospaced", Font.BOLD, 32));
		FontMetrics metrics1 = getFontMetrics(g.getFont());
		g.drawString("Game Over", (SCREEN_WIDTH - metrics1.stringWidth("Game Over"))/2, SCREEN_HEIGHT/2);
	}
	
	@Override
	public void actionPerformed(ActionEvent e) {
		if (running) {
			timerCount++;
			move();
			if (timerCount == gravity) {			
				timerCount = 0;
				System.out.println("boom");
				moveDown();
				checkCollisions();
			} else {
				System.out.println("bam");
			}
		}
		repaint();
	}
	
	public class MyKeyAdapter extends KeyAdapter {
		@Override
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
			case KeyEvent.VK_DOWN:
				if (direction != 'U') {
					direction = 'D';
				}
				break;
			}
		}
		
	}

}
