package plic.arbre.declaration;

import plic.arbre.expression.Idf;
import plic.tds.Entree;
import plic.tds.Symbole;
import plic.tds.TDS;

public class DeclarationChamp extends Declaration{
	
	protected ListeIdf lidf;
	protected String type,statut;

	public DeclarationChamp(String t, String s,int no, ListeIdf liste) {
		super(no);
		lidf = liste ;
		type = t;
		statut = s;
	}

	@Override
	public String toMIPS() {
		return "";
	}

	@Override
	public void verifier() {
		lidf.verifier();
		
	}

	@Override
	public void addInTable() {
		int position;
		for(Idf i: lidf.getIterIdf()){
			position = TDS.getInstance().sortieBloc().getTailleZoneVariable();
			TDS.getInstance().ajouter(new Entree(i.getNom()), new Symbole(position,type,statut),noLigne);				
		} 
	}

}
