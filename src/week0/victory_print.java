package week0;

import java.util.Scanner;

public class victory_print {
	public static void print_fun() {
		System.out.println("//////////////////////");
		System.out.println("|| Victory is mine! ||");
		String call = "\\\\\\\\\\\\\\\\\\\\\\";
		System.out.println(call + call);			
	}

	public static void main(String[] args) {
		System.out.println("Please enter number of prints you wish:\n");
		Scanner sc = new Scanner(System.in);
		int numReps = sc.nextInt();
		for (int i=0; i<numReps; i++) {
			print_fun();
		}
	}
}
 