package tetris;

import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import java.util.Random;

public class GamePanel extends JPanel implements ActionListener{

	static final int SCREEN_WIDTH = 250;
	static final int SCREEN_HEIGHT = 500;
	static final int UNIT_SIZE = 25;
	static final int DELAY = 60;
	int timerCount = 0;
	int gravity = 5;
	int[] x =  new int[4];
	int[] y = new int[4];
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
		generateTetromino();
		running = true;
		timer = new Timer(DELAY, this);
		timer.start();
	}
	
	public void generateTetromino() {
		// create a random number for the piece type
		random = new Random();
		int t = random.nextInt(7) + 1;
		// generate new piece using random number
		Tetromino piece = new Tetromino(t);
		System.out.println("Current Piece: " + piece.name);
		for (int i = 0; i < 4; i++) {			
			System.out.println(piece.pixelArrX[i]);
			x[i] = piece.pixelArrX[i] * UNIT_SIZE + (UNIT_SIZE * 4);
			System.out.println(piece.pixelArrY[i]);
			y[i] = piece.pixelArrY[i] * UNIT_SIZE;
		}
	}
	
	public void paintComponent(Graphics g) {
		super.paintComponent(g);
		draw(g);
	}
	
	public void draw(Graphics g) {
		if (running) {
			// create grid to help with visualization
			for(int i = 0; i < SCREEN_HEIGHT/UNIT_SIZE; i++) {
				g.drawLine(i*UNIT_SIZE, 0, i*UNIT_SIZE, SCREEN_HEIGHT);
				g.drawLine(0, i*UNIT_SIZE, SCREEN_WIDTH, i*UNIT_SIZE);
			}
			// draw pixel
			for (int i = 0; i < 4; i++) {				
				g.setColor(Color.green);
				g.fillRect(x[i], y[i], UNIT_SIZE, UNIT_SIZE);
			}
		} else {
			gameOver(g);
		}
	}
		
	public void moveDown() {
		// move pixel down one square
		for (int i = 0; i < 4; i++) {					
			y[i] = y[i] + UNIT_SIZE;
		}
	}
	
	public void move() {
		// check for left or right input
		if (direction == 'R') {
			if (x[0] < SCREEN_WIDTH - 25) {
				for (int i = 0; i < 4; i++) {					
					x[i] = x[i] + UNIT_SIZE;
				}
				direction = 'D';
			} else {
				direction = 'D';
			}
		}
		if (direction == 'L') {
			if (x[0] > 0) {				
				for (int i = 0; i < 4; i++) {					
					x[i] = x[i] - UNIT_SIZE;
				}
				direction = 'D';
			} else {
				direction = 'D';
			}
		}
	}
	
	public void checkCollisions() {
		// check if pixel hits the ground
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
				moveDown();
				checkCollisions();
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
				direction = 'D';
				moveDown();
				break;
			}
		}
		
	}

}
