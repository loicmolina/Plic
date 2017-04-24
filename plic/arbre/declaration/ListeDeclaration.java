package plic.arbre.declaration;

import java.util.ArrayList;

import plic.arbre.ArbreAbstrait;
import plic.exceptions.NomClasseConstructeurException;

public class ListeDeclaration extends ArbreAbstrait{	
	public ArrayList<Declaration> ald;
	protected String idfClasse;

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
			if (d instanceof DeclarationConst && !idfClasse.equals(((DeclarationConst) d).getIdf())){
				throw new NomClasseConstructeurException("Le nom du constructeur ne correspond pas � celui de la classe",noLigne);
			}
		}
	}
	
	public void setIdfClasse(String id){
		idfClasse = id;
	}

	@Override
	public String toMIPS() {
		StringBuilder sb = new StringBuilder("");
		for(Declaration d : ald){
			sb.append(d.toMIPS());
		}
		return sb.toString();
	}
	
	public void addInTable(){
		for(Declaration d : ald){
			d.setNoBlocInstruction();
		}
	}

	@Override
	public void ajoutVar() {
		for (Declaration d : ald){
				d.ajoutVar();
		}
	}
}
