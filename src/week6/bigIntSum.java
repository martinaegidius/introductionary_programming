package week6;

import java.util.*;


public class bigIntSum {
	public static void main(String[] args) {
		int DIGITS = 50;
		System.out.println("1st non-negative integer: ");
		int[] A = arrayScanner(DIGITS);
		System.out.println("2nd non-negative integer: ");
		int[] B = arrayScanner(DIGITS);
		int[] C = new int[DIGITS];
		bigSum(A,B,C);
		printSum(C);
		
		
	}
	
	public static int[] arrayScanner(int len) {
		Scanner console = new Scanner(System.in);
		int[] arr = new int[len];
		String line = console.nextLine();
		char[] cArr = line.toCharArray();
		for(int i=0;i<line.length();i++) {
			if(i<len) {
				arr[i]=Character.getNumericValue(cArr[i]);
			}
			else {
				arr[i]=0;
			}
		}
		console.close();
		return arr;
	}
	public static int[] bigSum(int[] A,int[] B,int[] C) {
		for(int i=C.length-1;i>=0;i--) {
			if(i==C.length-1 && A[i]+B[i]+C[i]>9) {
				C[i-1] += 1;
				C[i] += A[i]+B[i]-10;
			}
			
			else if(i==0 && A[i]+B[i]>9) {
				String msg = "Overflow. Sum larger than 50 Digits";
				throw new RuntimeException(msg);
			}
			else {
				if(A[i]+B[i]+C[i]<10) {
					C[i] += A[i]+B[i];
				}
				else{
					C[i-1]+=1;
					C[i]+=A[i]+B[i]-10;
				}
			}
		}
		return C;
	}
	public static void printSum(int[] A) {
		System.out.print("\nSum:");
		for(int i=0;i<A.length;i++) {
			System.out.print(A[i]);
		}
	}
	

}
