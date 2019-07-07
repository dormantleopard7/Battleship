// Anirudh Prakash

import java.util.*;

// allows the user to generate a board
public class UserBoardGenerator {
	
	private char[][] board;
	private boolean gameOver;

	//public static void main(String[] args) {
	public UserBoardGenerator() {
		// TODO Auto-generated method stub
		board = new char[8][8];
		Scanner console = new Scanner(System.in);
		for (int i = 0; i < board.length; i++) {
			for (int j = 0; j < board[i].length; j++) {
				board[i][j] = ' ';
			}
		}
		System.out.println("Welcome to Battleship");
		print(board);
		e(console, board);
		print(board);
		d(console, board);
		print(board);
		c(console, board);
		print(board);
		b(console, board);
		print(board);
		a(console, board);
		print(board);
		System.out.println("This is your board.");
		System.out.println();
		gameOver = false;
	}
	
	public boolean gameOver() {
		return gameOver;
	}
	
	public void /*boolean*/ check(int x, int y) {
		if (board[x][y] != ' ') {
			board[x][y] = '#';
			System.out.println("CPU hit User!");
			print(board);
			//return true;
		} else {
			board[x][y] = 'x';
			System.out.println("CPU missed User.");
			print(board);
			//return false;
		}
	}
	
	public void print(char[][] board) {
		System.out.println("--------User Board---------");
		System.out.println("    0  1  2  3  4  5  6  7");
		System.out.println("  -------------------------");
		gameOver = true;
		for (int i = 0; i < board.length; i++) {
			System.out.print(i + " [ " + board[i][0]);
			if (!(board[i][0] == ' ' || board[i][0] == 'x' || board[i][0] == '#')) {
				gameOver = false;
			}
			for (int j = 1; j < board[i].length; j++) {
				System.out.print("| " + board[i][j]);
				if (!(board[i][j] == ' ' || board[i][j] == 'x' || board[i][j] == '#')) {
					gameOver = false;
				}
			}
			System.out.println("]");
			System.out.println("  -------------------------");
		}
		//System.out.println("---------------------------");
	}
	
	public static void e(Scanner console, char[][] board) {
		System.out.println("Choose the orientation of the five-long E piece");
		System.out.print("(v for vertical, h for horizontal): ");
		String orient = console.next();
		boolean orientation = false;
		if (orient.equalsIgnoreCase("v")) {
			orientation = true;
		}
		int x = 0;
		int y = 0;
		if (orientation) { // vertical
			System.out.println("Now choose the top left coordinate as a row (0 through 3)");
			System.out.print("by column (0 through 7) separated by a space: ");
			x = console.nextInt();
			y = console.nextInt();
			//x = random.nextInt(4);
			//y = random.nextInt(8);
		} else {
			System.out.println("Now choose the top left coordinate as a row (0 through 7)");
			System.out.print("by column (0 through 3) separated by a space: ");
			x = console.nextInt();
			y = console.nextInt();
		}
		Piece e = new Piece(x, y, 5, orientation);
		if (e.orientation) {
			for (int i = 0; i < e.length; i++) {
				board[e.x + i][e.y] = 'E';
			}
		} else {
			for (int i = 0; i < e.length; i++) {
				board[e.x][e.y + i] = 'E';
			}
		}
	}
	
	public static void d(Scanner console, char[][] board) {
		System.out.println("Choose the orientation of the four-long D piece");
		System.out.print("(v for vertical, h for horizontal): ");
		String orient = console.next();
		boolean orientation = false;
		if (orient.equalsIgnoreCase("v")) {
			orientation = true;
		}
		int x = 0;
		int y = 0;
		if (orientation) { // vertical
			System.out.println("Now choose the top left coordinate as a row (0 through 4)");
			System.out.print("by column (0 through 7) separated by a space: ");
			x = console.nextInt();
			y = console.nextInt();
			//x = random.nextInt(4);
			//y = random.nextInt(8);
		} else {
			System.out.println("Now choose the top left coordinate as a row (0 through 7)");
			System.out.print("by column (0 through 4) separated by a space: ");
			x = console.nextInt();
			y = console.nextInt();
		}
		Piece d = new Piece(x, y, 4, orientation);
		if (d.orientation) {
			for (int i = 0; i < d.length; i++) {
				if (board[d.x + i][d.y] == ' ') {
					board[d.x + i][d.y] = 'D';
				} else { // reset and call d() again
					for (int j = 0; j < i; j++) {
						board[d.x + j][d.y] = ' ';
					}
					i = d.length;
					System.out.println("Sorry, but that piece overlaps. Try again.");
					d(console, board);
				}
			}
		} else {
			for (int i = 0; i < d.length; i++) {
				if (board[d.x][d.y + i] == ' ') {
					board[d.x][d.y + i] = 'D';
				} else { // reset and call d() again
					for (int j = 0; j < i; j++) {
						board[d.x][d.y + j] = ' ';
					}
					i = d.length;
					System.out.println("Sorry, but that piece overlaps. Try again.");
					d(console, board);
				}
			}
		}
	}
	
	public static void c(Scanner console, char[][] board) {
		System.out.println("Choose the orientation of the three-long C piece");
		System.out.print("(v for vertical, h for horizontal): ");
		String orient = console.next();
		boolean orientation = false;
		if (orient.equalsIgnoreCase("v")) {
			orientation = true;
		}
		int x = 0;
		int y = 0;
		if (orientation) { // vertical
			System.out.println("Now choose the top left coordinate as a row (0 through 5)");
			System.out.print("by column (0 through 7) separated by a space: ");
			x = console.nextInt();
			y = console.nextInt();
			//x = random.nextInt(4);
			//y = random.nextInt(8);
		} else {
			System.out.println("Now choose the top left coordinate as a row (0 through 7)");
			System.out.print("by column (0 through 5) separated by a space: ");
			x = console.nextInt();
			y = console.nextInt();
		}
		Piece d = new Piece(x, y, 3, orientation);
		if (d.orientation) {
			for (int i = 0; i < d.length; i++) {
				if (board[d.x + i][d.y] == ' ') {
					board[d.x + i][d.y] = 'C';
				} else { // reset and call d() again
					for (int j = 0; j < i; j++) {
						board[d.x + j][d.y] = ' ';
					}
					i = d.length;
					System.out.println("Sorry, but that piece overlaps. Try again.");
					c(console, board);
				}
			}
		} else {
			for (int i = 0; i < d.length; i++) {
				if (board[d.x][d.y + i] == ' ') {
					board[d.x][d.y + i] = 'C';
				} else { // reset and call d() again
					for (int j = 0; j < i; j++) {
						board[d.x][d.y + j] = ' ';
					}
					i = d.length;
					System.out.println("Sorry, but that piece overlaps. Try again.");
					c(console, board);
				}
			}
		}
	}
	
	public static void b(Scanner console, char[][] board) {
		System.out.println("Choose the orientation of the three-long B piece");
		System.out.print("(v for vertical, h for horizontal): ");
		String orient = console.next();
		boolean orientation = false;
		if (orient.equalsIgnoreCase("v")) {
			orientation = true;
		}
		int x = 0;
		int y = 0;
		if (orientation) { // vertical
			System.out.println("Now choose the top left coordinate as a row (0 through 5)");
			System.out.print("by column (0 through 7) separated by a space: ");
			x = console.nextInt();
			y = console.nextInt();
			//x = random.nextInt(4);
			//y = random.nextInt(8);
		} else {
			System.out.println("Now choose the top left coordinate as a row (0 through 7)");
			System.out.print("by column (0 through 5) separated by a space: ");
			x = console.nextInt();
			y = console.nextInt();
		}
		Piece d = new Piece(x, y, 3, orientation);
		if (d.orientation) {
			for (int i = 0; i < d.length; i++) {
				if (board[d.x + i][d.y] == ' ') {
					board[d.x + i][d.y] = 'B';
				} else { // reset and call d() again
					for (int j = 0; j < i; j++) {
						board[d.x + j][d.y] = ' ';
					}
					i = d.length;
					System.out.println("Sorry, but that piece overlaps. Try again.");
					b(console, board);
				}
			}
		} else {
			for (int i = 0; i < d.length; i++) {
				if (board[d.x][d.y + i] == ' ') {
					board[d.x][d.y + i] = 'B';
				} else { // reset and call d() again
					for (int j = 0; j < i; j++) {
						board[d.x][d.y + j] = ' ';
					}
					i = d.length;
					System.out.println("Sorry, but that piece overlaps. Try again.");
					b(console, board);
				}
			}
		}
	}
	
	public static void a(Scanner console, char[][] board) {
		System.out.println("Choose the orientation of the two-long A piece");
		System.out.print("(v for vertical, h for horizontal): ");
		String orient = console.next();
		boolean orientation = false;
		if (orient.equalsIgnoreCase("v")) {
			orientation = true;
		}
		int x = 0;
		int y = 0;
		if (orientation) { // vertical
			System.out.println("Now choose the top left coordinate as a row (0 through 6)");
			System.out.print("by column (0 through 7) separated by a space: ");
			x = console.nextInt();
			y = console.nextInt();
			//x = random.nextInt(4);
			//y = random.nextInt(8);
		} else {
			System.out.println("Now choose the top left coordinate as a row (0 through 7)");
			System.out.print("by column (0 through 6) separated by a space: ");
			x = console.nextInt();
			y = console.nextInt();
		}
		Piece d = new Piece(x, y, 2, orientation);
		if (d.orientation) {
			for (int i = 0; i < d.length; i++) {
				if (board[d.x + i][d.y] == ' ') {
					board[d.x + i][d.y] = 'A';
				} else { // reset and call d() again
					for (int j = 0; j < i; j++) {
						board[d.x + j][d.y] = ' ';
					}
					i = d.length;
					System.out.println("Sorry, but that piece overlaps. Try again.");
					a(console, board);
				}
			}
		} else {
			for (int i = 0; i < d.length; i++) {
				if (board[d.x][d.y + i] == ' ') {
					board[d.x][d.y + i] = 'A';
				} else { // reset and call d() again
					for (int j = 0; j < i; j++) {
						board[d.x][d.y + j] = ' ';
					}
					i = d.length;
					System.out.println("Sorry, but that piece overlaps. Try again.");
					a(console, board);
				}
			}
		}
	}
}
