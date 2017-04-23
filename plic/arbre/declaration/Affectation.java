package plic.arbre.declaration;

import plic.arbre.expression.Expression;
import plic.exceptions.NonConcordanceException;
import plic.tds.TDS;

public class Affectation extends Instruction{
	protected Acces acces;
	protected Expression exp;

	public Affectation(int no, Acces a, Expression e,int nbloc ) {
		super(no, nbloc);
		acces=a;
		exp=e;
	}

	@Override
	public void verifier() {
		TDS.getInstance().setBlocCourant(noBloc);
		exp.verifier();
		acces.verifier();
		TDS.getInstance().setBlocCourant(noBloc);
		if(!acces.getIdf().getType().equals(exp.getType())){
			throw new NonConcordanceException("Les types ne concordent pas !",noLigne);
		}
		
	}

	@Override
	public String toMIPS() {
		StringBuilder sb = new StringBuilder("");
		sb.append("#---Affectation de "+exp+" dans "+acces.getIdf().getNom()+"---\n");
		sb.append(exp.toMIPS());
		sb.append(acces.toMIPS());
		return sb.toString();
	}

	@Override
	public void ajoutVar() {
		// TODO Auto-generated method stub
		
	}

	/*
	public void addInTable() {
		// TODO Auto-generated method stub
		
	}*/

}
