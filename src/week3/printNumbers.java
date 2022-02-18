package week3;

public class printNumbers {
	public static void main(String[] args) {
		int maxNum = 1;
		printNumbers(maxNum);
	}
	public static void printNumbers(int k) {
		for (int i=1;i<=k;i++) {
			System.out.print("[" + i + "]");
		}
	}
}
