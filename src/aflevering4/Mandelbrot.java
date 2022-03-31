package aflevering4;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Arrays;
import java.util.Random;
import java.util.Scanner;

public class Mandelbrot {
	public static final int MAX = 255; //define class-constant
	public static final int G = 512; //defines grid-size for plots 
	
	public static void main(String[] args) {
		double[] grid = readInput(); //get input from console
		generateGrid(grid); //initialize drawingboard
		fillGrid(grid); //fill grid corresponding to the mandelbrot-set
		
	}
	public static int iterate(Complex z0) { 
		/*function provided by Professor to determine if a number is approximately a part of the mandelbrot-set. 
		If it returns MAX, it is estimated a part of the set.
		*/
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
		System.out.println("Please input grid-center in format re(center) im(center), grid-radius");
		Scanner console = new Scanner(System.in);
		double[] arr = new double[3];
		String line = console.nextLine();
		line = line.replaceAll("[^\\d-.]",","); //regex for keeping only integer-vals and minus-sign. Replace with comma
		String sArr[] = line.split(",");//split comma-seperated elements into String-array
		if (sArr.length!=3) { //if length is not equal to three - else we could limit the str.split()
			System.out.println("Invalid input. Please try again, three numbers with space-delimiter");
			return readInput();
		}
		for(int i=0;i<3;i++) {
			arr[i]=Double.parseDouble(sArr[i]); //convert to double-array
		}
		if(arr[2]<=0) { //if grid-radius is invalid
			System.out.println("Radius is negative or zero. Please try again");
			return readInput();
		}
		console.close();
		return arr;
	}
	
	public static void generateGrid(double[] arr) {
		double S=arr[2];
		StdDraw.setPenColor(StdDraw.BLACK);
		StdDraw.setPenRadius(20.0/1000);
		StdDraw.setXscale(arr[0]-(double)S/2, arr[0]+(double)S/2);
		StdDraw.setYscale(arr[1]-(double)S/2.3,arr[1]+(double)S/2);		
	}

	public static void fillGrid(double[] arr) {
		int[][] colorArr = getColorArr(MAX); //random colormap
		//int[][] colorArr = getColorFromFile("src/aflevering4/blues.mnd"); //for specific colormap
		double x0 = arr[0];
		double y0 = arr[1];
		double S = arr[2];
		double re = 0.0;
		double im = 0.0;
		StdDraw.show(0); //delay plotting
		for(int j = 0; j<=G;j++) { //for all grid-points (real-axis)
			re = x0-(S/2)+(S*j/(G-1)); //use assignment-formula for calculating real value of gridpoint
			for(int k=0;k<=G;k++) {  //for all grid-points (imaginary axis)
				im = y0-(S/2)+(S*k/(G-1)); //formula for converting gridpoint to imaginary part
				Complex z0 = new Complex(re,im); //save the resulting complex number of each gridpoint
				int out = iterate(z0); //check if in mandelbrot using class-constant MAX
				
				if(out==MAX) { //this part necessary in case you only want to plot points in the set (e.g. only fill everything inside of set)
					StdDraw.setPenColor(colorArr[out-1][0],colorArr[out-1][1],colorArr[out-1][2]);
					//StdDraw.setPenRadius(125.0/1000);
					StdDraw.setPenRadius(5.0/1000);
					StdDraw.point(re, im);
				}
				else if (out!=0){ //i dont know why it may return 0, but in some cases it does. Haxy way of avoiding this issue
					StdDraw.setPenColor(colorArr[out-1][0],colorArr[out-1][1],colorArr[out-1][2]); //get color matching the point-value
					StdDraw.setPenRadius(5.0/1000);
					StdDraw.point(re, im);
				}
			}
		}
		StdDraw.show(0);
		
	}
	public static int[][] getColorArr(int MAX){ //generate random color-array with size MAX. 
		int[][] colorArr = new int[MAX][3]; //columns corresponding to R,G,B
		Random rand = new Random();
		for(int i=0;i<MAX;i++) {
			for(int j=0;j<3;j++) {
				colorArr[i][j] = rand.nextInt(256); //get random values
			}
		}
		return colorArr;
	}
	
	public static int[][] getColorFromFile(String path){ //method to read a colormap from a file sourced in path. Only allows 3 columns for R G B, and row-number equal to 255
		int arr[][] = new int[255][3];
		try { //read content from files
			File f = new File(path);
			Scanner fileRead = new Scanner(f);
			if(fileRead.hasNext()) {
				for (int rows = 0; rows < 255; rows++){
					for (int columns = 0; columns < 3; columns++){
						arr[rows][columns] = fileRead.nextInt(); //Only allowing integers
					}
				}
			}
			fileRead.close();
			return arr;
			//if error loading file
			} catch(FileNotFoundException e) {
				System.out.println("Error reading file. Stacktrace:");
				e.printStackTrace();
				return null; //exit
		}		
	}
}
