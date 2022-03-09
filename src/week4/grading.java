package week4;
import java.util.*;

public class grading {
	public static void main(String[] args) {
		int input = numberScanner();
		String newGrade = gradeConversion(input);
		System.out.println(newGrade);
	}
	
	public static int numberScanner() {
		Scanner console = new Scanner(System.in);
		System.out.println("Enter grade to convert: ");
		if (console.hasNextInt()) {
			int input = console.nextInt();
			console.close();
			return input;
		}
		else if (console.hasNextDouble()) {
			System.out.println("Please enter as integer value");
			int input = numberScanner();
			return input;
		}
		else {
			System.out.println("You dont seem to like grades much.");
			int input = 0;
			return input;
		}
		
	}
	
	public static String gradeConversion(int inGrade) {
		if (inGrade==0){
			String outString = "-3"; 
			return outString;
		}
		else if (inGrade == 3) {
			String outString = "00";
			return outString;
		}
		else if (inGrade == 5) {
			String outString = "00";
			return outString;
		}
		else if (inGrade == 6) {
			String outString = "02";
			return outString;
		}
		else if (inGrade == 7) {
			String outString = "4";
			return outString;
		}
		else if (inGrade == 8) {
			String outString = "7";
			return outString;
		}
		else if (inGrade == 9) {
			String outString = "7";
			return outString;
		}
		else if (inGrade == 10) {
			String outString = "10";
			return outString;
		}
		else if (inGrade == 11) {
			String outString = "12";
			return outString;
		}
		else if (inGrade == 13) {
			String outString = "12";
			return outString;
		}
		else {
			String outString = "Error with input (grade undefined). Please try calling function again";
			return outString;
		}
		
	}
	
}
