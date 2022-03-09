package week4;
import java.util.*;

public class printBogstaver {
	public static void main(String[] args) {
		String inputString = inputScanner();
		splitString(inputString);		
	}
	public static String inputScanner() {
		System.out.println("Enter your string, boi");
		Scanner console = new Scanner(System.in);
		if(!console.hasNext("^[a-zA-Z ]+$")) {
			System.out.println("Error, try again. Please only enter letters");
			console.nextLine();
		}
		String input = console.nextLine();
		console.close();
		return input;
	}
	
	public static void splitString(String in) {
		String spacedOut = "";
		int n = in.length();
		for(int i=0;i<n;i++) {
			spacedOut += in.charAt(i);
			if(i<n-1) {
				spacedOut += "_";
			}
		}
		System.out.println(spacedOut);
	}

}
