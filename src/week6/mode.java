package week6;

public class mode {
	public static void main(String[] args) {
		int[] arr = {27,15,15,11,27,1500,1700,1500,1500};
		int mode = mode(arr);
		System.out.println(mode);
	}
	public static int mode(int[] arr) {
		int len = findMax(arr);
		int[] modeHolder = new int[len];
		
		for (int i=0;i<len;i++) {
			int counter = 0;
			for (int j=0;j<arr.length;j++) {
				if(arr[j]==i) {
					counter++;
				}
			}
			modeHolder[i] = counter;
		}
		int maxOcc = 0;
		int maxVal = -1;
		for (int i=0;i<len;i++) {
			if(modeHolder[i]>maxOcc) {
				maxOcc = modeHolder[i];
				maxVal = i;
			}
		}
		return maxVal;
	}
	public static int findMax(int[] arr) {
		int maxVal = arr[0];
		for(int i=1;i<arr.length;i++) {
			if(arr[i]>maxVal) {
				maxVal = arr[i];
			}
		}
		return maxVal;
	}
}
