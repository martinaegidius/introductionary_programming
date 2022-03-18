package week6;

public class countInRange {
	public static void main(String[] args) {
		int[] arr = {74,2,102,17,101,85,1};
		int min = 2;
		int max = 17;
		int num = getCount(arr,min,max);
		System.out.println("Count is: "+num);	
	}
	public static int getCount(int[] arr,int min,int max) {
		int counter = 0;
		for(int i=0;i<arr.length;i++) {
			if(arr[i]>=min && arr[i]<=max) {
				counter++;
			}	
		}
		return counter;
	}
}
