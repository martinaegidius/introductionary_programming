package week2;

/*goal: print 
-----1-----
----333----
---55555---
--7777777--
-999999999-
using only loops and print commands*/

public class exc4 {
	public static void main(String[] agrs) {
		printDesign();
	}
	public static void printDesign() {
		for (int j=1;j<=9;j+=2) {
			for (int i=5-(j/2);i>=1;i--) {
				System.out.print("-");
			}
			for (int k=1;k<=j;k++) {
				System.out.print(j);
			}
			
			for (int i=5-(j/2);i>=1;i--) {
				System.out.print("-");
			}
			System.out.println("");
		}
	}	
}

