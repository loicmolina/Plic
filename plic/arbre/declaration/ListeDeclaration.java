package plic.arbre.declaration;

import java.util.ArrayList;

import plic.arbre.ArbreAbstrait;
import plic.exceptions.ConstructeurException;

public class ListeDeclaration extends ArbreAbstrait{	
	public ArrayList<Declaration> ald;
	protected String idfClasse;
	protected int nbrConst;

	public ListeDeclaration(int no) {
		super(no);
		ald = new ArrayList<Declaration>();
		nbrConst = 0;
	}
	
	public void ajouter(Declaration d){
		ald.add(d);	
	}
	
	public Declaration getD(int n){
		for(Declaration d : ald){
			if(d instanceof DeclarationConst && ((DeclarationConst) d).getNum() == n){
				return d;
			}
		}
		return ald.get(0);
	}

	@Override
	public void verifier() {
		for(Declaration d : ald){
			d.verifier();
			if (d instanceof DeclarationConst){
				nbrConst ++;
				((DeclarationConst) d).setNum(nbrConst);
			}
			if(nbrConst > 1){
				throw new ConstructeurException("Il y a trop de constructeur",noLigne);
			}
			if (d instanceof DeclarationConst && !idfClasse.equals(((DeclarationConst) d).getIdf())){
				throw new ConstructeurException("Le nom du constructeur ne correspond pas � celui de la classe",noLigne);
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
