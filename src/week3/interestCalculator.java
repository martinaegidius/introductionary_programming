package week3;

public class interestCalculator {
	public static void main(String[] args) {
		double INTEREST_RATE = 0.065;
		int NUM_YEARS = 25;
		double INITIAL_INVESTMENT = 100000;
		double YEARLY_INVESTMENT = 100;
		
		CalculateInterest(INTEREST_RATE, NUM_YEARS,INITIAL_INVESTMENT, YEARLY_INVESTMENT);
		
	}
	
	public static void CalculateInterest(double a, int b, double c, double d) {
		double bankStatusStart = c;
		double bankStatusEnd = (c+d);
		System.out.println("Year\t\tStart account value\t\tInterest rate\t\tAdditional investment\t\t End account value");
		//System.out.println("0\t\t"+bankStatusStart+"\t\t\t\t"+a+"\t\t\t"+c+"\t\t\t\t "+bankStatusEnd);
		System.out.println(String.format("0\t\t"+"%e$"+"\t\t\t"+a+"\t\t\t"+d+"$\t\t\t\t "+"%e$",bankStatusStart,bankStatusEnd));
		double multiplicator = 1;
		for(int i=1;i<=b;i++) {
			bankStatusStart = bankStatusEnd;
			bankStatusEnd = (bankStatusStart)*(1+a);
			System.out.println(String.format(i+"\t\t"+"%e$"+"\t\t\t"+a+"\t\t\t"+d+"$\t\t\t\t "+"%e$",bankStatusStart,bankStatusEnd));
		}
	}

}
