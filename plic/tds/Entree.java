package plic.tds;

import plic.arbre.declaration.Idf;

public class Entree {
	protected String entree;
	
	public Entree(Idf e){
		entree=e.getNom();
	}
	
	public String getEntree(){
		return entree;
	}
}
