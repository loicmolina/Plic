package plic.arbre.declaration;

import plic.arbre.Classe;
import plic.arbre.expression.Idf;
import plic.exceptions.NonConcordanceException;
import plic.tds.TDS;

public class Instanciation extends Instruction {
	protected Acces acces;
	protected Idf idf;
	
	

	public Instanciation(int no, Acces a , Idf i , int nblc) {
		super(no, nblc);
		acces = a ;
		idf = i;
	}

	@Override
	public void verifier() {
		TDS.getInstance().setBlocCourant(noBloc);
		acces.verifier();
		idf.verifier();
		if (!idf.getType().equals(acces.getIdf().getType())){
			throw new NonConcordanceException("Les deux types ne correspondent pas",noLigne);
		}
		
	}

	@Override
	public String toMIPS() {
		StringBuilder sb = new StringBuilder();
		for (Classe c : TDS.getInstance().getListeClasse()){
			if (c.getIdf().equals(idf.getNom())){
				sb.append(c.toMIPS());
			}
		}
		return sb.toString();
	}

	@Override
	public void ajoutVar() {
		// TODO Auto-generated method stub
		
	}

	
	/*public void addInTable() {
		// TODO Auto-generated method stub
		
	}*/

}
