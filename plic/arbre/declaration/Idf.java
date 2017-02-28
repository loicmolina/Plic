package plic.arbre.declaration;

import plic.arbre.ArbreAbstrait;
import plic.tds.*;

public class Idf extends ArbreAbstrait{
	public String nom;
	

	public Idf(int no, String n) {
		super(no);
		nom = n ;
	}

	public String getNom(){
		return nom;
	}
	
	public String getType(){
		Symbole s = TDS.getInstance().identifier(new Entree(this));
		return s.getType();
	}
	
	@Override
	public void verifier() {
		
		
	}
	

	@Override
	public String toMIPS() {
		// TODO Auto-generated method stub
		return null;
	}
	
}
