package plic.arbre.declaration;

import java.util.ArrayList;

import plic.arbre.ArbreAbstrait;

public class ListeDeclaration extends ArbreAbstrait{
	
	public ArrayList<Declaration> ald;

	public ListeDeclaration(int no) {
		super(no);
		ald = new ArrayList<Declaration>();
	}
	
	public void ajouter(Declaration d){
		ald.add(d);	
	}

	@Override
	public void verifier() {
		for(Declaration d : ald){
			d.verifier();
		}
	}

	@Override
	public String toMIPS() {
		StringBuilder sb = new StringBuilder("");
		for(Declaration d : ald){
			sb.append(d.toMIPS());
		}
		return sb.toString();
	}
	

}
