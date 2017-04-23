package plic.arbre.declaration;

import plic.arbre.expression.Idf;
import plic.tds.Entree;
import plic.tds.Symbole;
import plic.tds.TDS;

public class DeclarationVar extends Instruction {
	
	protected ListeIdf lidf;
	protected String type;

	public DeclarationVar(String t,int no, ListeIdf liste ,int nbloc ) {
		super(no, nbloc);
		lidf = liste ;
		type = t;
	}

	@Override
	public void verifier() {
		TDS.getInstance().setBlocCourant(noBloc);
		lidf.verifier();
	}

	@Override
	public String toMIPS() {
		return "";
	}

	@Override
	public void ajoutVar() {
		int position;
		for(Idf i: lidf.getIterIdf()){
			position = TDS.getInstance().getDico(noBloc).getTailleZoneVariable();
			TDS.getInstance().ajouter(new Entree(i.getNom()), new Symbole(position,type,"publique"),noLigne);				
		} 
		
	}

}
