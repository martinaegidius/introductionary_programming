package week6;

public class lastIndexOf {
	public static void main(String[] args) {
		int[] arr = {74,85,102,99,101,85,85};
		int val = 666;
		int loc = getLastIndex(arr,val);
		System.out.println("Last location is: "+loc);
		
	}
	public static int getLastIndex(int[] arr, int val) {
		int n = arr.length;
		int loc = -1;
		for (int i=0;i<n;i++) {
			if (arr[i]==val) {
				loc = i;
			}
		}
		return loc;
	}
}
