package tetris;

public class Tetromino {
	static final int UNIT_SIZE = 25;
	int id;
	int position = 1;
	int colorCode;
	String name;
	int[] pixelArrX = new int[4];
	int[] pixelArrY = new int[4];
	
	public void rotateLeft() {
		switch (id) {
		case 1:
			// set x pixel coordinate
			pixelArrX[1] = pixelArrX[1] + UNIT_SIZE;
			pixelArrX[2] = pixelArrX[2] - UNIT_SIZE;
			pixelArrX[3] = pixelArrX[3] - UNIT_SIZE;
			// set y pixel coordinate
			pixelArrY[1] = pixelArrY[1] - UNIT_SIZE;
			pixelArrY[2] = pixelArrY[2] + UNIT_SIZE;
			pixelArrY[3] = pixelArrY[3] - UNIT_SIZE;
			break;
		case 2:
			// set x pixel coordinate
			pixelArrX[1] = pixelArrX[1] + UNIT_SIZE;
			pixelArrX[2] = pixelArrX[2] - UNIT_SIZE;
			// set y pixel coordinate
			pixelArrY[1] = pixelArrY[1] + UNIT_SIZE;
			pixelArrY[2] = pixelArrY[2] - UNIT_SIZE;
			pixelArrY[3] = pixelArrY[3] - (UNIT_SIZE * 2);
			break;
		case 3:
			// set x pixel coordinate
			pixelArrX[1] = pixelArrX[1] + UNIT_SIZE;
			pixelArrX[2] = pixelArrX[2] + UNIT_SIZE;
			// set y pixel coordinate
			pixelArrY[1] = pixelArrY[1] + UNIT_SIZE;
			pixelArrY[2] = pixelArrY[2] - UNIT_SIZE;
			pixelArrY[3] = pixelArrY[3]- (UNIT_SIZE * 2);
			break;
		case 4:
			break;
		case 5:
			// set x pixel coordinate
			pixelArrX[1] = pixelArrX[1] - UNIT_SIZE;
			pixelArrX[2] = pixelArrX[2] + UNIT_SIZE;
			pixelArrX[3] = pixelArrX[3] + (UNIT_SIZE * 2);
			// set y pixel coordinate
			pixelArrY[1] = pixelArrY[1] - UNIT_SIZE;
			pixelArrY[2] = pixelArrY[2] - UNIT_SIZE;
			break;
		case 6:
			// set x pixel coordinate
			pixelArrX[1] = pixelArrX[1] + UNIT_SIZE;
			pixelArrX[2] = pixelArrX[2] - UNIT_SIZE;
			pixelArrX[3] = pixelArrX[3] + (UNIT_SIZE * 2);
			// set y pixel coordinate
			pixelArrY[1] = pixelArrY[1] + UNIT_SIZE;
			pixelArrY[2] = pixelArrY[2] - UNIT_SIZE;
			break;
		case 7:
			// set x pixel coordinate
			pixelArrX[0] = pixelArrX[0] + UNIT_SIZE ;
			pixelArrX[1] = pixelArrX[1] + (UNIT_SIZE * 2);
			pixelArrX[3] = pixelArrX[3] - UNIT_SIZE;
			// set y pixel coordinate
			pixelArrY[0] = pixelArrY[0] - UNIT_SIZE;
			pixelArrY[1] = pixelArrY[1] - (UNIT_SIZE * 2);
			pixelArrY[3] = pixelArrY[3] + UNIT_SIZE;
			break;
		}
	}
	
	public void rotateRight() {
		
	}
	
	public Tetromino(int x) {
		pixelArrX[0] = 0 * UNIT_SIZE + (UNIT_SIZE * 4);
		pixelArrY[0] = 0 * UNIT_SIZE;
		id = x;
		switch (id) {
		case 1:
			name = "T";
			colorCode = 1;
			// set x pixel coordinate
			pixelArrX[1] = -1 * UNIT_SIZE + (UNIT_SIZE * 4);
			pixelArrX[2] = 1 * UNIT_SIZE + (UNIT_SIZE * 4);
			pixelArrX[3] = 0 * UNIT_SIZE + (UNIT_SIZE * 4);
			// set y pixel coordinate
			pixelArrY[1] = 0 * UNIT_SIZE;
			pixelArrY[2] = 0 * UNIT_SIZE;
			pixelArrY[3] = 1 * UNIT_SIZE;
			break;
		case 2:
			name = "J";
			colorCode = 2;
			// set x pixel coordinate
			pixelArrX[1] = -1 * UNIT_SIZE + (UNIT_SIZE * 4);
			pixelArrX[2] = 1 * UNIT_SIZE + (UNIT_SIZE * 4);
			pixelArrX[3] = 1 * UNIT_SIZE + (UNIT_SIZE * 4);
			// set y pixel coordinate
			pixelArrY[1] = 0 * UNIT_SIZE;
			pixelArrY[2] = 0 * UNIT_SIZE;
			pixelArrY[3] = 1 * UNIT_SIZE;
			break;
		case 3:
			name = "Z";
			colorCode = 3;
			// set x pixel coordinate
			pixelArrX[1] = -1 * UNIT_SIZE + (UNIT_SIZE * 4);
			pixelArrX[2] = 0 * UNIT_SIZE + (UNIT_SIZE * 4);
			pixelArrX[3] = 1 * UNIT_SIZE + (UNIT_SIZE * 4);
			// set y pixel coordinate
			pixelArrY[1] = 0 * UNIT_SIZE;
			pixelArrY[2] = 1 * UNIT_SIZE;
			pixelArrY[3] = 1 * UNIT_SIZE;
			break;
		case 4:
			name = "O";
			colorCode = 1;
			// set x pixel coordinate
			pixelArrX[1] = 1 * UNIT_SIZE + (UNIT_SIZE * 4);
			pixelArrX[2] = 1 * UNIT_SIZE + (UNIT_SIZE * 4);
			pixelArrX[3] = 0 * UNIT_SIZE + (UNIT_SIZE * 4);
			// set y pixel coordinate
			pixelArrY[1] = 0 * UNIT_SIZE;
			pixelArrY[2] = 1 * UNIT_SIZE;
			pixelArrY[3] = 1 * UNIT_SIZE;
			break;
		case 5:
			name = "S";
			colorCode = 2;
			// set x pixel coordinate
			pixelArrX[1] = 1 * UNIT_SIZE + (UNIT_SIZE * 4);
			pixelArrX[2] = 0 * UNIT_SIZE + (UNIT_SIZE * 4);
			pixelArrX[3] = -1 * UNIT_SIZE + (UNIT_SIZE * 4);
			// set y pixel coordinate
			pixelArrY[1] = 0 * UNIT_SIZE;
			pixelArrY[2] = 1 * UNIT_SIZE;
			pixelArrY[3] = 1 * UNIT_SIZE;
			break;
		case 6:
			name = "L";
			colorCode = 3;
			// set x pixel coordinate
			pixelArrX[1] = -1 * UNIT_SIZE + (UNIT_SIZE * 4);
			pixelArrX[2] = 1 * UNIT_SIZE + (UNIT_SIZE * 4);
			pixelArrX[3] = -1 * UNIT_SIZE + (UNIT_SIZE * 4);
			// set y pixel coordinate
			pixelArrY[1] = 0 * UNIT_SIZE;
			pixelArrY[2] = 0 * UNIT_SIZE;
			pixelArrY[3] = 1 * UNIT_SIZE;
			break;
		case 7:
			name = "I";
			colorCode = 1;
			// set x pixel coordinate
			pixelArrX[1] = -1 * UNIT_SIZE + (UNIT_SIZE * 4);
			pixelArrX[2] = 1 * UNIT_SIZE + (UNIT_SIZE * 4);
			pixelArrX[3] = 2 * UNIT_SIZE + (UNIT_SIZE * 4);
			// set y pixel coordinate
			pixelArrY[1] = 0 * UNIT_SIZE;
			pixelArrY[2] = 0 * UNIT_SIZE;
			pixelArrY[3] = 0 * UNIT_SIZE;
			break;
		}
	}
}
