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
	
	public ArrayList<Declaration> getAld() {
		return ald;
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
				for(Declaration dl : ald){
					if(dl instanceof DeclarationConst){
						if(!d.equals(dl)){
							if(((DeclarationConst) d).getListparam() != null && ((DeclarationConst) dl).getListparam() != null){
								if(((DeclarationConst) d).getListparam().getAlp().equals(((DeclarationConst) dl).getListparam().getAlp())){
									throw new ConstructeurException("Deux Constructeur avec les même parametre",noLigne);
								}
							}else if (((DeclarationConst) d).getListparam() == null && ((DeclarationConst) dl).getListparam() == null){
								throw new ConstructeurException("Deux Constructeur avec les même parametre",noLigne);

							}
						}
					}
				}
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
