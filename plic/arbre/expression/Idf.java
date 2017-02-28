package plic.arbre.expression;

import plic.arbre.ArbreAbstrait;
import plic.exceptions.IdentificationException;
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
		symbole = TDS.getInstance().identifier(e);
		
		return symbole.getType();
	}
	
	@Override
	public void verifier() {
		symbole = TDS.getInstance().identifier(new Entree(nom));
		if (symbole==null){
			throw new IdentificationException("La variable n'existe pas",this.getNoLigne());
		}
	}
	
	public int getDeplacement(){
		return symbole.getPosition();
	}
	

	@Override
	public String toMIPS() {
		StringBuilder sb = new StringBuilder();
		sb.append("#---Récupération de la variable "+nom+"---\n");
		sb.append("lw $v0, "+ symbole.getPosition() + "($s7)\n\n");
		return sb.toString() ;
	}

	@Override
	public String toString() {
		return nom;
	}
	
}
