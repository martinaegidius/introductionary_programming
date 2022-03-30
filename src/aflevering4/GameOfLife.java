package aflevering4;
import java.util.*;

public class GameOfLife {
	int[][] state;
	int size;
	int[][][] cyclicity;
	
	public GameOfLife(int n) { //randomized constructor 
		this.size = n;
		Random rand = new Random();
		state = new int[this.size][this.size];
		for(int i=0;i<this.size;i++) {
			for(int j=0;j<this.size;j++) {
				this.state[i][j] = rand.nextInt(2); //generate dead or alive
			}
		}
	}
	
	public GameOfLife(int[][] initialState) { //constructor from inputarray
		this.size = initialState.length;
		state = new int[this.size][this.size];
		if(initialState.length!=initialState[0].length) {
			System.out.println("Not square input-matrix. Creating random grid with column-length of input-matrix");
			Random rand = new Random();
			for(int i=0;i<initialState.length;i++) {
				for(int j=0;j<initialState.length;j++) {
					this.state[i][j] = rand.nextInt(2); //generate dead or alive
				}
			}
		}
		else {
			for(int i=0;i<this.size;i++) {
				for(int j=0;j<this.size;j++) {
					this.state[i][j] = initialState[i][j];
				}
			}
		}
	}
	
	private int liveNeighbours(int x,int y) { //assess number of neighbours for every cell in state-array
		int num = 0;
		
		if(x!=0&&x!=this.size-1&&y!=0&&y!=this.size-1) { //Base-case. Use different approach for the edge of the game-field
			for(int i=-1;i<=1;i++) {
				num += this.state[x+i][y-1];
				num += this.state[x+i][y+1];
				if(i!=0) {
					num += this.state[x+i][y];
				}
			}
		}
		else {
			if(x==0&&y==0) { //upper left corner
				num = this.state[x+1][y] + this.state[x+1][y+1] + this.state[x][y+1];
			}
			else if(x==this.size-1 && y==this.size-1) { //lower right corner
				num = this.state[x][y-1] + this.state[x-1][y-1] + this.state[x-1][y];
			}
			else if(x==this.size-1 && y==0) { //upper right corner 
				num = this.state[x-1][y] + this.state[x-1][y+1] + this.state[x][y+1];
			}
			
			else if(x==0&&y==this.size-1) { //lower left corner
				num = this.state[x][y-1] + this.state[x+1][y-1]+this.state[x+1][y];
			}
			
			
			else if(x==0&&y!=0&&y!=this.size-1) { //left brim
				num = this.state[x][y+1]+this.state[x+1][y+1] +this.state[x+1][y] + this.state[x+1][y-1] + this.state[x][y-1]; 
			}
			else if(x==this.size-1&&y!=0&&y!=this.size-1) { //right brim
				num = this.state[x][y+1]+this.state[x-1][y+1] +this.state[x-1][y] + this.state[x-1][y-1] + this.state[x][y-1]; 
			}
			
			else if(y==0&&x>0&&x!=this.size-1) { //upper brim
				num = this.state[x-1][y]+this.state[x-1][y+1] +this.state[x][y+1] + this.state[x+1][y+1] + this.state[x+1][y]; 
			}
			else if(y==this.size-1&&x!=0&&x!=this.size-1) { //lower brim
				num = this.state[x-1][y]+this.state[x-1][y-1] +this.state[x][y-1] + this.state[x+1][y-1] + this.state[x+1][y]; 
			}
		}
		return num;
	}
	
	
	public void printNeighbours() { //for debugging - check number of calculated neighbours for each cell
		for(int i=0;i<this.size;i++) {
			for(int j=0;j<this.size;j++) {
				System.out.print(liveNeighbours(i,j)+" ");
			}
			System.out.print("\n");
		}
		
	}
	
	public void nextState(){
		int num = 0;
		int[][] holder = new int[this.size][this.size];
		for(int i=0;i<this.size;i++) {
			for(int j=0;j<this.size;j++) {
				num = liveNeighbours(i,j);
				if(num<2) { //loneliness
					holder[i][j] = 0;
				}
				else if((num==2||num==3)&&this.state[i][j]==1){ //homeostasis
					holder[i][j] = 1;
				}
				else if(num>3) { //lack of space
					holder[i][j] = 0;
				}
				else if(num==3 && this.state[i][j]==0) { //give birth
					holder[i][j]=1;
				}
			}
		}
		//this.cycle1[][] = this.state;
		this.state = holder;
		
		holder = null;
	}
	
	
	public void printGameState() { //simply for debugging
		for(int i=0;i<this.size;i++) {
			for(int j=0;j<this.size;j++) {
				System.out.print(this.state[i][j] + " ");
			}
			System.out.print("\n");
		}
		System.out.println("");
		System.out.println(Arrays.deepToString(this.state).replace("], ", "]\n"));
	}
	
	public void initState() {
		StdDraw.setXscale(-0.5, this.size-0.5);
        StdDraw.setYscale(this.size-0.5, -0.5);
        StdDraw.setPenRadius(10.0/1000);
        //StdDraw.setCanvasSize(512,512);
        StdDraw.setPenColor(StdDraw.BLACK);
        StdDraw.filledRectangle(0, 0, this.size, this.size);
        StdDraw.setPenColor(StdDraw.WHITE);
		
	}
	
	public void drawState() {
		StdDraw.show(10);
		StdDraw.clear(StdDraw.BLACK);
		for(int i=0;i<this.size;i++) {
			for(int j=0;j<this.size;j++) {
				if(this.state[i][j]==1) {
					StdDraw.filledRectangle(j,i,0.5,0.5);
				}
				else {
					//StdDraw.square(i, j, 0.5);
				}
			}
		}
		StdDraw.show(10);
		
		
	}
	
}
