package week3;

public class printPowersOfXtoY {
	public static void main(String[] args) {
		int x = 2;
		int y = 17;
		
		printPowersOfXtoY(x,y);
		
	}
	public static void printPowersOfXtoY(int x, int y){
		//print the complete sequence of x to the power of y
		System.out.print("1 ");
		int seqMult = 1;
		for(int i=1;i<=y;i++) {
			seqMult *= x;
			System.out.print(seqMult + " ");
		}
		
	}

}
2