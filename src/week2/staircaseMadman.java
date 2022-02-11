package week2;

//madman-solution to staircase-problem (make it smarter next time)
public class staircaseMadman {
	public static void main(String[] args) {
		int k = 2;
		stairCaller(k);
	}
	
	public static void stairCaller(int k) {
	
		for (int j=1;j<=k;j++) {
			for (int i=k;i>j;i--) {
				System.out.print("      ");
			}
			stairStep1();
			for (int i=1;i<j;i++) {
				System.out.print("      ");
			}
			System.out.println("*");
			
			for (int i=k;i>j;i--) {
				System.out.print("      ");
			}
			stairStep2();
			for (int i=1;i<j*6;i++) {
				System.out.print(" ");
			}
			System.out.println("*");
			
			for (int i=k;i>j;i--) {
				System.out.print("      ");
			}
			stairStep3();
			for (int i=1;i<j*6;i++) {
				System.out.print(" ");
			}
			System.out.println("*");
		}
		//print floor. Each staircase ELEMENT has width 7 chars, and we also need last row element
		for (int i=1;i<=6*k;i++) {
			System.out.print("*");
		}
		System.out.print("******"); //spacer of 6 chars equivalent to size of rhs spacer element
	}
	
	
	public static void stairStep1() {
		System.out.print(" o   ******");
	}
	
	public static void stairStep2() {
		System.out.print("/|\\  *");
		
		}
	
	public static void stairStep3() {
		System.out.print("/ \\  *");
	}
	
	
}
