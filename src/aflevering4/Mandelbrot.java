package aflevering4;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Arrays;
import java.util.Random;
import java.util.Scanner;

public class Mandelbrot {
	public static final int MAX = 255; //define class-constant
	public static final int G = 512;
	//public static final int S = 2;
	public static void main(String[] args) {
		boolean DEBUG = true;
		double[] grid = readInput();
		generateGrid(grid);
		fillGrid(grid);
		
		
		
		
		if(DEBUG==true) {
			System.out.println(Arrays.toString(grid));
			
		}
	
	}
	public static int iterate(Complex z0) {
		Complex z = new Complex(z0);
		for (int i = 0; i < MAX; i++) {
			if (z.abs() > 2.0) {
				return i;
			}
			z = z.times(z).plus(z0);
			}
		return MAX;
	}
	
	public static double[] readInput() {

		System.out.println("Please input grid-center in format center re, center im, radius of grid");
		Scanner console = new Scanner(System.in);
		double[] arr = new double[3];
		String line = console.nextLine();
		line = line.replaceAll("[^\\d-.]",","); //regex for keeping only integer-vals and minus-sign. Replace with comma
		//System.out.println(line);
		String sArr[] = line.split(",");//split comma-seperated elements
		if (sArr.length!=3) { //if length is not equal to three - else we could limit the str.split()
			System.out.println("Invalid input. Please try again");
			return readInput();
		}
		for(int i=0;i<3;i++) {
			arr[i]=Double.parseDouble(sArr[i]);
		}
		if(arr[2]<=0) { //if grid-radius is invalid
			System.out.println("Radius is negative or zero. Please try again");
			return readInput();
		}
		console.close();
		//System.out.println(Arrays.toString(arr));
		return arr;
	}
	
	public static void generateGrid(double[] arr) {
		double S=arr[2];
		StdDraw.setPenColor(StdDraw.BLACK);
		StdDraw.setPenRadius(20.0/1000);
		StdDraw.setXscale(arr[0]-(double)S/2, arr[0]+(double)S/2);
		StdDraw.setYscale(arr[1]-(double)S/2.3,arr[1]+(double)S/2);
		//StdDraw.rectangle(arr[0],arr[1],(double)S/2,(double)S/2);
		//StdDraw.point(arr[0],arr[1]);
		//add grid-points 
		//for(int j=0;j<=G;j++) { //row j
		//	for(int k=0;k<=G;k++) { //column k
				//System.out.println(arr[0]-(double)(S/2)+(S-1)*x/G);
		//		StdDraw.point(arr[0]-(double)(S/2)+(S*j)/(G-1), arr[1]-(double)(S/2)+(S*k)/(G-1));
		//	}
		//}
		
	}

	public static void fillGrid(double[] arr) {
		//int[][] randomColorArr = getColorArr(MAX);
		int[][] randomColorArr = getColorFromFile("src/aflevering4/blues.mnd");
			
		double x0 = arr[0];
		double y0 = arr[1];
		double S = arr[2];
		double re = 0.0;
		double im = 0.0;
		StdDraw.show(0);
		for(int j = 0; j<=G;j++) {
			re = x0-(S/2)+(S*j/(G-1));
			for(int k=0;k<=G;k++) {
				im = y0-(S/2)+(S*k/(G-1));
				Complex z0 = new Complex(re,im);
				int out = iterate(z0);
				
				
				if(out==MAX) { //this part necessary in case you only want to plot points in the set
					StdDraw.setPenColor(randomColorArr[out-1][0],randomColorArr[out-1][1],randomColorArr[out-1][2]);
					//StdDraw.setPenRadius(125.0/1000);
					StdDraw.setPenRadius(5.0/1000);
					StdDraw.point(re, im);
				}
				else if (out!=0){ //i dont know why it may return 0, but in some cases it does
					StdDraw.setPenColor(randomColorArr[out-1][0],randomColorArr[out-1][1],randomColorArr[out-1][2]);
					StdDraw.setPenRadius(5.0/1000);
					StdDraw.point(re, im);
				}
			}
		}
		StdDraw.show(0);
		
	}
	public static int[][] getColorArr(int MAX){ //generate random color-array
		int[][] randomColorArr = new int[MAX+1][3];
		Random rand = new Random();
		for(int i=0;i<MAX+1;i++) {
			for(int j=0;j<3;j++) {
				randomColorArr[i][j] = rand.nextInt(256);
			}
		}
		return randomColorArr;
	}
	
	public static int[][] getColorFromFile(String path){
		int arr[][] = new int[255][3];
		try {
			File f = new File(path);
			Scanner fileRead = new Scanner(f);
			for (int rows = 0; rows < 255; rows++){
			   for (int columns = 0; columns < 3; columns++){
			      arr[rows][columns] = fileRead.nextInt(); 
			      System.out.print((arr[rows][columns]));
			      System.out.print(",");
			   }
			   System.out.print("\n");
			}
			fileRead.close();
			return arr;
			
			} catch(FileNotFoundException e) {
				System.out.println("Error reading file. Stacktrace:");
				e.printStackTrace();
				return null;
		}		
	}
	
}
