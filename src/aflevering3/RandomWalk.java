package aflevering3;

import java.util.*;

public class RandomWalk {
	public static void main(String[] args) {
		int input = numberScanner();
		RandomWalk(input);
	}
	
	
	public static void RandomWalk(int size) {
		Random rand = new Random();
		int positionX = 0;
		int positionY = 0;
		int distance = 0;
		printPosition(positionX,positionY);
		initializeGraph(size);
		while(positionX<size+1 && positionX>-size-1 && positionY<size+1 && positionY>-size-1) {
			int direction = rand.nextInt(3);
			if (direction==0){ //case: east
				positionX++;
			}
			else if (direction==1) { //case west
				positionX--;
			}
			else if (direction==2) {//case north
				positionY++;
			}
			else if (direction==3) { //case south
				positionY--;
			}
			distance++;
			printPosition(positionX,positionY);
			randomPrint(positionX,positionY);
			
		}
		System.out.println("Total number of steps = "+distance);
	}
	
	public static void randomPrint(int x, int y) {
		StdDraw.point(x,y);
	}
	
	public static void initializeGraph(int gridsize) {
		StdDraw.setXscale(-gridsize,gridsize);
		StdDraw.setYscale(-gridsize,gridsize);
		StdDraw.setPenRadius(2.0/1000);
	}
	
	public static void printPosition(int x, int y) {
		System.out.println("Position = ("+x+","+y+")");
	}
	
	public static int numberScanner() {
		Scanner console = new Scanner(System.in);
		System.out.println("Enter size of grid: ");
		if (console.hasNextInt()) {
			int input = console.nextInt();
			console.close();
			return input;
		}
		else if (console.hasNextDouble()) {
			System.out.println("Please enter as integer value");
			int input = numberScanner();
			return input;
		}
		else {
			System.out.println("Well, if you do not want to, I can't force you.");
			int input = 0;
			return input;
		}
		
	}

}
