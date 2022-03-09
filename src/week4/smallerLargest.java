package week4;
import java.util.*;

public class smallerLargest {
	public static void main(String[] args) {
		Scanner console = new Scanner(System.in);
		smallestLargest(console);		
	}
	public static void smallestLargest(Scanner console) {
		System.out.println("How many numbers do you want to enter?");
		int n;
		if (console.hasNextInt()) {
			n = console.nextInt();
		}
		else {
			System.out.println("You must enter a value");
			n = 0;
		}
		
		int low;
		int high;
		
		if(n>0) {
			low = nextVal(1);
		}
		else {
			System.out.println("No reason to waste compute");
			return;
		}
		high = low;
		for(int i=2;i<=n;i++) {
			
			int val = nextVal(i);
			if(val > high) {
				high = val;
			}
			else if (val<low) {
				low = val;
			}
		}
		System.out.println("Smallest = "+ low);
		System.out.println("Largest = "+ high);
	}
	public static int nextVal(int n) {
		System.out.println("Number " + n);
		Scanner console = new Scanner(System.in);
		if (console.hasNextInt()) {
			return console.nextInt();
		}
		else {
			System.out.println("You must enter a value");
			return nextVal(n);
		}
	}
}
