package tetris;

import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import java.util.Random;
import java.util.ArrayList;
import java.util.HashMap;

public class GamePanel extends JPanel implements ActionListener{

	// set screen size
	static final int SCREEN_WIDTH = 250;
	static final int SCREEN_HEIGHT = 500;
	// set pixel size
	static final int UNIT_SIZE = 25;
	// get total count of pixels
	static final int GAME_UNITS = (SCREEN_WIDTH * SCREEN_HEIGHT) / UNIT_SIZE;
	// set up timer and drop rate
	static final int DELAY = 60;
	int timerCount = 0;
	int gravity = 2;
	boolean running = false;
	Timer timer;
	Random random;
	Pixel pixel;
	
	Tetromino currentPiece;
	ArrayList<Pixel> staticPixels = new ArrayList<Pixel>();
	
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
		System.out.println("Current Piece: " + piece.name + " | " + piece.colorCode);
		currentPiece = piece;
		checkCollisions(1);
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
			// draw active pixels
			for (int i = 0; i < 4; i++) {	
				//get color
				Color color;
				if (currentPiece.colorCode == 1) {
					color = Color.white;
				} else if (currentPiece.colorCode == 2) {
					color = Color.blue;
				} else {
					color = Color.red;
				}
				g.setColor(color);
				g.fillRect(currentPiece.pixelArrX[i], currentPiece.pixelArrY[i], UNIT_SIZE, UNIT_SIZE);
			}
			// draw static pixels
			for (int i = 0; i < staticPixels.size(); i++) {
				//get color
				Color color;
				if (staticPixels.get(i).colorCode == 1) {
					color = Color.white;
				} else if (staticPixels.get(i).colorCode == 2) {
					color = Color.blue;
				} else {
					color = Color.red;
				}
				g.setColor(color);
				g.fillRect(staticPixels.get(i).xCoord, staticPixels.get(i).yCoord - UNIT_SIZE, UNIT_SIZE, UNIT_SIZE);
			}
		} else {
			gameOver(g);
		}
	}
		
	public void moveDown() {
		// ensure piece can move before moving
		boolean ableToMove = true;
		for (int i = 0; i < 4; i++) {	
			for (int j = 0; j < staticPixels.size(); j++)
			if (currentPiece.pixelArrX[i] == staticPixels.get(j).xCoord && currentPiece.pixelArrY[i] + 25 == staticPixels.get(j).yCoord) {
				ableToMove = false;
			} else if (currentPiece.pixelArrY[i] == SCREEN_HEIGHT) {
				ableToMove = false;
			}
		}
		if (ableToMove) {			
			for (int i = 0; i < 4; i++) {	
				currentPiece.pixelArrY[i] = currentPiece.pixelArrY[i] + UNIT_SIZE;
			}
		}
	}
	
	public void moveLeft() {
		// get left most pixel
		int min = SCREEN_WIDTH;
		for (int i = 0; i < currentPiece.pixelArrX.length; i++) {
	        if (currentPiece.pixelArrX[i] < min) {
	            min = currentPiece.pixelArrX[i];
	        }
	    }
		// ensure piece can move before moving
		if (min > 0) {
			for (int i = 0; i < 4; i++) {					
				currentPiece.pixelArrX[i] = currentPiece.pixelArrX[i] - UNIT_SIZE;
			}
		}
	}
	
	public void moveRight() {
		// get right most pixel
		int max = 0;
		for (int i = 0; i < currentPiece.pixelArrX.length; i++) {
	        if (currentPiece.pixelArrX[i] > max) {
	            max = currentPiece.pixelArrX[i];
	        }
	    }
		// ensure piece can move before moving
		if (max < SCREEN_WIDTH - 25) {
			for (int i = 0; i < 4; i++) {					
				currentPiece.pixelArrX[i] = currentPiece.pixelArrX[i] + UNIT_SIZE;
			}
		}
	}
	
	public void checkCollisions(int start) {
		// get lowest pixel
		int maxY = 0;
		for (int i = 0; i < currentPiece.pixelArrY.length; i++) {
	        if (currentPiece.pixelArrY[i] > maxY) {
	            maxY = currentPiece.pixelArrY[i];
	        }
	    }
		// check if pixel hits a static pixel
		for (int i = 0; i < staticPixels.size(); i++) {
			for (int j = 0; j < 4; j++) {				
				if (staticPixels.get(i).xCoord == currentPiece.pixelArrX[j] && staticPixels.get(i).yCoord - 25 == currentPiece.pixelArrY[j]) {
					if (start == 1) {
						System.out.println("static x " + staticPixels.get(i).xCoord);
						System.out.println("static y " + staticPixels.get(i).yCoord);
						System.out.println("current x " + currentPiece.pixelArrX[j]);
						System.out.println("current y " + currentPiece.pixelArrY[j]);
						timer.stop();
						running = false;
						break;
					} else {				
						System.out.println("Pixel");
						setStaticPixels();
						break;
					}
				}
			}
		}
		
		// check if pixel hits the ground
		if (maxY > SCREEN_HEIGHT - 25 && start == 0) {
			if (currentPiece.pixelArrY[1] > 25 && currentPiece.pixelArrY[2] > 25 && currentPiece.pixelArrY[3] > 25 && currentPiece.pixelArrY[0] > 25) {				
				System.out.println("Ground " + maxY);
				setStaticPixels();
			}
		}
	}
	
	public void checkLineClear() {
		HashMap<Integer, Integer> pixelCount = new HashMap<Integer, Integer>();
		ArrayList<Integer> clears = new ArrayList<Integer>();
		
		for (int i = 0; i < staticPixels.size(); i++) {
			if (pixelCount.containsKey(staticPixels.get(i).yCoord)) {
				// increase value of pixelCount entry
				int val = pixelCount.get(staticPixels.get(i).yCoord);
				pixelCount.replace(staticPixels.get(i).yCoord, val + 1);
				if (val == 9) {
					// add line to clear array
					System.out.println("Clear");
					clears.add(staticPixels.get(i).yCoord);
				}
			} else {
				// create new pixelCount entry
				pixelCount.put(staticPixels.get(i).yCoord, 1);
			}
		}
		if (clears.size() > 0) {			
			// pass array of rows to clear line function
			int[] rows = new int[clears.size()];
			for (int i = 0; i < clears.size(); i++) {
				rows[i] = clears.get(i);
			}
			clearLines(rows);
		}
	}
	
	public void clearLines(int[] rows) {
		for (int j = staticPixels.size() - 1; j >= 0; j--) {
			int c = 0;
			for (int i = 0; i < rows.length; i++) {
				// remove lines
				if (staticPixels.get(j).yCoord == rows[i]) {
					System.out.println("Removed: " + staticPixels.get(j).yCoord + ", " + j);
					staticPixels.remove(j);
					c = 0;
					break;
				// increment 'lines to move down' counter
				} else if (staticPixels.get(j).yCoord < rows[i]) {
					c = c + 1;
				} 
			}
			if (c > 0) {					
				// move down a line
				System.out.println("Moved Down: " + staticPixels.get(j).yCoord + ", " + j);
				staticPixels.set(j, new Pixel(staticPixels.get(j).colorCode, staticPixels.get(j).xCoord, staticPixels.get(j).yCoord + (25 * c)));
			}
		}
	}
	
	public void setStaticPixels() {
		if (running) {			
			// add currentPiece pixels to pixel array
			for (int i = 0; i < 4; i++) {
				System.out.println("X " + currentPiece.pixelArrX[i]);
				System.out.println("Y " + currentPiece.pixelArrY[i]);
				Pixel p = new Pixel(currentPiece.colorCode, currentPiece.pixelArrX[i], currentPiece.pixelArrY[i]);
				staticPixels.add(p);
			}
			checkLineClear();
			generateTetromino();
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
				checkCollisions(0);
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
			case KeyEvent.VK_Q:
				currentPiece.rotateLeft();
				break;
			case KeyEvent.VK_E:
				currentPiece.rotateRight();
				break;
			}
		}
		
	}

}
