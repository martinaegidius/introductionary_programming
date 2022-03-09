package aflevering2;

import java.util.Scanner;

public class Palindrome {
	public static void main(String[] args) {
		Scanner console = new Scanner(System.in);
		System.out.print("Enter line to check ");//
		String sequence = console.nextLine();
		isItPalindrome(sequence);
	}
	public static void isItPalindrome(String input) {
		String testInput = input.replaceAll("[^a-zA-Z]+", ""); //replaces all symbols/numbers with nothing
		testInput = testInput.toLowerCase(); //ignore big/small letters
		int length = testInput.length();
		if(length==0) {
			System.out.println("Input does not contain characters at all. Please retry");
			return;
		}
		for (int i=0;i<=length/2-1;i++) {
			if(testInput.charAt(i)!=testInput.charAt(length-i-1) && i<length/2-1) {	 
				System.out.println("\""+input+"\"" + " is not a palindrome.");
				return;
			}
			else if(testInput.charAt(i)==testInput.charAt(length-i-1) && i==length/2-1) {
				System.out.println("\""+input+"\"" + " is a palindrome, when ignoring case, numbers and symbols!");
				return;
			}
		}	
	}
}
