package aflevering3;

public class RaceTrack {
	public static void main(String[] args) {
		int n = 10;
		initializeTrack(n);
		int x = initializePositionX(n);
		int y = initializePositionY(n);
		/*while(x>-n && x<n && (x>n/2 || x<-n/2) && y>-n && y<n && (y>n/2||y<-n/2)){
			int direction = inputScanner();
			x = newPosX(direction);
			y = newPosY(direction);
			plotPos(x,y);
		}
		*/
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
	
	public static int inputScanner() {
		//scan ints blablabla
		return 0;
	}
	
}
