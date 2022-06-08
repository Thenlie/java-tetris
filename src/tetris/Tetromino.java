package tetris;

public class Tetromino {
	int id;
	int colorCode;
	String name;
	int[] pixelArrX = new int[4];
	int[] pixelArrY = new int[4];
	int[] currentCoordX = new int[4];
	int[] currentCoordY = new int[4];
	
	public Tetromino(int x) {
		pixelArrX[0] = 0;
		pixelArrY[0] = 0;
		id = x;
		switch (id) {
		case 1:
			name = "T";
			colorCode = 1;
			// set x pixel coordinate
			pixelArrX[1] = -1;
			pixelArrX[2] = 1;
			pixelArrX[3] = 0;
			// set y pixel coordinate
			pixelArrY[1] = 0;
			pixelArrY[2] = 0;
			pixelArrY[3] = 1;
			break;
		case 2:
			name = "J";
			colorCode = 2;
			// set x pixel coordinate
			pixelArrX[1] = -1;
			pixelArrX[2] = 1;
			pixelArrX[3] = 1;
			// set y pixel coordinate
			pixelArrY[1] = 0;
			pixelArrY[2] = 0;
			pixelArrY[3] = 1;
			break;
		case 3:
			name = "Z";
			colorCode = 3;
			// set x pixel coordinate
			pixelArrX[1] = -1;
			pixelArrX[2] = 0;
			pixelArrX[3] = 1;
			// set y pixel coordinate
			pixelArrY[1] = 0;
			pixelArrY[2] = 1;
			pixelArrY[3] = 1;
			break;
		case 4:
			name = "O";
			colorCode = 1;
			// set x pixel coordinate
			pixelArrX[1] = 1;
			pixelArrX[2] = 1;
			pixelArrX[3] = 0;
			// set y pixel coordinate
			pixelArrY[1] = 0;
			pixelArrY[2] = 1;
			pixelArrY[3] = 1;
			break;
		case 5:
			name = "S";
			colorCode = 2;
			// set x pixel coordinate
			pixelArrX[1] = 1;
			pixelArrX[2] = 0;
			pixelArrX[3] = -1;
			// set y pixel coordinate
			pixelArrY[1] = 0;
			pixelArrY[2] = 1;
			pixelArrY[3] = 1;
			break;
		case 6:
			name = "L";
			colorCode = 3;
			// set x pixel coordinate
			pixelArrX[1] = -1;
			pixelArrX[2] = 1;
			pixelArrX[3] = -1;
			// set y pixel coordinate
			pixelArrY[1] = 0;
			pixelArrY[2] = 0;
			pixelArrY[3] = 1;
			break;
		case 7:
			name = "I";
			colorCode = 1;
			// set x pixel coordinate
			pixelArrX[1] = -1;
			pixelArrX[2] = 1;
			pixelArrX[3] = 2;
			// set y pixel coordinate
			pixelArrY[1] = 0;
			pixelArrY[2] = 0;
			pixelArrY[3] = 0;
			break;
		}
	}
}
