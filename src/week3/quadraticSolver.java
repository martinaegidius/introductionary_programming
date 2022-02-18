package week3;

import java.math.*;

public class quadraticSolver {
	/*Analytically based simple solver for subset of second degree 
	  polynomials with real roots*/
	
	public static void main(String[] args) {
		double A = 1;
		double B = 3;
		double C = 2;
		findQuadratic(A,B,C);
	}
	public static void findQuadratic(double a,double b, double c) {
		double X1 = (-b+Math.sqrt(Math.pow(b, 2)-4*a*c))/(2*a);
		double X2 = (-b-Math.sqrt(Math.pow(b, 2)-4*a*c))/(2*a);
		System.out.println("Roots of the simple ppolynomial are: x = "+X1+" and x = "+X2);
	}
}
