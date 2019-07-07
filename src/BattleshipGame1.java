// Anirudh Prakash

import java.util.*;

// plays game between user and computer (which simply randomly chooses where to shoot)
public class BattleshipGame1 {

	public static void main(String[] args) {
		
		RandomBoardGenerator cpu = new RandomBoardGenerator();
		UserBoardGenerator user = new UserBoardGenerator();
		
		// ask user to place pieces and print board
		// build computer board and print a blank version (next to user board)
		// bot fires at user ships 1 time (misses are x and hits are #)
		// user fires at bot ships 1 time
		// continues... fully hit bot ships are revealed
			// if all squares of bot ship hit		
		// game ends when all ships of one side destroyed
		
		/* don't allow fire on same spot twice*/
		
		Scanner console = new Scanner(System.in);
		//int y = -1;
		//boolean done = false;
		//cpu.printGame();
		while(!cpu.gameOver() && !user.gameOver()) {
			System.out.print("Choose where to fire (row column): ");
			int x = console.nextInt();
			int y = console.nextInt();
			cpu.check(x, y);
			//cpu.print(cpu.board());
			if (cpu.gameOver()) {
				break;
			}
			int[] guess = cpu.guess();
			int cx = guess[0];
			int cy = guess[1];
			System.out.println("CPU fired at: " + cx + " " + cy);
			user.check(cx, cy);
		}
		//cpu.print(cpu.board());
		System.out.println("GAME OVER.");
		if (cpu.gameOver()) {
			System.out.println("Congrats! You Win!"); // win
		} else {
			System.out.println("Sorry, you lost."); // quit or lose (need to test this)
		}
		console.close();
	}

}
