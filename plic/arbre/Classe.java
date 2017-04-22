package plic.arbre;

import plic.arbre.declaration.ListeDeclaration;
import plic.tds.TDS;

public class Classe extends ArbreAbstrait {
	public ListeDeclaration ld ;
	public String idf;
	public boolean isRacine;
	
	public Classe(int no, String identif, ListeDeclaration list) {
		super(no);
		isRacine = false;
		ld = list;
		idf=identif;
		if (ld != null){
			ld.addInTable();
		}
		
		ld.setIdfClasse(idf);
		TDS.getInstance().setBlocCourant(0);
		
	}

	@Override
	public void verifier() {
		if(ld != null){
			ld.verifier();
		}
		
	}
	
	public String getIdf() {
		return idf;
	}

	public void setIdf(String idf) {
		this.idf = idf;
	}

	@Override
	public String toMIPS() {
		if(ld != null)
			return ld.toMIPS();
		else
			return "";
	}

}
