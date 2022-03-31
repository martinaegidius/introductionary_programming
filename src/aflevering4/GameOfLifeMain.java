package aflevering4;
import java.util.*;
import java.io.*;

/* Client example-instance of how to use the GameOfLife-class. 
 * Number of epochs is up to client. The possibility to add stop when gamestate becomes cyclic is encouraged.
 * The client-code has three sections, each corresponding to initializing instances with the three constructor-types of the GameOfLife-class.
 * Added debugging-methods in the class are illustrated in the first example.
 * 
 * Developed by Oliver Zacho and Martin Maximilian Ægidius, 2022, Danmarks Tekniske Universitet
 */

public class GameOfLifeMain {
	public static void main(String[] args) throws FileNotFoundException{
		int size = 500;
		GameOfLife randgame = new GameOfLife(size);
		randgame.printGameState(); //prints the initialized gamestate to the console (mainly for debugging-purposes)
		System.out.println(); 
		randgame.printNeighbours(); //print the corresponding neighbours to each cell (mainly for debugging-purposes)
		randgame.initState(); //initializes the canvas on which the game is drawn
		int epochs = 100; //number of simulation epochs
		for(int i=0;i<epochs;i++) {
			randgame.drawState(15); //Draw the current state. White indicates alive cell, black dead cell. Value indicates speed of frame in ms. 
			randgame.nextState(); //Get next state of the game as a function of the current state. !This overwrites the current game-state!
		}
		
		/*Show-casing how to load a game from an existing array*/
		int[][] arr = new int[100][100]; //create array
		for (int[] row:arr)
			Arrays.fill(row,0); //fill array with 0's
		for(int i=1;i<100;i++) { //add some life
			arr[i][i]=1;
			arr[i][i-1]=1;
		}
		GameOfLife filledGame = new GameOfLife(arr); //construct instance from array
		epochs = 100; //number of simulation epochs
		filledGame.initState();
		for(int i=0;i<epochs;i++) {
			filledGame.drawState(25); 
			filledGame.nextState(); 
		}
		
		//Show-casing how to load a game from a template-file which only contains 0 and 1's. 
		GameOfLife template = new GameOfLife("src/aflevering4/gol/pulsar.gol",false); //add game-template (binary array, white-space delimited), and add padding=true/false.
		template.initState();
		epochs = 100;
		for(int i=0;i<epochs;i++) {
			template.drawState(60);
			template.nextState();
		}
		
	}
	
}
