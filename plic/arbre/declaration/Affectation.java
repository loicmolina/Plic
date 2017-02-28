package plic.arbre.declaration;

import plic.arbre.ArbreAbstrait;
import plic.arbre.expression.Expression;
import plic.exceptions.NonConcordanceException;

public class Affectation extends Instruction{
	protected Acces acces;
	protected Expression exp;

	public Affectation(int no, Acces a, Expression e) {
		super(no);
		acces=a;
		exp=e;
	}

	@Override
	public void verifier() {
		exp.verifier();
		acces.verifier();
		if(!acces.getIdf().getType().equals(exp.getType())){
			throw new NonConcordanceException("Les types ne concordent pas !",noLigne);
		}
	}

	@Override
	public String toMIPS() {
		// TODO Auto-generated method stub
		return null;
	}

}
