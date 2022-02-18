package aflevering2;

public class RomanNumerals {
	public static void main(String[] args) {
		int VAL = 1494;
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
			
			//System.out.println(magnitude);
			//System.out.println(length);
			//System.out.println(denominator);
			
			int numberOfReps = VAL/denominator;
			//System.out.println(numberOfReps);
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
				if (Integer.parseInt(length)==2) {
					outString += "L";
				}
				else if (Integer.parseInt(length)==1) {
					outString += "V";
				}
			}
			else {
				if (Integer.parseInt(length)>=4) {
					outString += "M".repeat(numberOfReps);
					}
				if (Integer.parseInt(length)<=3 && Integer.parseInt(length)>2) {
					outString += "C".repeat(numberOfReps);
				}
				if (Integer.parseInt(length)<=2 && Integer.parseInt(length)>1) {
					outString += "X".repeat(numberOfReps);
				}
				if (Integer.parseInt(length)==1) {
					outString += "I".repeat(numberOfReps);
				}
			}	
			return EncodeRoman(VAL,outString);
		}		
	}
}
