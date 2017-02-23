package plic.arbre.declaration;

import java_cup.runtime.Symbol;
import plic.arbre.ArbreAbstrait;

public class Idf extends ArbreAbstrait{
	public String nom;
	public Symbol symbole;

	public Idf(int no, String n) {
		super(no);
		nom = n ;
	}

	public String getNom(){
		return nom;
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
