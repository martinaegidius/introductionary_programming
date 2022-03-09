package aflevering2;

import java.util.Scanner;

public class RomanNumerals {
	public static void main(String[] args) {
		int VAL = inputScanner();
		String RomanNumber = EncodeRoman(VAL,"");
		System.out.println(RomanNumber);
	}
	public static String EncodeRoman(int VAL, String outString) {
		if (VAL==0) { //when uninitialized, ie. exhausted of vals
			return outString;
		}
		else {
			String temp = Integer.toString(VAL); 
			String magnitude = Character.toString(temp.charAt(0));
			String length = Integer.toString(temp.length());
			String zeros = "0".repeat(Integer.parseInt(length)-1);
			int denominator = Integer.parseInt(1+zeros);
			int numberOfReps = VAL/denominator;
			int VAL2 = VAL; //copy for later checking, could have been done more efficiently
			VAL = VAL % denominator; //remove first order of magnitude and keep remainder
			
			
			System.out.println("remainder after this step: " +VAL);
			
			if (numberOfReps==9) {
				if (Integer.parseInt(length)>=4) {
					outString += "M".repeat(numberOfReps);
					}
				if (Integer.parseInt(length)<=3 && Integer.parseInt(length)>2) {
					outString += "CM";
				}
				if (Integer.parseInt(length)<=2 && Integer.parseInt(length)>1) {
					outString += "XC";
				}
				if (Integer.parseInt(length)==1) {
					outString += "IX";
				}
			}
			else if(numberOfReps==4) {
				if (Integer.parseInt(length)>=4) {
					outString += "M".repeat(numberOfReps);
					}
				if (Integer.parseInt(length)<=3 && Integer.parseInt(length)>2) {
					outString += "CD";
				}
				if (Integer.parseInt(length)<=2 && Integer.parseInt(length)>1) {
					outString += "XL";
				}
				if (Integer.parseInt(length)==1) {
					outString += "IV";
				}
			}
			else if (numberOfReps == 5) {
				if (Integer.parseInt(length)==4) {
					outString += "V_";
				}
				if (Integer.parseInt(length)==2) {
					outString += "L";
				}
				else if (Integer.parseInt(length)==1) {
					outString += "V";
				}
				else if (Integer.parseInt(length)==3) {
					outString += "D";
				}
			}
			else {
				if (Integer.parseInt(length)>=4) {
					outString += "M".repeat(numberOfReps);
					}
				if (Integer.parseInt(length)<=3 && Integer.parseInt(length)>2) {
					outString += "C".repeat(numberOfReps);
				}
				if (Integer.parseInt(length)<=2 && Integer.parseInt(length)>1 && VAL2>50 && VAL2<90) {
					outString += "L"+"X".repeat(numberOfReps-5);
				}
				if (Integer.parseInt(length)<=2 && Integer.parseInt(length)>1 && VAL2<50) {
					outString += "X".repeat(numberOfReps);
				}
				if (Integer.parseInt(length)==1 && VAL2<5) {
					outString += "I".repeat(numberOfReps);
				}
				if (Integer.parseInt(length)==1 && VAL2>5) {
					outString += "V"+"I".repeat(numberOfReps-5);
				}
				
			}	
			return EncodeRoman(VAL,outString);
		}		
	}
	public static int inputScanner() {
		Scanner console = new Scanner(System.in);
		System.out.print("Enter a positive integer to convert: ");
		while (console.hasNext()) {
			if (console.hasNextInt()) {
				int VAL = console.nextInt();
				return VAL;
			}
			else {
				System.out.println("Invalid input. Please try again with a positive integer.");
				return 0;
			}
		}
		return 0;	
	}	
}
