package week2;

//print sequence of fibonacci numbers from 1 to nums in console
public class fibonacci {
	public static void main(String[] args) {
		int nums = 12;
		fibonacciCaller(nums);
	}
	
	public static int fibonacci(int k) {
		if(k<=1) {
			return k;
		}
		else {
			return fibonacci(k-1)+fibonacci(k-2);
		}
	}
	
	public static void fibonacciCaller(int k) {
		for (int i=1;i<=k;i++) {
			System.out.print(fibonacci(i)+" ");
		}
	}
}
