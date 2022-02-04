package week0;

public class rocket_print {
	public static void main(String[] args) {
		complete_rocket();
		
	}

	public static void complete_rocket() {
		roof();
		rocket_block();
		walls();
		rocket_block();
		flag();
		rocket_block();
		walls();
		rocket_block();
		roof();
	}
	
	public static void roof() {
		System.out.println("   /\\");
		System.out.println("  /  \\");
		System.out.println(" /    \\");
	}
	public static void rocket_block() {
		System.out.println("+------+");
	}
	
	public static void walls() {
		System.out.println("|      |");
		System.out.println("|      |");
	}
	
	public static void flag() {
		System.out.println("|United|");
		System.out.println("|States|");
	}

}
