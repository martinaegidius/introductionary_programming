package aflevering3;

import java.util.*;

public class RandomWalk {
	public static void main(String[] args) {
		int input = numberScanner();
		if(input==-1) {
			System.out.println("Program exited succesfully.");
		}
		else {
			RandomWalk(input);
		}
	}
	
	
	public static void RandomWalk(int size) {
		Random rand = new Random();
		int positionX = 0;
		int positionY = 0;
		int distance = 0;
		printPosition(positionX,positionY);
		initializeGraph(size);
		int eastCounter = 0;
		int westCounter = 0;
		int northCounter = 0;
		int southCounter = 0;
		while(positionX<size+1 && positionX>-size-1 && positionY<size+1 && positionY>-size-1) {
			int direction = rand.nextInt(4);
			System.out.println(direction);
			if (direction==0){ //case: east
				positionX++;
				eastCounter++;
			}
			else if (direction==1) { //case west
				positionX--;
				westCounter++;
			}
			else if (direction==2) {//case north
				positionY++;
				northCounter++;
			}
			else if (direction==3) { //case south
				positionY--;
				southCounter++;
			}
			distance++;
			printPosition(positionX,positionY);
			positionPrint(positionX,positionY);
			
		}
		System.out.println("Total number of steps = "+distance);
		System.out.println("Total number north = " + northCounter);
		System.out.println("Total number south = " + southCounter);
		System.out.println("Total number west = " + westCounter);
		System.out.println("Total number east = " + eastCounter);
		
		
		
	}
	
	public static void positionPrint(int x, int y) {
		StdDraw.point(x,y);
	}
	
	public static void initializeGraph(int gridsize) {
		StdDraw.setXscale(-gridsize,gridsize);
		StdDraw.setYscale(-gridsize,gridsize);
		StdDraw.setPenRadius(10.0/1000);//2.0/1000);
	}
	
	public static void printPosition(int x, int y) {
		System.out.println("Position = ("+x+","+y+")");
	}
	
	public static int numberScanner() {
		Scanner console = new Scanner(System.in);
		System.out.println("Enter size of grid: ");
		if (console.hasNextInt()) {
			int input = console.nextInt();
			if(input<0) {
				System.out.println("Negative integer. Grid is made using the positive corresponding integer.");
				console.close();
				return -input;
			}
			console.close();
			if(input==0) {
				return -1;
			}
			return input;
		}
		else if (console.hasNextDouble()) {
			System.out.println("Double value found. Please enter an integer value");
			int input = numberScanner();
			return input;
		}
		else {
			System.out.println("Error - input was not integer. Please try entering an integer value (0 to terminate): ");
			int input = numberScanner();
			return input;
		}	
	}
}
