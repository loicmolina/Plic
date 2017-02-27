package plic.arbre.declaration;

import plic.arbre.ArbreAbstrait;

public class Acces extends ArbreAbstrait{
	protected Idf idf;

	public Acces(int no, Idf i) {
		super(no);
		idf=i;
	}

	public Idf getIdf(){
		return idf;
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
