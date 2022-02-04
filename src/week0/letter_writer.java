package week0;

public class letter_writer{
	public static void main(String[] args) {
		frederik();
		oliver();
		andreas();
	}
	
	public static void frederik() {
		generalGreeting();
		System.out.println("Frederik");
		System.out.println("Hvor køber jeg et skotræ?");
		inarb();
		hilsen();
	}
	
	public static void oliver() {
		generalGreeting();
		System.out.println("Oliver");
		inarb();
		System.out.println("Husk at vi skal på bæst");
		hilsen();
		
	}
	public static void andreas() {
		generalGreeting();
		System.out.println("RØØØV");
		System.out.println("fedt med et semester sammen");
		inarb();
		hilsen();
	}

	public static void generalGreeting() {
		System.out.println("Min kære ven ");
	}
	
	public static void inarb() {
		System.out.println("Kan du huske dengang vi havde ingeniørarbejde med de andre?");
	}
	
	public static void hilsen() {
		System.out.println("De bedste hilsener");
		System.out.println("Din gamle ven, Martin");
	}
	
	
}
