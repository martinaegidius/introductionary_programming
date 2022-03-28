package week5;

import java.util.Scanner;
import java.io.File;

public class readEntireFile {
	public static void main(String[] args) {
		try {
			File file = new File("/home/max/Desktop/s194119/oop/src/week5/problem.html");
			Scanner fileScanner = new Scanner(file);
			//String raw = readFile(fileScanner);
			//System.out.println(raw);
			stripHtmlTags(fileScanner);
			}
		catch(Exception e) {
			e.printStackTrace();
			return;
		}
	}
	
	public static String readFile(Scanner fileScanner) {
		//try {
		String line = "";
		while(fileScanner.hasNextLine()) {
			line += fileScanner.nextLine()+"\n";
			//System.out.println(line);
		}
		//fileScanner.close();
		return line;
	}
	
	public static void stripHtmlTags(Scanner fileScanner) {
		String line = "";
		while(fileScanner.hasNextLine()) {
			line +=fileScanner.nextLine()+"\n";
		}
		line = line.replaceAll("\\<.*?\\>", "");
		//line = line.replaceAll("<.*>|</.*>");
		//line.replaceAll("\\<.*?\\>", "");
		
		System.out.println(line);
	}

}
