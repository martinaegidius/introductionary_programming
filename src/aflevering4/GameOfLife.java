package aflevering4;
import java.util.*;
import java.io.*;
/* Class made for creating instances of Conway's Game Of Life. 
 * The class has two fields; 
 * 		1. state: this field is a 2D integer-array used to store binary values. These represent the cells status with 0 = dead, 1 = alive. 
 * 		2. size: this field is used to save the array-dimensions of the square-shaped state-array (N x N).
 * Three constructors are provided: 
 * 		1. input: integer-value N, result: generates a random GameOfLife object with size = N x N.
 * 		2. input: integer 2D-array of size N x N, result: Generates a GameOfLife object with the cells stored in the matrix. It is clients responsibility to check for a clean array.
 *  	3. input: string and boolean, result: Generates a GameOfLife object from a valid template-file given in string. Boolean true gives zero-padding to a gamesize of 512x512. Else the gamesize is equal to the number of read dimensions.
 *  
 * To create a running instance of the game: 
 * 		1. Use one of the three constructors 
 * 		2. Use instance.nextState(); to calculate the next gamestate
 * 		3. Use instance.drawState(); to draw the resulting field. Dependency: this method uses StdDraw, and is prepackaged with this class.
 * 				3.1) The method has a variable, frameSpeed, which is obligatory. It defines the duration between each frame in ms. 
 * 
 * 
 * Developed by Oliver Zacho and Martin Maximilian Ægidius, 2022, Danmarks Tekniske Universitet
 */


public class GameOfLife {
	int[][] state;
	int size;
	
	public GameOfLife(int n) {
		/* Constructs a square-shaped, randomized game-of-life state with dimensions n x n. 
		*/
		this.size = n;
		Random rand = new Random();
		state = new int[this.size][this.size];
		for(int i=0;i<this.size;i++) {
			for(int j=0;j<this.size;j++) {
				this.state[i][j] = rand.nextInt(2); //generate dead or alive
			}
		}
	}
	
	public GameOfLife(int[][] initialState) { 
		/*constructs from parsed integer-array. Only checks if array is square. Input must be binary and integer. 
		 *If array is not square-shaped, a random array is initialized with number of rows in provided array, analogous to GameOfLife(int n). 
		 */
		this.size = initialState.length;
		state = new int[this.size][this.size];
		if(initialState.length!=initialState[0].length) {
			System.out.println("Not square input-matrix. Creating random grid with column-length of input-matrix");
			Random rand = new Random();
			for(int i=0;i<initialState.length;i++) {
				for(int j=0;j<initialState.length;j++) {
					this.state[i][j] = rand.nextInt(2); //get random binary value
				}
			}
		}
		else { //matrix loaded successfully
			for(int i=0;i<this.size;i++) {
				for(int j=0;j<this.size;j++) {
					this.state[i][j] = initialState[i][j];
				}
			}
		}
	}
	
	public GameOfLife(String filename, boolean padding) throws FileNotFoundException{
			/* Load template-matrix from file filename. Template-file must be a squarer binary integer-matrix delimited by white-space-characters.
			 * padding = true: zero-pads the loaded template, thus resulting in a 512x512-state-matrix.
			 * padding = false: no zero-padding; world-size is equivalent to template-files dimensions.
			 */
			File f = new File(filename);
			Scanner console = new Scanner(f);
			int count = 0; 
			while(console.hasNext()) {//find number of cells in file
				console.next();
				count++;
			}
			console.close(); //close leaks
			double n = Math.sqrt(count);
			int m = (int)n; //should only typecast, no rounding as long as read array is not faulty
			System.out.println("Array dimension: "+ m + " x " + m);
			//construct corresponding array:
			Scanner console2 = new Scanner(f);
			int[][] template = new int[m][m];
			for(int i=0;i<m;i++) {
				for(int j=0;j<m;j++) {
					template[i][j] = console2.nextInt();
				}	
			}
			console2.close(); //no leaks
			if(template!=null) { //checks if array has become initialized.
				System.out.println("Template read successfully");
			}
			if(padding == false) { //if client-script requests no zero-padding
				this.size = m;
				this.state = template;
			}	
			else { //if padding is requested
				this.size = 512; //final size of padded gamestate-array
				this.state = new int[this.size][this.size]; //initialize state
				for (int[] row:this.state) //zero-fill array (m x m wasted operations here)
					Arrays.fill(row,0);
				
				for(int i=0;i<m;i++) { // overwrite middle area of state with state read from file
					for(int j=0;j<m;j++) {
						this.state[i+(this.size/2)][j+(this.size/2)] = template[i][j];
					}
				}
			}
	}


	
	
	private int liveNeighbours(int x,int y) { //assess number of neighbours for every cell in current state.
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
	
	
	public void printNeighbours() { //method for debugging - prints the output of the liveNeighbours method to the console. 
		for(int i=0;i<this.size;i++) {
			for(int j=0;j<this.size;j++) {
				System.out.print(liveNeighbours(i,j)+" ");
			}
			System.out.print("\n");
		}
	}
	
	public void nextState(){ //method for getting next state of game as a function of this.state (current state). 
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
		this.state = holder;
		holder = null; //cleaning up after ourselves :-) 
	}
	
	
	public void printGameState() { //method simply for debugging. Prints game-state to console.
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
		StdDraw.setCanvasSize(1024,1024); //could be made variable after request
		StdDraw.setXscale(-0.5, this.size-0.5);
        StdDraw.setYscale(this.size-0.5, -0.5);
        StdDraw.setPenRadius(10.0/1000);
        StdDraw.setPenColor(StdDraw.BLACK);//initializing background
        StdDraw.filledRectangle(0, 0, this.size, this.size); //initializing background
        StdDraw.setPenColor(StdDraw.WHITE); //color live cells white
		
	}
	
	public void drawState(int frameSpeed) {
		StdDraw.show(frameSpeed); //wait with drawing
		StdDraw.clear(StdDraw.BLACK); //clear the frame for everything *except* black color (background)
		for(int i=0;i<this.size;i++) {
			for(int j=0;j<this.size;j++) {
				if(this.state[i][j]==1) {
					StdDraw.filledRectangle(j,i,0.5,0.5);
				}
			}
		}
		StdDraw.show(frameSpeed); //draw now after framwSpeed ms
	}
}
