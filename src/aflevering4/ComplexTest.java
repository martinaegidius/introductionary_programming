package aflevering4;

public class ComplexTest {
	public static void main(String[] args) {
		Complex z1 = new Complex(1,2); // initialize complex number 1 + 2i
		Complex z2 = new Complex(4,5); // init. 4 + 5i
		System.out.println(z1.plus(z2)); // print sum z1 + z2. Should be 5+7i
		System.out.println(z1.times(z2)); //print z1 times z2. Should be -6.0+13.0i
		Complex z3 = new Complex(z2); //copy-constructor functionality
		System.out.println(z3); //print resultant instance, should be 4+5i
	}
}
