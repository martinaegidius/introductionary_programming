package aflevering3;
import java.util.*;

public class PrimeFactors {
    public static void main(String[] args) {
        long input = integerScanner();
        int sentinel = primeFactorization(input);
        while(true) {
        	if (sentinel == -1) {
        		System.out.print("And thus, we are done");
        		break;
        	}
        	else {
        		input = integerScanner();
        		sentinel = primeFactorization(input);
        	}
        }
    }
    
    public static int primeFactorization(long input) {
    	long result;
    	if(input == 0) {
    		return -1;
    	}
    	
    	double upperBound = Math.sqrt((double)input);
        System.out.print("List of prime factors: ");
        if(input==3) { //special case
    		System.out.print("3");
    		return 0;
    	}
        if(input==1) {
        	System.out.print("In modern mathematics, 1 has no prime decomposition");
        	return 0;
        }
        
        for (long i = 2; i <= upperBound+1;){ //max sqrt(n)
        	result = input%i;
        	if(i>upperBound && input!=0 && result!=0) { //if we have reached sqrt(n) and found no decomp
            	System.out.print(input);
            	return 0;
            }
            if (result == 0) {
                if (input/i == 1) { //endpoint of decomposition
                    System.out.print(i);
                    return 0;
                } 
                else if (i==upperBound && result==0) { //square-root-point
                	input = input/i;
                	System.out.print(i + ", ");
                }
                else {
                    input = input / i; //normal point in decomposition
                    System.out.print(i + ", ");
                }
                
            } else {
                    i++; 
            } 
        }
        return 0;
    }

    public static long integerScanner() {
        Scanner console = new Scanner(System.in);
        System.out.print("\nEnter integer greater than 1 (0 to terminate): ");
        long input = 0;
        if(console.hasNextLong()) {
            input = console.nextLong();
            if(input<0) {input=-input;} //take care of negatives
        } else {
            System.out.print("Please enter a valid integer for prime factorization.");
            console.nextLine();
            input = integerScanner();
        }
        return input;
    }
}

/*package aflevering3;
import java.util.*;

public class PrimeFactors {
    public static void main(String[] args) {
        long input = longScanner();

        //long input = 9223372036854775807L;
        long result;
        System.out.println("Input er: " + input);
        for (long i = 2; i <= input;){
            result = input%i;
            if (result == 0) {
            	if(input/i == 1) {
            		input = input/i;
            		System.out.print(i);
            	} else {
            	input = input / i;
                System.out.print(i + ", ");
            	}
            } else {
                i++;
            }
        }
    }
    
    
    
    public static long longScanner() {
        Scanner console = new Scanner(System.in);
        System.out.println("Enter integer greater than 1 (0 to terminate): ");
        long input = 0;
        if(console.hasNextLong()) {
            input = console.nextLong();
        }
        else {
            System.out.println("Please enter a valid integer for prime factorization.");
            console.nextLine();
            longScanner();
        }
        console.close();
        return input;
    }
    
}

*/