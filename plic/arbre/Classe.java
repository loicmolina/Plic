package plic.arbre;

import plic.arbre.declaration.ListeDeclaration;

public class Classe extends ArbreAbstrait {
	public ListeDeclaration ld ;
	public String idf;
	
	public Classe(int no, String identif, ListeDeclaration list) {
		super(no);
		ld = list;
		idf=identif;
	}

	@Override
	public void verifier() {
		// TODO Auto-generated method stub
		
	}

	@Override
	public String toMIPS() {
		// TODO Auto-generated method stub
		return null;
	}

}
