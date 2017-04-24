package plic.tds;

import plic.arbre.expression.Idf;

public class Entree {
	protected String idf;
	
	public Entree(String s){
		idf = s;
	}
	
	public String getNom(){
		return idf;
	}
	
	public boolean equals(Object o){
		if (o == null){
			return false;
		}
		if (o.getClass() != Entree.class){
			return false;
		}
		Entree e = (Entree)o;
		return idf.equals(e.getNom());
	}
	
	public int hashCode(){
		return idf.hashCode();
	}
}
