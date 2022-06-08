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
	int[] activePieceX =  new int[4];
	int[] activePieceY = new int[4];
	int[] staticPiecesX = new int[GAME_UNITS];
	int[] staticPiecesY = new int[GAME_UNITS];
	int pieceId;
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
		for (int i = 0; i < GAME_UNITS; i++) {
			staticPiecesX[i] = -1;
			staticPiecesY[i] = -1;
		}
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
		pieceId = piece.id;
		for (int i = 0; i < 4; i++) {			
			activePieceX[i] = piece.pixelArrX[i];
			activePieceY[i] = piece.pixelArrY[i];
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
			//get color
			Color color;
			if (pieceId == 1 || pieceId == 4 ||pieceId == 7) {
				color = Color.white;
			} else if (pieceId == 1 || pieceId == 5) {
				color = Color.blue;
			} else {
				color = Color.red;
			}
			// draw active pixels
			for (int i = 0; i < 4; i++) {				
				g.setColor(color);
				g.fillRect(activePieceX[i], activePieceY[i], UNIT_SIZE, UNIT_SIZE);
			}
			// draw static pixels
			for (int i = 0; i < GAME_UNITS; i++) {
				if (staticPiecesX[i] != -1 && staticPiecesY[i] != -1) {		
					System.out.println(staticPiecesX[i]);
					System.out.println(staticPiecesY[i]);
					g.setColor(color);
					g.fillRect(staticPiecesX[i], staticPiecesY[i], UNIT_SIZE, UNIT_SIZE);
				}
			}
		} else {
			gameOver(g);
		}
	}
		
	public void moveDown() {
		for (int i = 0; i < 4; i++) {					
			activePieceY[i] = activePieceY[i] + UNIT_SIZE;
		}
	}
	
	public void moveLeft() {
		// get left most pixel
		int min = SCREEN_WIDTH;
		for (int i = 0; i < activePieceX.length; i++) {
	        if (activePieceX[i] < min) {
	            min = activePieceX[i];
	        }
	    }
		// ensure it can move before moving
		if (min > 0) {
			for (int i = 0; i < 4; i++) {					
				activePieceX[i] = activePieceX[i] - UNIT_SIZE;
			}
		}
	}
	
	public void moveRight() {
		// get right most pixel
		int max = 0;
		for (int i = 0; i < activePieceX.length; i++) {
	        if (activePieceX[i] > max) {
	            max = activePieceX[i];
	        }
	    }
		// ensure it can move before moving
		if (max < SCREEN_WIDTH - 25) {
			for (int i = 0; i < 4; i++) {					
				activePieceX[i] = activePieceX[i] + UNIT_SIZE;
			}
		}
	}
	
	public void checkCollisions() {
		// get lowest pixel
		int max = 0;
		for (int i = 0; i < activePieceY.length; i++) {
	        if (activePieceY[i] > max) {
	            max = activePieceY[i];
	        }
	    }
		// check if pixel hits the ground
		if (max > SCREEN_HEIGHT - 25) {
			// add active piece to static X array
			byte c = 0;
			for (int i = 0; i < staticPiecesX.length; i++) {
				if (staticPiecesX[i] == -1) {
					if (c < 4) {	
						staticPiecesX[i] = activePieceX[c];
						System.out.println(staticPiecesX[i]);
						c++;
					}
				} else {
					continue;
				}
			}
			// add active piece to static Y array
			byte d = 0;
			for (int i = 0; i < staticPiecesY.length; i++) {
				if (staticPiecesY[i] == -1) {
					if (d < 4) {		
						staticPiecesY[i] = activePieceY[d] - 25;
						System.out.println(staticPiecesY[i]);
						d++;
					}
				} else {
					continue;
				}
			}
			generateTetromino();
//			running = false;
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
				moveLeft();
				break;
			case KeyEvent.VK_RIGHT:
				moveRight();
				break;
			case KeyEvent.VK_DOWN:
				moveDown();
				break;
			}
		}
		
	}

}
