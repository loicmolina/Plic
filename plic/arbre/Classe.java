package plic.arbre;

import plic.arbre.declaration.ListeDeclaration;

public class Classe extends ArbreAbstrait {
	public ListeDeclaration ld ;
	public String idf;
	
	public Classe(int no, String identif, ListeDeclaration list) {
		super(no);
		ld = list;
		idf=identif;
		ld.addInTable();
	}

	@Override
	public void verifier() {
		if(ld != null){
			ld.verifier();
		}
		
	}

	@Override
	public String toMIPS() {
		if(ld != null)
			return ld.toMIPS();
		else
			return "";
	}

}
