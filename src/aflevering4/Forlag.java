package aflevering4;

public class Forlag {
	String navn;
	String sted;
		
	public Forlag(String name, String loc) {
		navn = name;
		sted = loc;
	}
			
	public Forlag()
    {
		this("NA","NA");
    }
	
	public String toString() {
		return navn + ", "+ sted;
	}
}

