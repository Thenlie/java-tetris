package tetris;

public class Tetromino {
	int id;
	String name;
	int[] pixelArrX = new int[4];
	int[] pixelArrY = new int[4];
	
	public Tetromino(int x) {
		id = x;
		switch (id) {
		case 1:
			name = "T";
			// set x pixel coordinate
			pixelArrX[0] = 0;
			pixelArrX[1] = -1;
			pixelArrX[2] = 1;
			pixelArrX[3] = 0;
			// set y pixel coordinate
			pixelArrY[0] = 0;
			pixelArrY[1] = 0;
			pixelArrY[2] = 0;
			pixelArrY[3] = 1;
			break;
		case 2:
			name = "J";
			// set x pixel coordinate
			pixelArrX[0] = 0;
			pixelArrX[1] = 0;
			pixelArrX[2] = 0;
			pixelArrX[3] = -1;
			// set y pixel coordinate
			pixelArrY[0] = 0;
			pixelArrY[1] = 1;
			pixelArrY[2] = 2;
			pixelArrY[3] = 2;
			break;
		case 3:
			name = "Z";
			// set x pixel coordinate
			pixelArrX[0] = 0;
			pixelArrX[1] = 1;
			pixelArrX[2] = 1;
			pixelArrX[3] = 2;
			// set y pixel coordinate
			pixelArrY[0] = 0;
			pixelArrY[1] = 0;
			pixelArrY[2] = 1;
			pixelArrY[3] = 1;
			break;
		case 4:
			name = "O";
			// set x pixel coordinate
			pixelArrX[0] = 0;
			pixelArrX[1] = 1;
			pixelArrX[2] = 1;
			pixelArrX[3] = 0;
			// set y pixel coordinate
			pixelArrY[0] = 0;
			pixelArrY[1] = 0;
			pixelArrY[2] = 1;
			pixelArrY[3] = 1;
			break;
		case 5:
			name = "S";
			// set x pixel coordinate
			pixelArrX[0] = 0;
			pixelArrX[1] = -1;
			pixelArrX[2] = -1;
			pixelArrX[3] = -2;
			// set y pixel coordinate
			pixelArrY[0] = 0;
			pixelArrY[1] = 0;
			pixelArrY[2] = 1;
			pixelArrY[3] = 1;
			break;
		case 6:
			name = "L";
			// set x pixel coordinate
			pixelArrX[0] = 0;
			pixelArrX[1] = 0;
			pixelArrX[2] = 0;
			pixelArrX[3] = 1;
			// set y pixel coordinate
			pixelArrY[0] = 0;
			pixelArrY[1] = 1;
			pixelArrY[2] = 2;
			pixelArrY[3] = 2;
			break;
		case 7:
			name = "I";
			// set x pixel coordinate
			pixelArrX[0] = 0;
			pixelArrX[1] = -1;
			pixelArrX[2] = 1;
			pixelArrX[3] = 2;
			// set y pixel coordinate
			pixelArrY[0] = 0;
			pixelArrY[1] = 0;
			pixelArrY[2] = 0;
			pixelArrY[3] = 0;
			break;
		}
	}
}
