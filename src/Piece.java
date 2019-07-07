// Anirudh Prakash

// represents a Battleship Piece
public class Piece {
	public int x; // top left 0 to 7
	public int y; // top left 0 to 7
	public int length; // rows across: [A, A, A]
	public boolean orientation; // false horiz, true vert
	public boolean visible;
	
	public Piece(int x, int y, int length, boolean orientation) {
		this.x = x;
		this.y = y;
		this.length = length;
		this.orientation = orientation;
	}
}
