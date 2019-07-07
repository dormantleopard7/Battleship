// Anirudh Prakash

import java.util.*;

// randomly generates board and plays against user
public class RandomBoardGenerator {
	
	private List<Integer[]> allPairs;
	private Random random;
	private char[][] board;
	private char[][] gameBoard;
	private Piece a;
	private Piece b;
	private Piece c;
	private Piece d;
	private Piece e;
	private boolean gameOver;
	private Scanner console;

	public RandomBoardGenerator() {
		random = new Random();
		board = new char[8][8];
		for (int i = 0; i < board.length; i++) {
			for (int j = 0; j < board[i].length; j++) {
				board[i][j] = ' ';
			}
		}
		e(random, board);
		d(random, board);
		c(random, board);
		b(random, board);
		a(random, board);
		//print(board);
		gameBoard = new char[8][8];
		for (int i = 0; i < gameBoard.length; i++) {
			for (int j = 0; j < gameBoard[i].length; j++) {
				gameBoard[i][j] = ' ';
			}
		}
		//printGame();
		allPairs = new ArrayList<Integer[]>();
		for (int i = 0; i < board.length; i++) {
			for (int j = 0; j < board[i].length; j++) {
				Integer[] pair = {i, j}; // i row, j column
				allPairs.add(pair);
			}
		}
		gameOver = false;
		console = new Scanner(System.in);
	}
	
	public char[][] board() {
		if (gameOver) {
			return board;
		}
		return null;
	}
	
	public char[][] gameBoard() {
		return gameBoard;
	}
	
	public boolean gameOver() {
		return gameOver;
	}
	
	/*public static void print(char[][] board) {
		for (int i = 0; i < board.length; i++) {
			System.out.print("[" + board[i][0]);
			for (int j = 1; j < board[i].length; j++) {
				System.out.print(", " + board[i][j]);
			}
			System.out.println("]");
		}
	}*/
	
	public int[] guess() {
		int num = random.nextInt(allPairs.size());
		Integer[] pair = allPairs.remove(num);
		int x = pair[0]; // row
		int y = pair[1]; // column
		int[] par = {x, y};
		return par;
	}
	
	public void /*boolean*/ check(int x, int y) {
		if (x > 7 || y > 7) {
			gameOver = true;
			//return false;
		}
		if (gameBoard[x][y] != ' ') {
			System.out.println("You have already fired there. Try again.");
			System.out.print("Choose where to fire (row column): ");
			int x2 = console.nextInt();
			int y2 = console.nextInt();
			this.check(x2, y2);
		} else {
			if (board[x][y] != ' ') {
				gameBoard[x][y] = '#';
				System.out.println("User hit CPU!");
				printGame();
				//return true;
			} else {
				gameBoard[x][y] = 'x';
				System.out.println("User missed CPU.");
				printGame();
				//return false;
			}
		}
	}
	
	public void print(char[][] board) {
		System.out.println("---------CPU Board---------");
		System.out.println("    0  1  2  3  4  5  6  7");
		System.out.println("  -------------------------");
		for (int i = 0; i < board.length; i++) {
			System.out.print(i + " [ " + board[i][0]);
			for (int j = 1; j < board[i].length; j++) {
				System.out.print("| " + board[i][j]);
			}
			System.out.println("]");
			System.out.println("  -------------------------");
		}
		//System.out.println("---------------------------");
	}
	
	public void printGame() {
		//print(board);
		// x row, y col, length, orientation (f horiz, t vert), visible
		Piece[] pieces = {a, b, c, d, e};
		for (Piece p : pieces) {
			if (!p.visible) {
				if (p.orientation) { // vertical
					// check if all
					// if all, change to a and to visible
					boolean all = true;
					for (int i = p.x; i < p.x + p.length; i++) {
						if (gameBoard[i][p.y] != '#') {
							all = false;
						}
					}
					if (all) {
						for (int i = p.x; i < p.x + p.length; i++) {
							gameBoard[i][p.y] = board[i][p.y];
							p.visible = true;
						}
					}
				} else { // horizontal
					boolean all = true;
					for (int i = p.y; i < p.y + p.length; i++) {
						if (gameBoard[p.x][i] != '#') {
							all = false;
						}
					}
					if (all) {
						for (int i = p.y; i < p.y + p.length; i++) {
							gameBoard[p.x][i] = board[p.x][i];
							p.visible = true;
						}
					}
				}
			}
		}
		gameOver = true;
		for (Piece p : pieces) {
			if (!p.visible) {
				gameOver = false;
			}
		}
		print(gameBoard);
		/*if (!a.visible) {
			if (a.orientation) { // vertical
				// check if all
				// if all, change to a and to visible
				boolean all = true;
				for (int i = a.x; i < a.x + a.length; i++) {
					if (gameBoard[i][a.y] != '#') {
						all = false;
					}
				}
				if (all) {
					for (int i = a.x; i < a.x + a.length; i++) {
						gameBoard[i][a.y] = board[i][a.y];
						a.visible = true;
					}
				}
			} else { // horizontal
				boolean all = true;
				for (int i = a.y; i < a.y + a.length; i++) {
					if (gameBoard[i][a.x] != '#') {
						all = false;
					}
				}
				if (all) {
					for (int i = a.y; i < a.y + a.length; i++) {
						gameBoard[i][a.x] = board[i][a.x];
						a.visible = true;
					}
				}
			}
		}
		if (!b.visible) {
			if (b.orientation) { // vertical
				// check if all
				// if all, change to a and to visible
				boolean all = true;
				for (int i = b.x; i < b.x + b.length; i++) {
					if (gameBoard[i][b.y] != '#') {
						all = false;
					}
				}
				if (all) {
					for (int i = b.x; i < b.x + b.length; i++) {
						gameBoard[i][b.y] = board[i][b.y];
						b.visible = true;
					}
				}
			} else { // horizontal
				boolean all = true;
				for (int i = b.y; i < b.y + b.length; i++) {
					if (gameBoard[i][b.x] != '#') {
						all = false;
					}
				}
				if (all) {
					for (int i = b.y; i < b.y + b.length; i++) {
						gameBoard[i][b.x] = board[i][b.x];
						b.visible = true;
					}
				}
			}
		}*/
	}
	
	public void e(Random random, char[][] board) {
		boolean orientation = random.nextBoolean();
		int x = 0;
		int y = 0;
		if (orientation) { // vertical
			x = random.nextInt(4);
			y = random.nextInt(8);
		} else {
			x = random.nextInt(8);
			y = random.nextInt(4);
		}
		e = new Piece(x, y, 5, orientation);
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
	
	public void d(Random random, char[][] board) {
		boolean orientation = random.nextBoolean();
		int x = 0;
		int y = 0;
		if (orientation) { // vertical
			x = random.nextInt(5);
			y = random.nextInt(8);
		} else {
			x = random.nextInt(8);
			y = random.nextInt(5);
		}
		d = new Piece(x, y, 4, orientation);
		if (d.orientation) {
			for (int i = 0; i < d.length; i++) {
				if (board[d.x + i][d.y] == ' ') {
					board[d.x + i][d.y] = 'D';
				} else { // reset and call d() again
					for (int j = 0; j < i; j++) {
						board[d.x + j][d.y] = ' ';
					}
					i = d.length;
					d(random, board);
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
					d(random, board);
				}
			}
		}
	}
	
	public void c(Random random, char[][] board) {
		boolean orientation = random.nextBoolean();
		int x = 0;
		int y = 0;
		if (orientation) { // vertical
			x = random.nextInt(6);
			y = random.nextInt(8);
		} else {
			x = random.nextInt(8);
			y = random.nextInt(6);
		}
		c = new Piece(x, y, 3, orientation);
		if (c.orientation) {
			for (int i = 0; i < c.length; i++) {
				if (board[c.x + i][c.y] == ' ') {
					board[c.x + i][c.y] = 'C';
				} else { // reset and call c() again
					for (int j = 0; j < i; j++) {
						board[c.x + j][c.y] = ' ';
					}
					i = c.length;
					c(random, board);
				}
			}
		} else {
			for (int i = 0; i < c.length; i++) {
				if (board[c.x][c.y + i] == ' ') {
					board[c.x][c.y + i] = 'C';
				} else { // reset and call c() again
					for (int j = 0; j < i; j++) {
						board[c.x][c.y + j] = ' ';
					}
					i = c.length;
					c(random, board);
				}
			}
		}
	}
	
	public void b(Random random, char[][] board) {
		boolean orientation = random.nextBoolean();
		int x = 0;
		int y = 0;
		if (orientation) { // vertical
			x = random.nextInt(6);
			y = random.nextInt(8);
		} else {
			x = random.nextInt(8);
			y = random.nextInt(6);
		}
		b = new Piece(x, y, 3, orientation);
		if (b.orientation) {
			for (int i = 0; i < b.length; i++) {
				if (board[b.x + i][b.y] == ' ') {
					board[b.x + i][b.y] = 'B';
				} else { // reset and call b() again
					for (int j = 0; j < i; j++) {
						board[b.x + j][b.y] = ' ';
					}
					i = b.length;
					b(random, board);
				}
			}
		} else {
			for (int i = 0; i < b.length; i++) {
				if (board[b.x][b.y + i] == ' ') {
					board[b.x][b.y + i] = 'B';
				} else { // reset and call b() again
					for (int j = 0; j < i; j++) {
						board[b.x][b.y + j] = ' ';
					}
					i = b.length;
					b(random, board);
				}
			}
		}
	}
	
	public void a(Random random, char[][] board) {
		boolean orientation = random.nextBoolean();
		int x = 0;
		int y = 0;
		if (orientation) { // vertical
			x = random.nextInt(7);
			y = random.nextInt(8);
		} else {
			x = random.nextInt(8);
			y = random.nextInt(7);
		}
		a = new Piece(x, y, 2, orientation);
		if (a.orientation) {
			for (int i = 0; i < a.length; i++) {
				if (board[a.x + i][a.y] == ' ') {
					board[a.x + i][a.y] = 'A';
				} else { // reset and call a() again
					for (int j = 0; j < i; j++) {
						board[a.x + j][a.y] = ' ';
					}
					i = a.length;
					a(random, board);
				}
			}
		} else {
			for (int i = 0; i < a.length; i++) {
				if (board[a.x][a.y + i] == ' ') {
					board[a.x][a.y + i] = 'A';
				} else { // reset and call a() again
					for (int j = 0; j < i; j++) {
						board[a.x][a.y + j] = ' ';
					}
					i = a.length;
					a(random, board);
				}
			}
		}
	}

}
