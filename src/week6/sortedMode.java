package week6;
import java.util.Arrays;

public class sortedMode {
	public static void main(String[] args) {
		int[] arr = {0,0,0,-1,-1,1,1001,3,1001,3,3,-1};
		int mode = findMode(arr);
		System.out.println(mode);
		return;
	}
	public static int findMode(int[] arr) {
		Arrays.sort(arr);
		int foundMode = arr[0];
		int counter = 0;
		int counterNew = 1;
		for(int i=0;i<arr.length-1;i++) {
			if(arr[i]==arr[i+1]) {
				counterNew++;
				if(counterNew>counter) {
					foundMode = arr[i];
					counter = counterNew;
				}
			}
			else {
				counterNew = 1;
			}
		}
		return foundMode;
	}
}
