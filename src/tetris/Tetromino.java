package tetris;

public class Tetromino {
	int type;
	String s;
	
	public Tetromino(int x) {
		type = x;
	}
	
	public void showType() {
		switch (type) {
		case 1:
			s = "I";
			break;
		case 2:
			s = "J";
			break;
		case 3:
			s = "L";
			break;
		case 4:
			s = "O";
			break;
		case 5:
			s = "S";
			break;
		case 6:
			s = "Z";
			break;
		case 7:
			s = "T";
			break;
		}
		System.out.println(s);
	}
}
