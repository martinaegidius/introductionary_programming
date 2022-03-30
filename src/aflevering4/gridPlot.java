package aflevering4;

import java.util.*;

public class gridPlot {
	public static void main(String[] args) {
		int[][] arr = new int[6][6];
		for (int[] row:arr)
			Arrays.fill(row,1);
		
		arr[0][0]=0;
		arr[1][1]=0;
		arr[2][2]=0;
		arr[3][3]=0;
		arr[4][4]=0;
		arr[5][5]=0;
		
		StdDraw.setXscale(-0.5,5.5);
		StdDraw.setYscale(5.5,-0.5);
		StdDraw.setPenRadius(10.0/1000);
		//StdDraw.point(2,2);
		//StdDraw.square(2, 2, 0.5);
		for(int i=0;i<6;i++) {
			for(int j=0;j<6;j++) {
				if(arr[i][j]==1) {
					StdDraw.filledRectangle(i, j, 0.5, 0.5);
					StdDraw.point(i, j);
				}
				else {
					StdDraw.square(i, j, 0.5);
				}
			}
		}
		StdDraw.setPenColor(StdDraw.RED);
		StdDraw.filledRectangle(2, 2, 0.5,0.5);
		arr[2][2] = 2;
		
		for(int i=0;i<6;i++) {
			for(int j=0;j<6;j++) {
				System.out.print(arr[i][j] + " ");
			}
			System.out.print("\n");
		}
		System.out.println("");
		
		
	
	}
}
