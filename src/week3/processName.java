package week3;

import java.util.Scanner;

public class processName {
	public static void main(String[] args) {
		Scanner console = new Scanner(System.in);
		System.out.println("Please enter your full name: ");
		String name = console.next();
		String midname = console.next();
		String surname = console.nextLine();
	
		System.out.println("Your name in reverse order is " + surname + " " + midname +" " + name);
		
	}

}
