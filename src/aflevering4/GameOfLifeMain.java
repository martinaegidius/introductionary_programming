package aflevering4;
import java.util.*;

public class GameOfLifeMain {
	public static void main(String[] args) {
		//random debugging
		GameOfLife randgame = new GameOfLife(100);
		randgame.printGameState();
		System.out.print("\n");
		randgame.printNeighbours();
		randgame.initState();
		int epochs = 500;
		for(int i=0;i<epochs;i++) {
			randgame.drawState();
			randgame.nextState(i);
			if(randgame.isCycle()==true) {
				System.out.println("Cyclicity emerged at +"+i+" epochs!");
			};
		}
		
		
		
		
		//filled array debugging
		System.out.println("\n");
		
		int[][] arr = new int[6][6];
		for (int[] row:arr)
			Arrays.fill(row,1);
		GameOfLife filledGame = new GameOfLife(arr);
		filledGame.printGameState();
		//filledGame.printNeighbours();
		//filledGame.nextState();
		filledGame.printGameState();
		//filledGame.nextState();
		filledGame.printGameState();
		System.out.println("HVAD FANDEN");
		
	
	}
	
}
