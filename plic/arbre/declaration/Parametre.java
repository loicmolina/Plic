package plic.arbre.declaration;

public class Parametre {

	protected String type, idf;
	
	public Parametre(String t, String i){
		type = t;
		idf = i;
	}

	public String getType() {
		return type;
	}

	public void setType(String t) {
		this.type = t;
	}

	public String getIdf() {
		return idf;
	}

	public void setIdf(String i) {
		this.idf = i;
	}
	
}
