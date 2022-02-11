package week2;
//write a for-loop to produce a power-sequence from powers of x = {1..10}
public class exc1 {
	public static void main(String[] args) {
		easyPower();
		harderPower();
	}

	public static void easyPower() {
		for (int i=1;i<=10;i++) {
			System.out.print(i*i + " ");
		}
		System.out.println("");
	}
	//do it without multiplication-operator
	public static void harderPower() {
		int seqsum = 0;
		for (int i = 1;i<=20;i+=2) {
			seqsum += i;
			System.out.print(seqsum + " ");
		}
	}
}

