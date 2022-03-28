package aflevering4;
import java.util.Arrays;

public class Artikel {
	String[] forfattere;
	String titel;
	Tidsskrift tidsskrift = new Tidsskrift("null");
	String[] referenceliste;
	
	public Artikel(String[] writers, String title, String paper) {
		this.forfattere = writers;
		this.titel = title; 
		this.tidsskrift = new Tidsskrift(paper);
	}
	public void setReferencelister(String[] refs) {
		this.referenceliste = refs;
	}
	
	public String getString() {
		String output = (Arrays.toString(forfattere)+": "+titel+" in: "+ tidsskrift.titel+ ", "+Arrays.toString(referenceliste));
		return output;
	}
}
