package aflevering3;

import java.util.Scanner;

public class RaceTrack {
	public static void main(String[] args) {
		int n = 10;
		raceTrackGame(n);
		int retry = retryScanner();
		while (retry==1) {
			raceTrackGame(n);
			retry = retryScanner();
		}
		System.out.println("Thank you for playing.");
		return;
		}
	
	
	public static int retryScanner() {
		Scanner console = new Scanner(System.
				in);
		int input = -1;
		System.out.println("Would you like to retry?(1 for yes, 0 for no)");
		if (console.hasNextInt()) {
			input = console.nextInt();
			if(input==0 || input==1) {
				//console.close();
				return input;
			}
			else {return -1;}
		}
				
		else {
			System.out.println("Please enter 0 or 1...: ");
			console.nextLine();
			input = retryScanner();
			return input;
			}
	}
	
	public static void raceTrackGame(int n) {
		initializeTrack(n);
		int distance = 0;
		int x = initializePositionX(n);
		int y = initializePositionY(n);
		int xn = 0;
		int yn = y;
		int velX = 0;
		int velY = 0;
		while(x>-n && x<n && y>-n && y<n && !((x<=n/2 && x>=-n/2) && (y<=n/2 && y>=-n/2))){ //while in boundaries 
			int direction = directionScanner();
			velX += getVelX(direction);
			velY += getVelY(direction);
			System.out.println("VelX is = "+velX + ", velY is = "+velY);
			xn = x + velX;
			yn = y + velY;
			if(xn==0 && x==-1 && yn>=n/2 && yn<=n){
				plotPos(x,y,xn,yn);
				distance ++;
				System.out.println("GOAL! You finished the race in " + distance + "steps!");
				return;
			}
			System.out.println("x = " +x);
			System.out.println("y = " + y);
			plotPos(x,y,xn,yn);
			distance++;
			x = xn;
			y = yn;
		}
		System.out.println("Whoops, you seem to have crashed, buddy!");
		return;
	}
	
	public static void initializeTrack(int n) {
		StdDraw.setXscale(-n-1,n+1);
		StdDraw.setYscale(-n-1,n+1);
		StdDraw.setPenRadius(10.0/1000);//2.0/1000);
		StdDraw.square(0,0,n); //outer-edge
		//track
		StdDraw.setPenColor(StdDraw.GRAY);
		StdDraw.filledSquare(0,0,n); //outer-edge
		
		//grid-lines
		StdDraw.setPenColor(StdDraw.BLACK);
		StdDraw.setPenRadius(2.0/1000);
		for (int i=-n;i<=n;i++) {
			StdDraw.line(-n,i,n,i); //horizontal
			StdDraw.line(i,-n,i,n); //vertical
		}
		//innersquare
		StdDraw.setPenRadius(10.0/1000);//2.0/1000);
		StdDraw.setPenColor(StdDraw.BLACK);
		StdDraw.square(0, 0, n/2);
		StdDraw.setPenColor(StdDraw.WHITE);
		StdDraw.filledSquare(0, 0, n/2); //inner-edge
		
		//startline
		StdDraw.setPenColor(StdDraw.GREEN);
		StdDraw.line(0, n/2, 0, n);
		
		//startpoint
		StdDraw.setPenColor(StdDraw.BLACK);
		StdDraw.point(0, n/2+Math.ceil((double)n/4));
	}
	public static int initializePositionX(int n) {
		return 0;
	}
	public static int initializePositionY(int n) {
		return n/2+(int)Math.ceil((double)n/4);
	}
	
	public static int getVelX(int key) {
		if (key == 6 || key==9 || key==3) {
			int xn = 1;
			return xn;
		}
		else if (key==4||key==7||key==1) {
			int xn = -1;
			return xn;
		}
		
		else {
			return 0;
		}
	}
	public static int getVelY(int key) {
		if (key == 7 || key==8 || key==9) {
			int yn = 1;
			return yn;
		}
		else if (key==1||key==2||key==3) {
			int yn = -1;
			return yn;
		}
		
		else {
			return 0;
		}
	}
	
	public static void plotPos(int x0, int y0, int x1, int y1) {
		StdDraw.setPenColor(StdDraw.RED);
		StdDraw.line(x0, y0, x1, y1);
		StdDraw.setPenColor(StdDraw.BLACK);
		StdDraw.setPenRadius(8.0/1000);
		StdDraw.point(x1, y1);
		StdDraw.setPenRadius(10.0/1000);
		
	}
	
	public static int directionScanner() {
		Scanner console = new Scanner(System.in);
		System.out.println("Enter direction ");
		if (console.hasNextInt()) {
			int input = console.nextInt();
			if(input<0 && input>-10) {
				System.out.println("Invalid input. Converted to positive.");
				//console.close();
				return -input;
			}
			if(input<10 && input>0) {
				//console.close();
				return input;
			}
			//console.close();
			if(input==0 || input<-9 || input >9) {
				System.out.println("Invalid input. Please try again");
				console.nextLine();
				input = directionScanner();
				return input;
			}
			return input;
		}
		else if (console.hasNextDouble()) {
			System.out.println("Double value found. Please enter an integer value");
			console.nextLine();
			int input = directionScanner();
			return input;
		}
		else {
			System.out.println("Error - input was not integer. Please try entering an integer value (0 to terminate): ");
			//console.nextLine();
			int input = directionScanner();
			return input;
		}	
	
	
	}
	
}



