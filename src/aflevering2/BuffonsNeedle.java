package aflevering2;
import java.util.*;

public class BuffonsNeedle {
    public static void main(String[] args){
        int needle = 1;
        int lineDist = needle*2;
        int max = 1000;
     
        
        int k = 0;
        for(int i = 0; i < max; i++) {
        	Random deg = new Random();
         	double randomDeg = 180 * deg.nextDouble();
        
        	System.out.println("Random Value is: " + randomDeg);
            Random range = new Random();
            double randomRange = lineDist * range.nextDouble();
            System.out.println("Random Range is: " + randomRange);
            double randomRangeInv = lineDist - randomRange;
            double min = Math.min(randomRange, randomRangeInv);
            
	            if(Math.sin(Math.toRadians(randomDeg))*needle > min){
	                k += 1;

	            }
	        System.out.println(k);
        }
    }
}




