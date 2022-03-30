package aflevering4;
import java.util.*;

public class GameOfLifeMain {
	public static void main(String[] args) {
		//random debugging
		GameOfLife randgame = new GameOfLife(6);
		randgame.printGameState();
		System.out.print("\n");
		randgame.printNeighbours();
		//randgame.initState();
		System.out.println("Skrt");
		randgame.drawState();
		
		
		
		//filled array debugging
		System.out.println("\n");
		
		int[][] arr = new int[6][6];
		for (int[] row:arr)
			Arrays.fill(row,1);
		GameOfLife filledGame = new GameOfLife(arr);
		filledGame.printGameState();
		//filledGame.printNeighbours();
		filledGame.nextState();
		filledGame.printGameState();
		filledGame.nextState();
		filledGame.printGameState();
		System.out.println("HVAD FANDEN");
		
	
	}
	
}
