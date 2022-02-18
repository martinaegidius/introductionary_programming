package week3;

public class repl {
	public static void main(String[] args) {
		String phrase = "skrt";
		phrase = phrase.toUpperCase();
		int numReps = 0;
		repl(phrase,numReps);
		
	}
	public static void repl(String phrase, int numReps) {
		String output = "";
		for(int i=1;i<=numReps;i++) {
			output = output.concat(phrase);
		}
		System.out.println(output);
	}

}
