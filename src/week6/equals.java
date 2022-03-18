package week6;
import java.util.Arrays;

public class equals {
	public static void main(String[] args) {
		int[][] A = new int[3][2];
		int[][] B = new int[4][2];
		A[0][0] = 1;
		B[0][0] = 1;
		A[1][1] = 3;
		B[1][1] = 3;
		boolean isItEqual = checkEqual(A,B);
		System.out.println(isItEqual);
	}
	public static boolean checkEqual(int[][] A,int[][] B) {
		if(A.length!=B.length || A[0].length!=B[0].length) {
			return false;
		}
		else {
			for(int i=0;i<A.length;i++) { //rows
				for(int j=0;j<A[0].length;j++) { //cols
					if(A[i][j]!=B[i][j]) {
						return false;
					}
				}
			}
			return true;
		}
	}
}
