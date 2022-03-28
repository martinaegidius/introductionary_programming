package aflevering4;

public class Tidsskrift {
	String titel;
	Forlag publisher = new Forlag();
	String issn;

	public Tidsskrift(String input) {
		titel = input;	
		issn = "UNKNOWN";
	}
	
	public void setIssn(String input) {
		issn = input;
	}
	public void setForlag(String name, String loc) {
		publisher.navn = name;
		publisher.sted = loc;
	}
	
	public void setForlag(String name) {
		publisher.navn = name;
	}
	
	
	public String toString() {
		return titel + ", "+ publisher.toString() +", " + issn; 
	}
	
}
