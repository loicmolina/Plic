package plic.arbre.declaration;

import plic.arbre.Classe;
import plic.arbre.expression.Idf;
import plic.tds.Entree;
import plic.tds.Symbole;
import plic.tds.TDS;

public class DeclarationChamp extends Declaration{
	
	protected ListeIdf lidf;
	protected String type,statut;

	public DeclarationChamp(String t, String s,  int no, ListeIdf liste ,int nbloc ) {
		super(no, nbloc);
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
		TDS.getInstance().setBlocCourant(noBloc);
		lidf.verifier();
		
	}

	@Override
	public void setNoBlocInstruction() {		
		noBloc = TDS.getInstance().getBlocCourant();		
	}

	@Override
	public void ajoutVar() {
		if(!type.equals("entier")){
			for(Classe c : TDS.getInstance().getListeClasse()){
				if(c.getIdf().equals(type) && !c.getVarAdd()){
					c.ajoutVar();
				}
			}
		}
		int position;
		for(Idf i: lidf.getIterIdf()){
			position = TDS.getInstance().getDico(noBloc).getTailleZoneVariable();
			TDS.getInstance().setBlocCourant(noBloc);
			TDS.getInstance().ajouter(new Entree(i.getNom()), new Symbole(position,type,statut),noLigne);				
		} 
	}

}
