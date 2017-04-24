package plic.arbre.expression;

import plic.arbre.Classe;
import plic.exceptions.IdentificationException;
import plic.exceptions.TypeInexistantException;
import plic.tds.*;

public class Idf extends Expression{
	public String nom;
	protected Symbole symbole;

	public Idf(int no, String n) {
		super(no);
		nom = n ;
	}

	public String getNom(){
		return nom;
	}
	
	public String getType(){
		Entree e = new Entree(nom);
		
		int currentBloc = TDS.getInstance().getBlocCourant();
		int tmpBloc= TDS.getInstance().getBlocCourant();
		
		while (symbole == null && currentBloc > 0){
		symbole = TDS.getInstance().sortieBloc().identifier(e);
		currentBloc = TDS.getInstance().sortieBloc().getnoBlocEnglobant();
		TDS.getInstance().setBlocCourant(currentBloc);

		}
		
		TDS.getInstance().setBlocCourant(tmpBloc);
		return symbole.getType();
	}
	
	@Override
	public void verifier(){
				
		int currentBloc = TDS.getInstance().getBlocCourant();
		int tmpBloc= TDS.getInstance().getBlocCourant();
		
		while(currentBloc > 0 && symbole==null){
			symbole = TDS.getInstance().sortieBloc().identifier(new Entree(nom));
			currentBloc = TDS.getInstance().sortieBloc().getnoBlocEnglobant();	
			TDS.getInstance().setBlocCourant(currentBloc);
		
		}
		if (symbole==null){
			throw new IdentificationException("La variable n'existe pas",this.getNoLigne());
		}

		TDS.getInstance().setBlocCourant(tmpBloc);
		
		
		//Gestion type idf
		boolean typeCorrect = false;
		if (symbole.getType().equals("entier")){
			typeCorrect = true;
		}
		if (symbole.getType().equals("bool")){
			typeCorrect = true;
		}		
		for (Classe c : TDS.getInstance().getListeClasse()){
			if (symbole.getType().equals(c.getIdf())){
				typeCorrect = true;
			}
		}
		
		if (!typeCorrect){
			throw new TypeInexistantException("Le type de la variable est inexistant",noLigne);
		}
		
	}
	
	public int getDeplacement(){
		return symbole.getPosition();
	}
	

	@Override
	public String toMIPS() {
		StringBuilder sb = new StringBuilder();
		sb.append("#---Recuperation de la variable "+nom+"---\n");
		
		
		if (TDS.getInstance().sortieBloc().identifier(new Entree(this.getNom())) == null){
			//TDS.getInstance().setBlocCourant(TDS.getInstance().sortieBloc().getnoBlocEnglobant());
			sb.append("lw $v0, "+ (symbole.getPosition() + TDS.getInstance().sortieBloc().getTailleZoneVariable())+"($s7)\n\n");
		}else{
			sb.append("lw $v0, "+ symbole.getPosition()+"($s7)\n\n");
		}
		
		return sb.toString() ;
	}

	@Override
	public String toString() {
		return nom;
	}
	

	@Override
	public void ajoutVar() {
		// TODO Auto-generated method stub
		
	}
	
}
