package tetris;

public class Tetromino {
	static final int UNIT_SIZE = 25;
	int id;
	int colorCode;
	String name;
	int[] pixelArrX = new int[4];
	int[] pixelArrY = new int[4];
	int[] currentCoordX = new int[4];
	int[] currentCoordY = new int[4];
	
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
