package aflevering3;
import java.util.*;

public class PrimeFactors2.old {
	public static void main(String[] args) {
		boolean DEBUG = true;
		int input = integerScanner();
		
		//primalFactorization(input);
		boolean prime = isItPrime(input);
		if (DEBUG==true){
			System.out.println("You entered " + input);
			System.out.println(prime);	
		}
		if (prime==true) {
			System.out.println("List of prime factors: " + input);
		}
		else {
			System.out.println("List of prime factors: ");
			int abekat = primalCounter(input);
		}
		
		
	}
	public static int integerScanner() {
		Scanner console = new Scanner(System.in);
		System.out.println("Enter integer greater than 1 (0 to terminate): ");
		int input = 0;
		if(console.hasNextInt()) {
			input = console.nextInt();
		}
		else {
			System.out.println("Please enter a valid integer for prime factorization.");
			console.nextLine();
			integerScanner();
		}
		console.close();
		return input;
	}

	public static int primalCounter(int input) {
		int counter = 2;
		System.out.println("Running primalcounter on "+ input);
		if(counter==input || input==0) {
			System.out.print(counter + ", ");
			return input;
		}
		if (input%counter==0 && isItPrime(counter)==true) {
			System.out.println("I AM SUCCESS");
			System.out.print(counter + ", ");
			return primalCounter(input/counter);
		}
		else {
			//while(isItPrime(counter)==false || (isItPrime(counter)==true && input%counter!=0)) {
			while(true) {
				if(isItPrime(counter)==true && input%counter!=0) {
					System.out.println("I AM BREAK");
					break;
					
				}
				//if (isItPrime(counter)==true) {
					//System.out.println("Next prime counter is " + counter);
				//}
				else {
					System.out.println("I AM INCREMENTING");
					counter += 1;
					if(isItPrime(counter)==true && input%counter==0) {
						break;
					}
				}
			}
			System.out.println("I AM IN ELSE");
			System.out.print(counter + ", ");
			return primalCounter(input/counter);
		}
		
	}
	public static boolean isItPrime(int a) {
		if (a == 2|| a==3) {
			return true;
		}
		if (a<= 1 || a%2 == 0|| a%3 ==0) {
			return false;
		}
		for (int i = 5; i*i <=a; i+= 6){
			if (a%i == 0 || a%(i+2)==0) {
				return false;
			}
		}
		return true;
	}
	
	public static int primalFactorization(int input) {
		return 1;
	}
}
