package week2;

//print sequences of numbers different times starting and stopping at different places
public class exc2 {
	public static void main(String[] args) {
		int numRows = 5;
		int numReps = 5;
		int startNo = 9;
		int stopNo = 0;
		
		for (int k=1;k<=numRows;k++) {
			for (int j=startNo;j>=stopNo;j--) {	
				for (int i=1;i<=j;i++) {
					System.out.print(j);
				}
			}
			System.out.println("");
		}
	}
}
