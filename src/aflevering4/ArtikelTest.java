package aflevering4;



public class ArtikelTest {
	public static void main(String[] args) {
		String a = "University Press";
		String b = "Denmark";
		Forlag publisher = new Forlag(a,b);
		Forlag emptyPublisher = new Forlag();
		
		System.out.println(publisher.toString());
		System.out.println(emptyPublisher.toString());
		
		Tidsskrift logic = new Tidsskrift("Journal og Logic");
		System.out.println(logic.toString());
		//logic.setIssn("abc123");
		logic.setForlag("University Press", "Egmonts kælder");
		Tidsskrift brain = new Tidsskrift("Brain");
		System.out.println(brain.toString());
		//logic.setIssn("abc123");
		brain.setForlag("University Press");
		
		
		System.out.println(logic.toString());
		System.out.println(brain.toString());
		
		String[] writers = {"A. Abe &","A Turing"};
		String title = "A";
		Artikel A = new Artikel(writers,title,"Journal of Logic");
		String[] refs = {"B. Bim: “B”. Journal of Logic."};
		A.setReferencelister(refs);
		System.out.println("Artikel 1 er " + A.getString());
		
		writers[0] = "B. Bim";
		title = "B";
		Artikel B = new Artikel(writers,title,"Journal of Logic");
		System.out.println("Artikel 2 er " + B.getString());
		
		
		
		
	}

}
