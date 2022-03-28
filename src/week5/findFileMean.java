package week5;
import java.io.*;
import java.util.*;

public class findFileMean {
	public static void main(String[] args) 
			throws FileNotFoundException {
		Scanner console = new Scanner(System.in);
		System.out.println("Indtast filnavn?");
		String filename =console.next();
		Scanner input = new Scanner(new File(filename));
		while(input.hasNext() && !input.hasNextInt()) {
			input.next();
		}
		
		if(input.hasNextInt()) {
			int counter = 1;
			int sum = input.nextInt();
			while(input.hasNext()) {
				if(input.hasNextInt()) {
					int next = input.nextInt();
					sum+=next;
					counter++;
				}
				else{input.next();}
			}
			System.out.println("Mean is "+(double)sum/counter);	
		}
		else {
			System.out.println("Reached EOF without any integer values");
		}
	}
}
			
	
		
		


