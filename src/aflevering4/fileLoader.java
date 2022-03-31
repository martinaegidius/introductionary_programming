package aflevering4;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.*;

public class fileLoader{

	public static void main(String[] args) throws FileNotFoundException{
	String filename = "src/aflevering4/gol/acorn.gol";
	File f = new File(filename);
	Scanner console = new Scanner(f);
	String holder = "";
	int count = 0;
	while(console.hasNext()) {
		holder += console.next();
		count++;
	}
	console.close();
	double n = Math.sqrt(count);
	int m = (int)n;
	System.out.println("Array dimension: "+ m + " x " + m);
	//construct array 
	
	Scanner console2 = new Scanner(f);
	int[][] template = new int[m][m];
	for(int i=0;i<m;i++) {
		for(int j=0;j<m;j++) {
			template[i][j] = console2.nextInt();
		}	
	}
	console2.close();
	if(template!=null) {
		System.out.println("Template read successfully");
	}
	
		
	}
	

}

